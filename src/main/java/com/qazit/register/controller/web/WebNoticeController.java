package com.qazit.register.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppNoticeVO;
import com.qazit.register.service.AppNoticeService;

@Controller
@RequestMapping("web/notice")
public class WebNoticeController 
{
	@Autowired
	private AppNoticeService nvService;
	
	@RequestMapping("/queryAll")
	public @ResponseBody JsonModel queryAllPublicnotice(JsonModel json)
	{
		Integer startNum=0;
		Integer pageNum=8;
		json = nvService.queryAllPublicNotice(startNum,pageNum,json);
		return json;
	}
	@RequestMapping("/All")
	public @ResponseBody JsonModel AllPublicnotice(Integer startNum,Integer pageNum,JsonModel json,HttpServletRequest request)
	{
		if(request.getParameter("startNum") != "" && request.getParameter("startNum") != null){
			startNum = Integer.valueOf(request.getParameter("startNum"));
		}
		if(request.getParameter("pageNum") != "" && request.getParameter("pageNum") != null){
			pageNum = Integer.valueOf(request.getParameter("pageNum"));
		}
		json = nvService.AllPublicNotice(startNum,pageNum,json);
		if(json.getResultCode().equals("0")){
			List<AppNoticeVO> notice=(List<AppNoticeVO>)json.getData();
			request.setAttribute("notice", notice);
		}
			return json;
	}
	
	
	
	@RequestMapping("/selectBynotice")
	public @ResponseBody JsonModel selectBynotice(AppNoticeVO nv,Integer publicNoticeId,JsonModel json,HttpServletRequest request)
	{
		nv.setPublicNoticeId(publicNoticeId);
		json = nvService.selectByNotice(nv, json);
		return json;
	}
}
