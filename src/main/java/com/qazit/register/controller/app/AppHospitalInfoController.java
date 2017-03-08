package com.qazit.register.controller.app;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppHospitalVO;
import com.qazit.register.service.AppHospitalInfoService;

@Controller
@RequestMapping("app/hospital")
public class AppHospitalInfoController {
	@Autowired
	private AppHospitalInfoService hospitalService;
	
	@RequestMapping("/appoint")
	public String queryAllHospital(String status,JsonModel json,AppHospitalVO av,HttpServletRequest request,HttpSession session){
		json=hospitalService.queryAllHospital(json, av);
		List<AppHospitalVO> hospital=null;
		if(json.getResultCode().equals("0")){
			hospital=(List<AppHospitalVO>)json.getData();
			request.setAttribute("hospital", hospital);
		}
		if(status.equals("0")){
			return "view/register/appoint.jsp";
		}else{
			return "view/register/qu_appoint.jsp";
		}
	}
	@RequestMapping("/selectById")
	public String selectById(JsonModel json,Integer id,AppHospitalVO av,HttpServletRequest request,String status){
		av.setHospitalId(id);
		json=hospitalService.selectById(json, av);
		if(json.getResultCode().equals("0")){
			av=(AppHospitalVO)json.getData();
			request.setAttribute("apphp", av);
			if(status.equals("0")){
				return "view/register/hospital.jsp";
			}else if(status.equals("1")){
				return "view/register/hospitalPeriphery.jsp";
			}else if(status.equals("2")){
				return "view/register/hospitalMap.jsp";
			}else if(status.equals("3")){
				return "view/register/hsInNavigation.jsp";
			}else{
				return "view/register/floorGuide.jsp";
			}
			
			
		}else{
				return "rest/app/hospital/appoint";
						
	}
	}
	@RequestMapping("/selectByHospital")
	public String selectByHospital(JsonModel json,String hcode,AppHospitalVO av,HttpServletRequest request)
	{
		av.setHcode(hcode);
		json=hospitalService.selectByhospital(json, av);
		if(json.getResultCode().equals("0")){
			av=(AppHospitalVO)json.getData();
			request.setAttribute("apphp", av);
			return "view/register/hospitalNavigation.jsp";
		}else{
				return "/view/register/hospitalNavigation.jsp";
						
	}
	}
	
}
