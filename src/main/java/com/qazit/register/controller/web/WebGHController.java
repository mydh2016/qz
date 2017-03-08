package com.qazit.register.controller.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppDepartmentTypeVO;
import com.qazit.register.model.AppHospitalVO;
import com.qazit.register.model.AppPdGhVO;
import com.qazit.register.service.AppDepartmentService;
import com.qazit.register.service.AppHospitalInfoService;
import com.qazit.register.service.AppPdGhService;

@Controller
@RequestMapping("web/pdgh")
public class WebGHController {

	@Autowired
	private AppPdGhService pgService;
	
	@RequestMapping("/query")
	public @ResponseBody JsonModel queryAllByDate(JsonModel json,AppPdGhVO ap,HttpSession session,String data,Integer departmentId,Integer hospitalId ) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Date ddd;
		if(data==null){
			Date d =new Date();
			
			String dd =format.format(d);
			ddd = format.parse(dd);
		}else{
			ddd = format.parse(data);
		}
		ap.setConsDate(ddd);
		ap.setDepartId(departmentId);
		ap.setHospitalId(hospitalId);
		String str=(String)session.getAttribute("status");
		json.setResultCode(str);
		json=pgService.queryWebPDByDate(ap, json);
		return json;
	}
	
	@RequestMapping("/queryPDList")
	public @ResponseBody JsonModel queryPDList(JsonModel json,AppPdGhVO ap,HttpSession session,String date,Integer departmentId,Integer hospitalId,String timeSolt) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Date ddd;
		if(date==null){
			Date d =new Date();
			
			String dd =format.format(d);
			ddd = format.parse(dd);
		}else{
			ddd = format.parse(date);
		}
		ap.setConsDate(ddd);
		ap.setDepartId(departmentId);
		ap.setHospitalId(hospitalId);
		ap.setTimeSolt(timeSolt);
		String str=(String)session.getAttribute("status");
		json.setResultCode(str);
		json=pgService.queryPDList(ap, json);
		return json;
	}
}
