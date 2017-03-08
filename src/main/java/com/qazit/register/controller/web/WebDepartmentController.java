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
@RequestMapping("web/department")
public class WebDepartmentController {
	
	@Autowired
	private AppDepartmentService department;
	
	@RequestMapping("/qdepartment")
	@ResponseBody
	public JsonModel qdepartment(String hcode,JsonModel json,AppHospitalVO av,AppDepartmentTypeVO ad){
		av.setHcode(hcode);
		json = department.selectDepartmentForWeb(av, ad, json);
		return json;
	}
	
}
