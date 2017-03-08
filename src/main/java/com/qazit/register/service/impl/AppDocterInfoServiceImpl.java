package com.qazit.register.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.dao.mapper.AppDepartmentMapper;
import com.qazit.register.dao.mapper.AppDocterInfoMapper;
import com.qazit.register.dao.mapper.AppHospitalInfoMapper;
import com.qazit.register.model.AppDepartmentVO;
import com.qazit.register.model.AppDocterVO;
import com.qazit.register.model.AppHospitalVO;
import com.qazit.register.model.BaseForm;
import com.qazit.register.service.AppDocterInfoService;
@Service("AppDocterInfoService")
public class AppDocterInfoServiceImpl implements AppDocterInfoService {
	@Autowired
	private AppDocterInfoMapper docterDAO;
	@Autowired
	private AppDepartmentMapper dmDAO;
	@Autowired
	private AppHospitalInfoMapper hosDAO;
	@Override
	public JsonModel queryAllDocter(JsonModel json,AppDocterVO dv) {
		try {
			List<AppDocterVO> list= docterDAO.queryAllDocter(dv.getHospitalSn());
			for (AppDocterVO ad : list) {
				if(ad.getIsExpert().equals(0)){
					ad.setExpert("普通医生");
				}else{
					ad.setExpert("专家");//判断是不是专家
				}
				AppDepartmentVO depart=dmDAO.selectDepart(ad.getDepartmentSn(), ad.getHospitalSn());
				if(depart!=null){
				ad.setDepartName(depart.getDepartmentName());//查所属的科室
				}
				AppHospitalVO ho=hosDAO.selectbyHospital(ad.getHospitalSn());
				if(ho!=null){
				ad.setHospitalName(ho.getHospitalName());//查询所属医院
				}
			}
			
			json.setJsonData("0", list);
		} catch (Exception e) {
			json.setJsonData("1", "查询异常");
			e.printStackTrace();
		}
		return json;
	}
	public JsonModel selectById(JsonModel json,AppDocterVO ad,Integer id){
		ad=docterDAO.selectById(id);
		if(ad.getIsExpert().equals(0)){
			ad.setExpert("普通医生");
		}else{
			ad.setExpert("专家");//判断是不是专家
		}
		AppDepartmentVO depart=dmDAO.selectDepart(ad.getDepartmentSn(), ad.getHospitalSn());
		if(depart!=null){
		ad.setDepartName(depart.getDepartmentName());//查所属的科室
		}
		AppHospitalVO ho=hosDAO.selectbyHospital(ad.getHospitalSn());
		if(ho!=null){
		ad.setHospitalName(ho.getHospitalName());//查询所属医院
		}
		json.setJsonData("0", ad);
		return json;
	}
}
