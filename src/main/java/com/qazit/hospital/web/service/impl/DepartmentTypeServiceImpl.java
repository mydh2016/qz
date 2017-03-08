package com.qazit.hospital.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.dao.mapper.DepartmentTypeMapper;
import com.qazit.hospital.web.model.DepartmentType;
import com.qazit.hospital.web.model.DepartmentTypeExample;
import com.qazit.hospital.web.model.DepartmentTypeExample.Criteria;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.service.DepartmentTypeService;
import com.qazit.sysmanager.web.security.UserSessionOperator;
@Service("departmentTypeService")
public class DepartmentTypeServiceImpl implements DepartmentTypeService{
	@Autowired
	private DepartmentTypeMapper dao;
	/**
	 * 添加科室类型
	 * @param dpt
	 * @param json
	 * @return
	 */
	public JsonModel insert(DepartmentType dpt,JsonModel json){
		try {
			DepartmentTypeExample example=new DepartmentTypeExample();
			Criteria cr=example.createCriteria();
			cr.andDepartmentTypeNameEqualTo(dpt.getDepartmentTypeName());
			cr.andHpIdEqualTo(UserSessionOperator.getCurrentHospitalId()+"");
			List<DepartmentType> dptList=dao.selectByExample(example);
			if(dptList==null||dptList.isEmpty()||dptList.size()==0){
				dpt.setHpId(UserSessionOperator.getCurrentHospitalId()+"");
				dao.insertSelective(dpt);
				json.setJsonData("0", "保存成功");
			}else{
				json.setJsonData("1", "该类型已存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("1", "保存异常");
		}
		
		return json;
		
	};
	/**
	 * 删除科室类型
	 * @param departmentTypeId
	 * @param json
	 * @return
	 */
	public JsonModel delete(Integer departmentTypeId,JsonModel json){
		try {
			dao.deleteByPrimaryKey(departmentTypeId);
			json.setJsonData("0", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("1", "删除异常");
		}
		return json;
	};
	/**
	 * 更新科室类型
	 * @param dp
	 * @param json
	 * @return
	 */
	public JsonModel update(DepartmentType dpt,JsonModel json){
		try {
			DepartmentTypeExample example=new DepartmentTypeExample();
			Criteria cr=example.createCriteria();
			cr.andDepartmentTypeIdNotEqualTo(dpt.getDepartmentTypeId());
			cr.andDepartmentTypeNameEqualTo(dpt.getDepartmentTypeName());
			List<DepartmentType> dptList=dao.selectByExample(example);
			if(dptList==null||dptList.isEmpty()||dptList.size()==0){
				dao.updateByPrimaryKey(dpt);
				json.setJsonData("0", "修改成功");
			}else{
				json.setJsonData("1", "该类型已存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("1", "修改异常");
		}
		
		return json;
	};
	/**
	 * 查询某个科室类型
	 * @param departmentTypeId
	 * @param json
	 * @return
	 */
	public JsonModel selectById(Integer departmentTypeId,JsonModel json){
		if(departmentTypeId==null){
			json.setJsonData("1", "参数错误");
			return json;
		}
		DepartmentType dpt=dao.selectByPrimaryKey(departmentTypeId);
		if(dpt==null){
			json.setJsonData("1", "没有查到该类型");
		}else{
			json.setJsonData("0", dpt);
		}
		return json;
	};
	/**
	 * 查询可是类型列表
	 * @param dp
	 * @param page
	 * @param json
	 * @return
	 */
	public JsonModel selectForList(DepartmentType dpt,AbstractPage page,JsonModel json){
		DepartmentTypeExample example=new DepartmentTypeExample();
		Criteria cr=example.createCriteria();
		cr.andHpIdEqualTo(UserSessionOperator.getCurrentHospitalId()+"");
		if(dpt==null){
			if(page!=null){
				example.setOrderByClause("DEPARTMENT_TYPE_ID desc limit "+page.getFirstRecord()+","+page.getPageSize());
			}
		}else{
			if(!StringUtils.isBlank(dpt.getDepartmentTypeName())){
				cr.andDepartmentTypeNameLike("%"+dpt.getDepartmentTypeName()+"%");
			}
			if(page!=null){
				example.setOrderByClause("DEPARTMENT_TYPE_ID desc limit "+page.getFirstRecord()+","+page.getPageSize());
			}
		}
		List<DepartmentType> dptList=dao.selectByExample(example);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("dataList", dptList);
		map.put("pageCountAll", this.dao.countByExample(example));
		json.setJsonData("0",map);
		return json;
	};
}
