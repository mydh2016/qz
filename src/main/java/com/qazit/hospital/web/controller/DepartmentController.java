package com.qazit.hospital.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.model.DepartmentWithBLOBs;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.service.DepartmentService;
@Controller
@RequestMapping("department")
public class DepartmentController {
	@Autowired
	private DepartmentService service;
	/**
	 * 添加科室
	 * @param dpwb
	 * @return
	 */
	@RequestMapping("insert")
	@ResponseBody
	public JsonModel insert(DepartmentWithBLOBs dpwb){
		JsonModel json=new JsonModel();
		return service.insert(dpwb, json);
		
	}
	/**
	 * 删除科室
	 * @param departmentId
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public JsonModel delete(Integer departmentId){
		JsonModel json=new JsonModel();
		return service.delete(departmentId,json);
	}
	/**
	 * 更新科室
	 * @param dpwb
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public JsonModel update(DepartmentWithBLOBs dpwb){
		JsonModel json=new JsonModel();
		return service.update(dpwb, json);
		
	}
	/**
	 * 查询某个科室
	 * @param departmentId
	 * @return
	 */
	@RequestMapping("selectById")
	@ResponseBody
	public JsonModel selectById(Integer departmentId){
		JsonModel json=new JsonModel();
		return service.selectById(departmentId, json);
		
	}
	/**
	 * 查询科室列表
	 * @param dpwb
	 * @param page
	 * @return
	 */
	@RequestMapping("selectForList")
	@ResponseBody
	public JsonModel selectForList(DepartmentWithBLOBs dpwb,AbstractPage page){
		JsonModel json=new JsonModel();
		return service.selectForList(dpwb, page, json);
		
	}
	/**
	 * 根据科室id查询科室名字
	 * @return
	 */
	@RequestMapping("selectIdToName")
	@ResponseBody
	public JsonModel selectIdToName(Integer departmentId){
		JsonModel json=new JsonModel();
		return this.service.selectIdToName(departmentId, json);
	};
	@RequestMapping("selectList")
	@ResponseBody
	public JsonModel selectList(){
		JsonModel json=new JsonModel();
		return this.service.selectList(json);
	}
}
