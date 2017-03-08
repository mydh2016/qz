package com.qazit.register.controller.web;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppUserVO;
import com.qazit.register.service.AppUserVOService;

@Controller
@RequestMapping("web/user")
public class WebUserController {
	@Autowired
	private AppUserVOService appUserService;
	@RequestMapping("/login")
	@ResponseBody
	public JsonModel loginUser(String username,String userpassword,AppUserVO uv,JsonModel json,HttpSession session){
		uv.setCellphonenumber(username);
		uv.setUserpassword(userpassword);
		json =appUserService.getUser(uv, json);
		if(json.getResultCode().equals("0")){
			AppUserVO webUser = (AppUserVO)json.getData();
			session.setAttribute("webUser", webUser);
		}
		return json;
	}
	
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	@ResponseBody
	public JsonModel createUser( AppUserVO webUser) throws UnsupportedEncodingException{
		
		String realname = new String((webUser.getRealname()).getBytes("ISO8859-1"),"utf-8");
		webUser.setRealname(realname);
		webUser.setUsername(webUser.getCellphonenumber());
		if(webUser.getGender() != null && webUser.getGender() !="" && webUser.getGender().equals("2")){
			webUser.setGender("女");
		}else{
			webUser.setGender("男");
		}
		JsonModel json =appUserService.createUser(webUser, new JsonModel());
//		if(json.getResultCode().equals("0")){			
//			AppUserVO webUser=(AppUserVO)json.getData();
//			session.setAttribute("webUser", webUser);
//		}
		return json;
	}
	@RequestMapping("/update")
	public @ResponseBody JsonModel updateUser(AppUserVO uv,JsonModel json,HttpSession session){
		json =appUserService.updateUser(uv, json);
		if(json.getResultCode().equals("0")){			
			AppUserVO webUser=(AppUserVO)json.getData();
			session.setAttribute("webUser", webUser);
		}
		return json;
	}
	@RequestMapping("/querySession")
	public @ResponseBody JsonModel querySession(JsonModel json,HttpSession session){
		AppUserVO appUser=(AppUserVO)session.getAttribute("webUser");
		return json;
	}
	@RequestMapping("/select")
	public @ResponseBody JsonModel selectUserById(AppUserVO uv,JsonModel json,HttpSession session){
		json =appUserService.getUser(uv, json);
		AppUserVO webUser=(AppUserVO)json.getData();
		session.setAttribute("webUser", webUser);
		return json;
	}
	@RequestMapping("/dellogin")
	public @ResponseBody JsonModel delsession(HttpSession session){
		session.removeAttribute("appUser");
		JsonModel json = new JsonModel();
		json.setResultCode("0");
		return json;
	}
	
}
