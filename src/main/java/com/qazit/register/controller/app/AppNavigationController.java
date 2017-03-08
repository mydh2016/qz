package com.qazit.register.controller.app;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qazit.register.model.AppNavigationVO;
import com.qazit.register.util.PropertiesUtil;

/**
 * 楼层导航、院内导航(方式是通过读配置文件获取图片的方式)
 * @author zousking
 *
 */
@Controller
@RequestMapping("app/navigation")
public class AppNavigationController {
	
	@RequestMapping("/toNavigation")
	public String toNavigation(HttpServletRequest request){
		String hospitalId = request.getParameter("hospitalId");
		request.setAttribute("hospitalId", hospitalId);
		return "view/register/hospitalNavigation.jsp";
	}
	
	/**
	 * 院内导航，每个医院有一张图片
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/inside")
	public String inside(HttpServletRequest request) throws UnsupportedEncodingException{
		//System.out.println("hosName:"+new String(hosName.getBytes("ISO8859-1"),"UTF-8"));
		//return "view/register/index.jsp";
		
		String hospitalId = request.getParameter("hospitalId");
		hospitalId="2";
		String basefilepath = PropertiesUtil.getValue("hospitalfile.properties", "basefilepath");
		String relevant = PropertiesUtil.getValue("hospitalfile.properties", "relevant");
		String insidePhotoName = PropertiesUtil.getValue("hospitalfile.properties", "insidePhotoName");
		
		String[] relevantList = relevant.split(";");
		String folder = "";
		for(String idfolder :relevantList){
			String[] idfolderList = idfolder.split("@");
			if(hospitalId.equals(idfolderList[0])){
				folder = idfolderList[1];
				break;
			}
		}
		//图片地址为
		String insidePhotoPath = basefilepath+folder+"/"+insidePhotoName;
		request.setAttribute("insidePhotoPath", insidePhotoPath);
		System.out.println(insidePhotoPath);
		return "view/register/hsInNavigation.jsp";
	}
	
	/**
	 * 楼层导航，先列出有导航的楼列表，根据不同的楼找到不同的楼层导航
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/building")
	public String building(HttpServletRequest request) throws UnsupportedEncodingException{
		
		String hospitalId = request.getParameter("hospitalId");
		hospitalId="2";
		String basefilepath = PropertiesUtil.getValue("hospitalfile.properties", "basefilepath");
		String relevant = PropertiesUtil.getValue("hospitalfile.properties", "relevant");
		String hospotalBuilding = PropertiesUtil.getValue("hospitalfile.properties", "hospotalBuilding");
		String floorPhotoType = PropertiesUtil.getValue("hospitalfile.properties", "floorPhotoType");
		String[] relevantList = relevant.split(";");
		String folder = "";
		for(String idfolder :relevantList){
			String[] idfolderList = idfolder.split("@");
			if(hospitalId.equals(idfolderList[0])){
				folder = idfolderList[1];
				break;
			}
		}
		
		String[] hospotalList = new String(hospotalBuilding.getBytes("ISO8859-1"),"UTF-8").split(";");
		String buildings = "";
		for(String hospotal :hospotalList){
			String[] hosbuildings = hospotal.split("@");
			if(hospitalId.equals(hosbuildings[0])){
				buildings = hosbuildings[1];
				break;
			}
		}
		String[] buildingPhoteList = buildings.split(",");
		List<AppNavigationVO> appNavigationList= new ArrayList<AppNavigationVO>();
		for(String buildingPhote :buildingPhoteList){
			String[] buildingPhotes = buildingPhote.split(":");
			AppNavigationVO appNavigation = new AppNavigationVO();
			appNavigation.setBuildName(buildingPhotes[0]);
			appNavigation.setFloorPhotoPath(basefilepath+folder+"/"+buildingPhotes[1]+floorPhotoType);
			appNavigationList.add(appNavigation);
		}
		request.setAttribute("appNavigationList",appNavigationList);
		
		return "view/register/floorGuide1.jsp";
	}
	
	@RequestMapping("/floorGuide")
	public String floorGuide(HttpServletRequest request) throws UnsupportedEncodingException{
		if(request.getParameter("floorPhotoPath") != "" && request.getParameter("floorPhotoPath") != null){
			String floorPhotoPath = request.getParameter("floorPhotoPath");
			request.setAttribute("floorPhotoPath", floorPhotoPath);
		}
		return "view/register/floorGuide.jsp";
	}
	

	
}
