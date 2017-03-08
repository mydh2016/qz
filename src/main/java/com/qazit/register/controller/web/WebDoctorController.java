package com.qazit.register.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppDocterVO;
import com.qazit.register.service.AppDocterInfoService;

@Controller
@RequestMapping("web/doctor")
public class WebDoctorController {
	
	@Autowired
	private AppDocterInfoService docterServie;
	
	@RequestMapping("/queryAllDocter")
	@ResponseBody
	public JsonModel queryAllDocter(String hcode,JsonModel json,AppDocterVO dv){
		dv.setHospitalSn(hcode);
		json=docterServie.queryAllDocter(json, dv);
		return json;
	}
	
}
