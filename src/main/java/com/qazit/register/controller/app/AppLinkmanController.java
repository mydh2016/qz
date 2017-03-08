package com.qazit.register.controller.app;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppLinkmanVO;
import com.qazit.register.model.AppUserVO;
import com.qazit.register.service.AppLinkmanService;

import io.netty.handler.traffic.ChannelTrafficShapingHandler;

@Controller
@RequestMapping("app/appLinkman")
public class AppLinkmanController 
{
	@Autowired
	private AppLinkmanService linkmanService;
	
	
	@RequestMapping("/select")
	public String selectByLId(AppUserVO uv,JsonModel json,HttpServletRequest request,HttpSession session){
		uv=(AppUserVO)session.getAttribute("appUser");
	    json = linkmanService.selectByLid(uv,json);
	    if(json.getResultCode().equals("0")){
		List<AppLinkmanVO> linkm = (List<AppLinkmanVO>)json.getData();
		request.setAttribute("linkm", linkm);
		return "view/register/familyMember.jsp";
	    }else{
	    	return "view/register/familyMember.jsp";
	    }
	}
	
	@RequestMapping("/add")
	public String createLinkm(AppLinkmanVO lm,JsonModel json,HttpServletRequest request,HttpSession session){
		 AppUserVO appUserVO = (AppUserVO) session.getAttribute("appUser");
		 lm.setUserid(appUserVO.getUserid());
		 json = linkmanService.createLink(lm, json);
		 if(json.getResultCode().equals("0")){
			 json = linkmanService.selectByLid(appUserVO,json);
		 return "/rest/app/appLinkman/select";
		 }else{
			 return	"view/register/addFamilyMember.jsp";
		 }
	}
	
	@RequestMapping("/delete")
	public @ResponseBody JsonModel deleteLinkm(Integer linkmanid,JsonModel json){
		json=linkmanService.deleteLink(linkmanid,json);
		return json;
	   
	}
	
	@RequestMapping("/update")
	public String updateLinkm(AppLinkmanVO lm,JsonModel json,HttpServletRequest request,HttpSession session){
		AppLinkmanVO appLinkmanVO = (AppLinkmanVO)session.getAttribute("linkm");
		 lm.setUserid(appLinkmanVO.getUserid());
		 lm.setLinkmanid(appLinkmanVO.getLinkmanid());
		 if(lm.getGender()==null&&lm.getGender().equals(appLinkmanVO.getGender())){
			 lm.setGender(appLinkmanVO.getGender());
		 }
		 json = linkmanService.updateLink(lm, json);
		 if(json.getResultCode().equals("0")){
		 AppLinkmanVO linkm = (AppLinkmanVO)json.getData();
		 request.setAttribute("linkm", linkm);
		 return "/rest/app/appLinkman/select";
		 }else{
			 return "/rest/app/appLinkman/select";
		 }
	}
	@RequestMapping("/query")
	public String selectLId(AppLinkmanVO lm,Integer linkmanid,JsonModel json,HttpSession session){
		lm.setLinkmanid(linkmanid);
	    json = linkmanService.selectLid(lm,json);
		AppLinkmanVO linkm = (AppLinkmanVO)json.getData();
		session.setAttribute("linkm", linkm);
		return "view/register/modifyInfo.jsp"; 
	}
	
}
