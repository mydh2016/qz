package com.qazit.register.controller.app;


import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppDocterVO;
import com.qazit.register.model.BaseForm;
import com.qazit.register.service.AppDocterInfoService;

@Controller
@RequestMapping("app/docter")
public class AppDocterInfoController {
	@Autowired
	private AppDocterInfoService docterServie;
	
	public AppDocterInfoService getDocterServie() {
		return docterServie;
	}

	public void setDocterServie(AppDocterInfoService docterServie) {
		this.docterServie = docterServie;
	}
	
	@RequestMapping("/all")
	public String queryAllDocter(HttpServletRequest request,String hcode,JsonModel json,AppDocterVO dv){
		dv.setHospitalSn(hcode);
		json=docterServie.queryAllDocter(json, dv);
		List<AppDocterVO> appDoctor=(List<AppDocterVO>)json.getData();
		request.setAttribute("appDoctor", appDoctor);
		request.setAttribute("hcode", hcode);
		return "view/register/doctor.jsp";
	}
	@RequestMapping("/queryById")
	public String queryById(HttpServletRequest request,JsonModel json,AppDocterVO dv,int userId){
		json=docterServie.selectById(json, dv, userId);
		if(json.getResultCode().equals("0")){
			AppDocterVO bf=(AppDocterVO)json.getData();
			request.setAttribute("dD", bf);
			return "view/register/doctorDetail.jsp";
		}else{
			return "rest/app/docter/all";
		}
	}
	
}
