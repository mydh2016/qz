package com.qazit.hospital.web.dao.mapper;

import java.util.List;
import java.util.Map;

import com.qazit.hospital.web.model.Model;

public interface ModelMapper {
	/**
	 * 添加模板
	 * @param model Model 实体
	 * @return
	 */
	public Integer insert(Model model);
	/**
	 * 修改模板
	 * @param model
	 */
	public void updateByPrimaryKey(Model model);
	/**
	 * 删除模板
	 * @param id
	 */
	public void deleteByPrimaryKey(Integer id);
	/**
	 * 根据主键查询模板
	 * @param id
	 * @return Model
	 */
	public Model selectByPrimaryKey(Integer id);
	/**
	 * 根据条件查询模板列表
	 * @param model [modelName;//模板名称 modelParentType;//模板大类  modelChildrenType;//模板小类 id;//id modelStatus;//1-启用 2-停用 parentId;//父id]
	 * @return List<Model>
	 */
	public List<Model> selectForList(Model model);
	/**
	 * 根据条件查询模板列表
	 * @param model [modelName;//模板名称 modelParentType;//模板大类  modelChildrenType;//模板小类 id;//id modelStatus;//1-启用 2-停用 parentId;//父id]
	 * @return List<Model>
	 */
	public Long selectCount(Model model);
	
	/**
	 * 搜索部门大类
	 * @return
	 */
	public List<Model> selectParentType(String hpId);
	/**
	 * 根据大类查询小类
	 * @param modelParentType
	 * @return
	 */
	public List<Model> selectChildrenType(Map<String,Object>map);
}
