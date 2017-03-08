package com.qazit.hospital.web.service;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.Model;

public interface ModelService {
	/**
	 * 添加模板
	 * @param model Model 实体
	 * @return JsonModel
	 */
	public JsonModel insert(Model model,JsonModel json);
	/**
	 * 修改模板
	 * @param model
	 * @return JsonModel
	 */
	public JsonModel updateByPrimaryKey(Model model,JsonModel json);
	/**
	 * 删除模板
	 * @param id
	 * @return JsonModel
	 */
	public JsonModel deleteByPrimaryKey(Integer id,JsonModel json);
	/**
	 * 根据主键查询模板
	 * @param id
	 * @return JsonModel
	 */
	public JsonModel selectByPrimaryKey(Integer id,JsonModel json);
	/**
	 * 根据条件查询模板列表
	 * @param model [modelName;//模板名称 modelParentType;//模板大类  modelChildrenType;//模板小类 id;//id modelStatus;//1-启用 2-停用 parentId;//父id]
	 * @return JsonModel
	 */
	public JsonModel selectForList(Model model,JsonModel json,AbstractPage page);
	/**
	 * 搜索部门大类
	 * @return JsonModel
	 */
	public JsonModel selectParentType(JsonModel json);
	/**
	 * 根据大类查询小类
	 * @param modelParentType 大类
	 * @return JsonModel
	 */
	public JsonModel selectChildrenType(String modelParentType,JsonModel json);
}
