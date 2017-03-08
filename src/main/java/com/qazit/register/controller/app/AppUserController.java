package com.qazit.register.controller.app;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppUserVO;
import com.qazit.register.service.AppUserVOService;
import com.qazit.register.util.MD5Utils;

@Controller
@RequestMapping("app/user")
public class AppUserController {
	@Autowired
	private AppUserVOService appUserService;
	@RequestMapping("/login")
	public String loginUser(String username,String userpassword,AppUserVO uv,JsonModel json,HttpSession session){
		uv.setCellphonenumber(username);
		uv.setUserpassword(MD5Utils.md5(userpassword));
		json =appUserService.getUser(uv, json);
		if(json.getResultCode().equals("0")){
			AppUserVO appUser = (AppUserVO)json.getData();
			session.setAttribute("appUser", appUser);
			return "redirect:/view/register/index.jsp";
		}else{
			return "redirect:/view/register/login.jsp";
		}
	}
	@RequestMapping("/reg")
	public String createUser(String username,String userpassword,AppUserVO uv,JsonModel json,HttpSession session){
		uv.setCellphonenumber(username);
		uv.setUsername(username);
		uv.setUserpassword(MD5Utils.md5(userpassword));
		json =appUserService.createUser(uv, json);
		if(json.getResultCode().equals("0")){			
			AppUserVO appUser=(AppUserVO)json.getData();
			session.setAttribute("appUser", appUser);
			return "redirect:/view/register/index.jsp";
		}
		return "redirect:/view/register/register.jsp";
	}
	@RequestMapping("/update")
	public String updateUser(AppUserVO uv,JsonModel json,HttpSession session){
		json =appUserService.updateUser(uv, json);
		if(json.getResultCode().equals("0")){			
			AppUserVO appUser=(AppUserVO)json.getData();
			session.setAttribute("appUser", appUser);
		}
		return "redirect:/view/register/accountMessage.jsp";
		}
	@RequestMapping("/querySession")
	public String querySession(JsonModel json,HttpSession session){
		AppUserVO appUser=(AppUserVO)session.getAttribute("appUser");
		if(appUser!=null){
			/*appUser=new AppUserVO();
			json.setJsonData("0",appUser );	*/
			return "redirect:/view/register/personal.jsp";
		}else{
			//json.setJsonData("1", "请先登陆");
			return "redirect:/view/register/login.jsp";
		}
	}
	@RequestMapping("/select")
	public @ResponseBody String selectUserById(AppUserVO uv,JsonModel json,HttpSession session){
		json =appUserService.getUser(uv, json);
		AppUserVO appUser=(AppUserVO)json.getData();
		session.setAttribute("appUser", appUser);
		return "redirect:/view/register/accountSecurity.jsp";
	}
	@RequestMapping("/dellogin")
	public String delsession(HttpSession session){
		session.removeAttribute("appUser");
		return "/view/register/index.jsp";
	}
	
}
