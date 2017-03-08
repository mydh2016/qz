package com.qazit.hospital.web.service;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.model.DepartmentType;
import com.qazit.hospital.web.model.JsonModel;

public interface DepartmentTypeService {
	/**
	 * 添加科室类型
	 * @param dpt
	 * @param json
	 * @return
	 */
	public JsonModel insert(DepartmentType dpt,JsonModel json);
	/**
	 * 删除科室类型
	 * @param departmentTypeId
	 * @param json
	 * @return
	 */
	public JsonModel delete(Integer departmentTypeId,JsonModel json);
	/**
	 * 更新科室类型
	 * @param dp
	 * @param json
	 * @return
	 */
	public JsonModel update(DepartmentType dp,JsonModel json);
	/**
	 * 查询某个科室类型
	 * @param departmentTypeId
	 * @param json
	 * @return
	 */
	public JsonModel selectById(Integer departmentTypeId,JsonModel json);
	/**
	 * 查询可是类型列表
	 * @param dp
	 * @param page
	 * @param json
	 * @return
	 */
	public JsonModel selectForList(DepartmentType dpt,AbstractPage page,JsonModel json);
}
