package com.qazit.hospital.web.service;

import java.util.List;
import java.util.Map;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.model.DepartmentWithBLOBs;
import com.qazit.hospital.web.model.JsonModel;

public interface DepartmentService {
	/**
	 * 添加科室
	 * @param dp
	 * @param json
	 * @return
	 */
	public JsonModel insert(DepartmentWithBLOBs  dp,JsonModel json);
	/**
	 * 删除科室类型
	 * @param departmentId
	 * @param json
	 * @return
	 */
	public JsonModel delete(Integer departmentId,JsonModel json);
	/**
	 * 更新科室信息
	 * @param dp
	 * @param json
	 * @return
	 */
	public JsonModel update(DepartmentWithBLOBs  dp,JsonModel json);
	/**
	 * 查询某个科室
	 * @param departmentId
	 * @param json
	 * @return
	 */
	public JsonModel selectById(Integer departmentId,JsonModel json);
	/**
	 * 查询科室列表
	 * @param dp
	 * @param page
	 * @param json
	 * @return
	 */
	public JsonModel selectForList(DepartmentWithBLOBs  dp,AbstractPage page,JsonModel json);
	/**
	 * 根据科室id查询科室名字
	 * @return
	 */
	public JsonModel selectIdToName(Integer departmentId,JsonModel json);
	/**
	 * 查询科室列表
	 * @param dp
	 * @param page
	 * @param json
	 * @return
	 */
	public JsonModel selectList(JsonModel json);
	/**
	 * 根据名字查科室id
	 * @param departmentName
	 * @param hspId
	 * @return
	 */
	List<Integer> selectNameToId(String departmentName,String hspId);
	
}
