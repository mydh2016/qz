package com.qazit.hospital.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.dao.mapper.DepartmentMapper;
import com.qazit.hospital.web.model.DepartmentExample;
import com.qazit.hospital.web.model.DepartmentExample.Criteria;
import com.qazit.hospital.web.model.DepartmentWithBLOBs;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.service.DepartmentService;
import com.qazit.sysmanager.web.security.UserSessionOperator;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentMapper dao;
	/**
	 * 添加科室
	 * @param dp
	 * @param json
	 * @return
	 */
	public JsonModel insert(DepartmentWithBLOBs  dp,JsonModel json){
		if(dp==null){
			json.setJsonData("2", "参数错误");
			return json;
		}else{
			if(dp.getDptId()==0){
				json.setJsonData("3", "请选择科室类型");
				return json;
			}
			if(StringUtils.isBlank(dp.getDepartmentName())){
				json.setJsonData("3", "科室名字为必填项");
				return json;
			}
			if(StringUtils.isBlank(dp.getTelphone())){
				json.setJsonData("3", "科室电话为必填项");
				return json;
			}
		}
		try {
			DepartmentExample dpe=new DepartmentExample();
			Criteria cr=dpe.createCriteria();
			cr.andDepartmentNameEqualTo(dp.getDepartmentName());
			List<DepartmentWithBLOBs>  dpwbList=dao.selectByExampleWithBLOBs(dpe);
			if(dpwbList==null||dpwbList.isEmpty()){
				dp.setHspId(UserSessionOperator.getCurrentHospitalId()+"");
				dao.insertSelective(dp);
				json.setJsonData("0", "保存成功");
			}else{
				json.setJsonData("4", "该科室已存在");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("1", "保存异常");
		}
		return json;
	};
	/**
	 * 删除科室类型
	 * @param departmentId
	 * @param json
	 * @return
	 */
	public JsonModel delete(Integer departmentId,JsonModel json){
		try {
			dao.deleteByPrimaryKey(departmentId);
			json.setJsonData("0", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("1", "删除异常");
		}
		return json;
	};
	/**
	 * 更新科室信息
	 * @param dp
	 * @param json
	 * @return
	 */
	public JsonModel update(DepartmentWithBLOBs dp,JsonModel json){
		if(dp==null){
			json.setJsonData("2", "参数错误");
			return json;
		}else{
			if(dp.getDptId()==0){
				json.setJsonData("3", "请选择科室类型");
				return json;
			}
			if(StringUtils.isBlank(dp.getDepartmentName())){
				json.setJsonData("3", "科室名字为必填项");
				return json;
			}
			if(StringUtils.isBlank(dp.getTelphone())){
				json.setJsonData("3", "科室电话为必填项");
				return json;
			}
		}
		try {
			DepartmentExample dpe=new DepartmentExample();
			Criteria cr=dpe.createCriteria();
			cr.andDepartmentNameEqualTo(dp.getDepartmentName());
			cr.andDepartmentIdNotEqualTo(dp.getDepartmentId());
			List<DepartmentWithBLOBs>  dpwbList=dao.selectByExampleWithBLOBs(dpe);
			if(dpwbList==null||dpwbList.isEmpty()){
				dp.setHspId(UserSessionOperator.getCurrentHospitalId()+"");
				dp.setHspName("测试");
				dao.updateByPrimaryKeyWithBLOBs(dp);
				json.setJsonData("0", "修改成功");
			}else{
				json.setJsonData("4", "该科室已存在");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("1", "修改异常");
		}
		
		return json;
	};
	/**
	 * 查询某个科室
	 * @param departmentId
	 * @param json
	 * @return
	 */
	public JsonModel selectById(Integer departmentId,JsonModel json){
		if(departmentId==null){
			json.setJsonData("1", "参数错误");
			return json;
		}
		DepartmentWithBLOBs dpt=dao.selectByPrimaryKey(departmentId);
		if(dpt==null){
			json.setJsonData("2", "没有查到该科室");
		}else{
			json.setJsonData("0", dpt);
		}
		return json;
	};
	/**
	 * 查询科室列表
	 * @param dp
	 * @param page
	 * @param json
	 * @return
	 */
	public JsonModel selectForList(DepartmentWithBLOBs dp,AbstractPage page,JsonModel json){
		DepartmentExample example=new DepartmentExample();
		Criteria cr=example.createCriteria();
		cr.andHspIdEqualTo(UserSessionOperator.getCurrentHospitalId()+"");
		if(dp==null){
			if(page!=null){
				example.setOrderByClause("DEPARTMENT_ID desc limit "+page.getFirstRecord()+","+page.getPageSize());
			}
		}else{
			if(!StringUtils.isBlank(dp.getDepartmentName())){
				cr.andDepartmentNameLike("%"+dp.getDepartmentName()+"%");
			}
			if(!StringUtils.isBlank(dp.getTelphone())){
				cr.andTelphoneLike("%"+dp.getTelphone()+"%");
			}
			if(page!=null){
				example.setOrderByClause("DEPARTMENT_ID desc limit "+page.getFirstRecord()+","+page.getPageSize());
			}
		}
		List<DepartmentWithBLOBs> dpList=dao.selectByExampleWithBLOBs(example);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("dataList", dpList);
		map.put("pageCountAll", this.dao.countByExample(example));
		json.setJsonData("0",map);
		return json;
	};
	/**
	 * 根据科室id查询科室名字
	 * @return
	 */
	public JsonModel selectIdToName(Integer departmentId,JsonModel json){
		List<String> nameList=this.dao.selectIdToName(departmentId);
		json.setJsonData("0",nameList);
		return json;
	};
	/**
	 * 查询科室列表
	 * @param page
	 * @param json
	 * @return
	 */
	public JsonModel selectList(JsonModel json){
		DepartmentExample example=new DepartmentExample();
		Criteria cr=example.createCriteria();
		cr.andHspIdEqualTo(UserSessionOperator.getCurrentHospitalId()+"");
		List<DepartmentWithBLOBs> dpList=dao.selectByExampleWithBLOBs(example);
		json.setJsonData("0",dpList);
		return json;
	};
	/**
	 * 根据名字查科室id
	 * @param departmentName
	 * @param hspId
	 * @return
	 */
	public List<Integer> selectNameToId(String departmentName,String hspId){
		Map<String,Object>map=new HashMap<String, Object>();
		map.put("departmentName", departmentName);
		map.put("hspId", hspId);
		return this.dao.selectNameToId(map);
	};
}
