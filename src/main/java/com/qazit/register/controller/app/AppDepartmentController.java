package com.qazit.register.controller.app;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppDepartmentTypeVO;
import com.qazit.register.model.AppDepartmentVO;
import com.qazit.register.model.AppHospitalVO;
import com.qazit.register.service.AppDepartmentService;

@Controller
@RequestMapping("app/depart")
public class AppDepartmentController 
{
	@Autowired
	private AppDepartmentService department;
	
	@RequestMapping("/alldepartmentType")
	public String alldepartmentType(AppHospitalVO av,AppDepartmentTypeVO ad,String hcode,String departmentTypeSn,JsonModel json,HttpServletRequest request)
	{
		
		av.setHcode(hcode);
		ad.setDepartmentTypeSn(departmentTypeSn);
		json = department.selectAllDepartmentType(av,ad,json);
		Map<String, Object> dota = (Map<String, Object>)json.getData();
		request.setAttribute("dota", dota);
		return "view/register/medicalLab.jsp";
	}
	@RequestMapping("/department")
	public @ResponseBody JsonModel department(AppHospitalVO av,AppDepartmentTypeVO ad,String hcode,String departmentTypeSn,JsonModel json,HttpServletRequest request)
	{
		
		av.setHcode(hcode);
		ad.setDepartmentTypeSn(departmentTypeSn);
		json = department.selectAllDepartment(av,ad,json);
		List<AppDepartmentVO>  dota= (List<AppDepartmentVO>)json.getData();
			
		request.setAttribute("dota", dota);
		return json;
	}
	
	@RequestMapping("/Qdepartment")
	public String Qdepartment(AppHospitalVO av,AppDepartmentTypeVO ad,String hcode,JsonModel json,HttpServletRequest request)
	{
		
		av.setHcode(hcode);
		json = department.selectTeDepartment(av,ad,json);
		Map<String, Object>  dota= (Map<String, Object>)json.getData();
		request.setAttribute("dota", dota);
		return "view/register/medicalLab.jsp";
	}
	@RequestMapping("/alldepartment")
	public String alldepartment(AppHospitalVO av,AppDepartmentTypeVO ad,String hcode,JsonModel json,HttpServletRequest request)
	{
		
		av.setHcode(hcode);
		json = department.selectTeDepartment(av,ad,json);
		Map<String, Object>  dota= (Map<String, Object>)json.getData();
		request.setAttribute("dota", dota);
		return "view/register/qu_medicalLab.jsp";
	}
	
	//科室介绍
	@RequestMapping("/alldepart")
	public String alldepart(AppHospitalVO av,AppDepartmentTypeVO ad,String hcode,JsonModel json,HttpServletRequest request)
	{
		
		av.setHcode(hcode);
		json = department.selectTeDepartment(av,ad,json);
		Map<String, Object> dota = (Map<String, Object>)json.getData();
		request.setAttribute("dota", dota);
		return "view/register/department.jsp";
	}
	//科室详细介绍
	@RequestMapping("/departmentX")
	public String departmentX(AppDepartmentVO ad,Integer departmentId,String hcode,JsonModel json,HttpServletRequest request)
	{
		ad.setDepartmentId(departmentId);
		ad.setHospitalSn(hcode);
		json = department.selectdepartmentX(ad,json);
		AppDepartmentVO dota= (AppDepartmentVO)json.getData();
		request.setAttribute("dota", dota);
		return "view/register/departmentDetail.jsp";
	}
	
}
