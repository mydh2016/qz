package com.qazit.hospital.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.model.DepartmentType;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.service.DepartmentTypeService;
@Controller
@RequestMapping("departmentType")
public class DepartmentTypeController {
	@Autowired
	private DepartmentTypeService service;
	/**
	 * 添加科室
	 * @param dpwb
	 * @return
	 */
	@RequestMapping("insert")
	@ResponseBody
	public JsonModel insert(DepartmentType type){
		JsonModel json=new JsonModel();
		return service.insert(type, json);
		
	}
	/**
	 * 删除科室
	 * @param departmentId
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public JsonModel delete(Integer departmentTypeId){
		JsonModel json=new JsonModel();
		return service.delete(departmentTypeId,json);
	}
	/**
	 * 更新科室
	 * @param dpwb
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public JsonModel update(DepartmentType type){
		JsonModel json=new JsonModel();
		return service.update(type, json);
		
	}
	/**
	 * 查询某个科室
	 * @param departmentId
	 * @return
	 */
	@RequestMapping("selectById")
	@ResponseBody
	public JsonModel selectById(Integer departmentTypeId){
		JsonModel json=new JsonModel();
		return service.selectById(departmentTypeId, json);
		
	}
	/**
	 * 查询科室列表
	 * @param dpwb
	 * @param page
	 * @return
	 */
	@RequestMapping("selectForList")
	@ResponseBody
	public JsonModel selectForList(DepartmentType type,AbstractPage page){
		JsonModel json=new JsonModel();
		return service.selectForList(type, page, json);
		
	}
}
