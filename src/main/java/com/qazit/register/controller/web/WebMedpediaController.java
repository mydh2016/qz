package com.qazit.register.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppMedpediaVO;
import com.qazit.register.service.AppMedpediaService;

/**
 * 
 *
 */
@Controller
@RequestMapping("web/medpedia")
public class WebMedpediaController {

	@Autowired
	private AppMedpediaService service;
	
	@RequestMapping("/getMedpediaList")
	@ResponseBody
	public JsonModel getMedpediaList(JsonModel json){
		int startNum=0;
		int pageNum=10;
		List<AppMedpediaVO> appMedpediaVOList = service.getMedpediaList(startNum,pageNum,"gs_yybk");
		json.setData(appMedpediaVOList);
		return json;
	}
	@RequestMapping("/getMedpediaPage")
	public @ResponseBody JsonModel getMedpediaByPage(HttpServletRequest request,JsonModel json){
		int startNum=0;
		int pageNum=5;
		if(request.getParameter("startNum") != "" && request.getParameter("startNum") != null){
			startNum = Integer.valueOf(request.getParameter("startNum"));
		}
		if(request.getParameter("pageNum") != "" && request.getParameter("pageNum") != null){
			pageNum = Integer.valueOf(request.getParameter("pageNum"));
		}
		String publish_module_sn = "";
		if(request.getParameter("publish_module_sn") != "" && request.getParameter("publish_module_sn") != null){
			publish_module_sn = request.getParameter("publish_module_sn");
		}
		List<AppMedpediaVO> appMedpediaVOList = service.getMedpediaList(startNum,pageNum,publish_module_sn);
		request.setAttribute("medped", appMedpediaVOList);
		json.setJsonData("0", appMedpediaVOList);
		return json;
	}
	
	@RequestMapping("/getMedpediaInfo")
	public @ResponseBody JsonModel getMedpediaInfo(AppMedpediaVO appMedpediaVO,String publish_module_sn,JsonModel json,Integer id,HttpServletRequest request){
		appMedpediaVO.setPublish_content_id(id);
		appMedpediaVO=service.getMedpediaById(appMedpediaVO,json);
		json.setData(appMedpediaVO);
		return json;
		
	}
}
