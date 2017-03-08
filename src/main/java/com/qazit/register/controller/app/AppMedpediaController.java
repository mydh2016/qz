package com.qazit.register.controller.app;

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
 * 可根据内容类型表，查出不同的内容(健康咨询，用药指南等)
 * @author zousking
 *
 */
@Controller
@RequestMapping("app/medpedia")
public class AppMedpediaController {

	@Autowired
	private AppMedpediaService service;
	
	@RequestMapping("/getMedpediaList")
	public String getMedpediaList(HttpServletRequest request,JsonModel json){
		int startNum=0;
		int pageNum=10;
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
		if(publish_module_sn.equals("gs_yybk")){
		return "view/register/Medpedia.jsp";
		}else{
			return "view/register/community.jsp";
		}
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
	public String getMedpediaInfo(AppMedpediaVO appMedpediaVO,String publish_module_sn,JsonModel json,Integer id,HttpServletRequest request){
		appMedpediaVO.setPublish_content_id(id);
		appMedpediaVO=service.getMedpediaById(appMedpediaVO,json);
		request.setAttribute("med", appMedpediaVO);
		if(publish_module_sn.equals("gs_yybk")){
			return "view/register/MedpediaDel.jsp";
			}else{
				return "view/register/communityDel.jsp";
			}
		
	}
}
