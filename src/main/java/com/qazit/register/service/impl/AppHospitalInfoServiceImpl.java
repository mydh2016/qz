package com.qazit.register.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.dao.mapper.AppHospitalInfoMapper;
import com.qazit.register.model.AppHospitalVO;
import com.qazit.register.service.AppHospitalInfoService;

@Service("AppHospitalInfoService")
public class AppHospitalInfoServiceImpl implements AppHospitalInfoService {
	@Autowired
	private AppHospitalInfoMapper hospitalDAO;
	@Override
	public JsonModel queryAllHospital(JsonModel json,AppHospitalVO av) {
		try {
		List<AppHospitalVO> list=hospitalDAO.queryAllHospital();
		json.setJsonData("0", list);

		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("2", "登陆异常");
		}
		return json;
	}
	@Override
	public JsonModel selectById(JsonModel json, AppHospitalVO av) {
		if(av==null){
			json.setJsonData("1", "参数错误");
		}else{
		try {
		av=hospitalDAO.selectById(av.getHospitalId());
		json.setJsonData("0", av);
		
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("2", "登陆异常");
		}
		}
		return json;
	}
	@Override
	public JsonModel selectByhospital(JsonModel json, AppHospitalVO av) 
	{
		if(av==null){
			json.setJsonData("1", "参数错误");
		}else{
		try {
		av=hospitalDAO.selectbyHospital(av.getHcode());
		json.setJsonData("0", av);
		
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("2", "登陆异常");
		}
		}
		return json;
	}
}
