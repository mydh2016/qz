package com.qazit.register.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppDepartmentTypeVO;
import com.qazit.register.model.AppHospitalVO;
import com.qazit.register.service.AppDepartmentService;
import com.qazit.register.service.AppHospitalInfoService;

@Controller
@RequestMapping("web/hospital")
public class WebHospitalController {

	@Autowired
	private AppHospitalInfoService hospitalService;
	
	@Autowired
	private AppDepartmentService department;
	
	@RequestMapping("/getHospitals")
	@ResponseBody
	public JsonModel getThings(){
		JsonModel json = new JsonModel();
		AppHospitalVO av = new AppHospitalVO();
		json=hospitalService.queryAllHospital(json, av);
		return json;
	}
	
	@RequestMapping("/getHospital")
	@ResponseBody
	public JsonModel getThing(int id,JsonModel json,AppHospitalVO av){
		av.setHospitalId(id);
		json=hospitalService.selectById(json, av);
		return json;
	}
	
	@RequestMapping("/qdepartment")
	@ResponseBody
	public JsonModel qdepartment(String hcode,JsonModel json,AppHospitalVO av,AppDepartmentTypeVO ad){
		av.setHcode(hcode);
		//json = department.selectTeDepartment(av,ad,json);
		json = department.selectDepartmentForWeb(av, ad, json);
		return json;
	}
	
	public JsonModel saveThings(){
		return null;
	}
}
