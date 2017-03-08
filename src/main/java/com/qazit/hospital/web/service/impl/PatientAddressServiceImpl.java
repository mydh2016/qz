package com.qazit.hospital.web.service.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.util.ExportExcel;
import com.qazit.hospital.web.dao.mapper.PatientAddressMapper;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.PatientAddress;
import com.qazit.hospital.web.model.PatientAddressExample;
import com.qazit.hospital.web.model.PatientAddressExample.Criteria;
import com.qazit.hospital.web.service.PatientAddressService;
import com.qazit.sysmanager.web.security.UserSessionOperator;

@Service("patientAddressService")
public class PatientAddressServiceImpl extends BaseService implements PatientAddressService{
	@Autowired
	private PatientAddressMapper dao;
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
	 * 插入患者通讯录
	 * @param record
	 * @return
	 */
	public JsonModel insertSelective(PatientAddress record,String dateBirth,JsonModel json){
		if(record==null||StringUtils.isBlank(record.getTelphone())){
			json.setJsonData("1", "必填字段不能为空");
		}else{
			try {
				PatientAddressExample example=new PatientAddressExample();
				example.createCriteria().andTelphoneEqualTo(record.getTelphone());
				List<PatientAddress> exampleList=dao.selectByExample(example);
				if(exampleList==null||exampleList.isEmpty()){
					if (!StringUtils.isBlank(dateBirth)){
						SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
						record.setDateBirth(sf.parse(dateBirth));
					}
					record.setCreateTime(new Date());
					record.setState(0);
					record.setHpId(UserSessionOperator.getCurrentHospitalId()+"");
					record.setCreaterId(UserSessionOperator.getCurrentUserId());
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
			PatientAddress patientAddress=dao.selectByPrimaryKey(id);
			json.setJsonData("0", patientAddress);
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
	public JsonModel selectByExample(PatientAddress record,String look,String beginTime,String endTime,AbstractPage page,JsonModel json){
		try {
			PatientAddressExample example=null;
			example=new PatientAddressExample();
			Criteria cri=example.createCriteria();
			if(record!=null){
				String name=record.getName();
				String telphone=record.getTelphone();
				Integer sex=record.getSex();
				
				String category=record.getCategory();
				String address=record.getAddress();
				String unit=record.getUnit();
				cri.andStateEqualTo(0);
				if(!StringUtils.isBlank(name)){
					cri.andNameLike('%'+name+'%');
				}
				if(!StringUtils.isBlank(telphone)){
					cri.andTelphoneLike('%'+telphone+'%');
				}
				if(sex!=null){
					cri.andSexEqualTo(record.getSex());
				}
				SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
				if(!StringUtils.isBlank(beginTime)){
					Date dateBeginTime=sf.parse(beginTime);
					cri.andDateBirthGreaterThanOrEqualTo(dateBeginTime);
				}
				if(!StringUtils.isBlank(endTime)){
					Date dateEndTime=sf.parse(endTime);
					cri.andDateBirthLessThanOrEqualTo(dateEndTime);
				}
				if(!StringUtils.isBlank(category)){
					cri.andCategoryLike('%'+category+'%');
				}
				if(!StringUtils.isBlank(address)){
					cri.andAddressLike('%'+address+'%');
				}
				if(!StringUtils.isBlank(unit)){
					cri.andUnitLike('%'+unit+'%');
				}
				if("1".equals(look)){
					cri.andHpIdEqualTo(UserSessionOperator.getCurrentHospitalId()+"");
				}else{
					cri.andCreaterIdEqualTo(UserSessionOperator.getCurrentUserId());
				}
				if(page!=null){
					example.setOrderByClause("create_time desc limit "+page.getFirstRecord()+","+page.getPageSize());
				}
			}else{
				cri.andHpIdEqualTo(UserSessionOperator.getCurrentHospitalId()+"");
				if(page!=null){
					example.setOrderByClause("create_time desc limit "+page.getFirstRecord()+","+page.getPageSize());
				}
			}
			List<PatientAddress> patientList=dao.selectByExample(example);
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
	 * 查询患者疾病类型
	 * @return
	 */
	public JsonModel selectCategory(JsonModel json){
		json.setJsonData("0", this.dao.selectCategory(UserSessionOperator.getCurrentHospitalId().longValue()));
		return json;
	};
	/**
	 * 根据主键修改患者信息
	 * @param record
	 * @return
	 */
	public JsonModel updateByPrimaryKeySelective(PatientAddress record,String dateBirth,JsonModel json){
		if(record==null||StringUtils.isBlank(record.getTelphone())){
			json.setJsonData("1", "必填字段不能为空");
		}else{
			try {
				PatientAddressExample example=new PatientAddressExample();
				Criteria cri=example.createCriteria();
				cri.andIdNotEqualTo(record.getId());
				cri.andTelphoneEqualTo(record.getTelphone());
				List<PatientAddress> exampleList=dao.selectByExample(example);
				if(exampleList==null||exampleList.isEmpty()){
					if (!StringUtils.isBlank(dateBirth)){
						SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
						record.setDateBirth(sf.parse(dateBirth));
					}else{
						record.setDateBirth(null);
					}
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
	public HSSFWorkbook exportExcel(String ids, String allSelect,Integer status,List<Integer>methodList){
		try {
			if("0".equals(allSelect)){
					String [] idArray=ids.split(",");
					List<PatientAddress>list=new ArrayList<PatientAddress>();
					for (int i = 0; i < idArray.length; i++) {
						PatientAddress address=this.dao.selectByPrimaryKey(Integer.parseInt(idArray[i]));
						list.add(address);
					}
					return export(status, list,methodList);
			}else{
					List<PatientAddress>list=this.dao.selectByExample(null);
					return export(status, list,methodList);
			}
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | IOException e) {
			e.printStackTrace();
			return null;
		}
	};
	public HSSFWorkbook export(Integer status,List<PatientAddress>list,List<Integer>methodList) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException{
		ExportExcel export=new ExportExcel();
		List<String>headList=new ArrayList<String>();
		headList.add("姓名");
		headList.add("性别");
		headList.add("类别");
		headList.add("手机号码");
		headList.add("出生日期");
		headList.add("单位");
		headList.add("地址");
		return export.export(headList, list,methodList);
	}

}
