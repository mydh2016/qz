package com.qazit.register.controller.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.NVList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppUserVO;
import com.qazit.register.service.AppSecurityService;
import com.qazit.register.service.AppUserVOService;


@Controller
@RequestMapping("app/appUserVO")
public class AppSecurityController
{
//	@Autowired
//	private AppSecurityService service;
	
	@Autowired
	private AppUserVOService user;
	
	@RequestMapping("/update")
	public String updateUser(AppUserVO uv,JsonModel json,HttpSession session)
	{
		json =user.updateUser(uv, json);
		if(json.getResultCode().equals("0")){			
			AppUserVO appUser=(AppUserVO)json.getData();
			session.setAttribute("appUser", appUser);
		}
		return "redirect:/view/register/accountSecurity.jsp";
		}
	
//	@RequestMapping("/updateByMail")
//	public String updateByMail(AppUserVO uv,JsonModel json,HttpSession session){
//		json = service.updateByMail(uv, json);
//		AppUserVO appUser = (AppUserVO)json.getData();
//		session.setAttribute("appUser", appUser);
//		return "redirect:/view/register/accountSecurity.jsp"; 
//	}
//	
//	@RequestMapping("/updateByCellphone")
//	public String updateByCellphone(AppUserVO uv,JsonModel json,HttpSession session){
//		json = service.updateByCellphone(uv,json);
//		AppUserVO appUser = (AppUserVO)json.getData();
//		session.setAttribute("appUser", appUser);
//		return "redirect:/view/register/accountSecurity.jsp";
//	}
}
