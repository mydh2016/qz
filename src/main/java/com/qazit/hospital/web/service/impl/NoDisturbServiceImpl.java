package com.qazit.hospital.web.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.dao.mapper.TNoDisturbMapper;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.TNoDisturb;
import com.qazit.hospital.web.model.TNoDisturbExample;
import com.qazit.hospital.web.model.TNoDisturbExample.Criteria;
import com.qazit.hospital.web.service.NoDisturbService;
import com.qazit.sysmanager.web.security.UserSessionOperator;
@Service("noDisturbService")
public class NoDisturbServiceImpl extends BaseService implements NoDisturbService{
	@Autowired
	private TNoDisturbMapper dao;
	/**
	 * 根据主键删除
	 * @param id
	 * @return
	 */
	public JsonModel deleteByPrimaryKey(Integer id,JsonModel json){
		try {
			dao.deleteByPrimaryKey(id);
			json.setJsonData("0", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "删除异常");
		}
		return json;
	};
	/**
	 * 保存
	 * @param record
	 * @return
	 */
	public JsonModel insertSelective(TNoDisturb record,JsonModel json){
		if(record==null||StringUtils.isBlank(record.getTelphone())){
			json.setJsonData("1", "必填字段不能为空");
		}else{
			try {
				TNoDisturbExample example=new TNoDisturbExample();
				Criteria cr=example.createCriteria();
				cr.andTelphoneEqualTo(record.getTelphone());
				cr.andCreaterIdEqualTo(UserSessionOperator.getCurrentUserId());
				List<TNoDisturb> exampleList=dao.selectByExample(example);
				if(exampleList==null||exampleList.isEmpty()){
					record.setCreateTime(new Date());
					record.setCreaterId(UserSessionOperator.getCurrentUserId());
					record.setHpId(UserSessionOperator.getCurrentHospitalId()+"");
					dao.insertSelective(record);
					json.setJsonData("0", "保存成功");
				}else{
					json.setJsonData("2", "该手机号已添加");
				}	
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("3", "保存异常");
			}
		}
		return json;
	};
	/**
	 * 根据主键查询患者通讯录
	 * @param id
	 * @return
	 */
	public JsonModel selectByPrimaryKey(Integer id,JsonModel json){
		try {
			TNoDisturb tNoDisturb=dao.selectByPrimaryKey(id);
			json.setJsonData("0", tNoDisturb);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("1", "查询异常");
		}
		return json;
	};
	/**
	 * 查询患者通讯录
	 * @param example
	 * @return
	 */
	public JsonModel selectByExample(TNoDisturb record,AbstractPage page,JsonModel json){
		try {
			TNoDisturbExample example=null;
			if(record!=null){
				example=new TNoDisturbExample();
				Criteria cri=example.createCriteria();
				String name=record.getName();
				String telphone=record.getTelphone();
				String category=record.getCategory();
				if(!StringUtils.isBlank(name)){
					cri.andNameLike('%'+name+'%');
				}
				if(!StringUtils.isBlank(telphone)){
					cri.andTelphoneLike('%'+telphone+'%');
				}
				if(!StringUtils.isBlank(category)){
					cri.andCategoryLike('%'+record.getCategory()+'%');
				}
				cri.andCreaterIdEqualTo(UserSessionOperator.getCurrentUserId());
				if(page!=null){
					example.setOrderByClause("create_time desc limit "+page.getFirstRecord()+","+page.getPageSize());
				}
			}
			List<TNoDisturb> patientList=dao.selectByExample(example);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("dataList", patientList);
			map.put("pageCountAll", this.dao.countByExample(example));
			json.setJsonData("0", map);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "查询异常");
		}
		return json;
	};
	/**
	 * 根据主键修改患者信息
	 * @param record
	 * @return
	 */
	public JsonModel updateByPrimaryKeySelective(TNoDisturb record,JsonModel json){
		if(record==null||StringUtils.isBlank(record.getTelphone())){
			json.setJsonData("1", "必填字段不能为空");
		}else{
			try {
				TNoDisturbExample example=new TNoDisturbExample();
				Criteria cri=example.createCriteria();
				cri.andIdNotEqualTo(record.getId());
				cri.andTelphoneEqualTo(record.getTelphone());
				List<TNoDisturb> exampleList=dao.selectByExample(example);
				if(exampleList==null||exampleList.isEmpty()){
					dao.updateByPrimaryKey(record);
					json.setJsonData("0", "保存成功");
				}else{
					json.setJsonData("2", "该手机号已存在");
				}	
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("3", "保存异常");
			}
		}
		return json;
	};
}
