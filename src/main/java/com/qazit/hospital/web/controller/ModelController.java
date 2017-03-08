package com.qazit.hospital.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.Model;
import com.qazit.hospital.web.service.ModelService;
import com.qazit.sysmanager.web.security.UserSessionOperator;
@Controller
@RequestMapping("model")
public class ModelController {
	@Autowired
	private ModelService service;
	/**
	 * 添加模板
	 * @param model Model 实体
	 * @return JsonModel
	 */
	@RequestMapping("insert")
	@ResponseBody
	public JsonModel insert(Model model,String parentType,String childrenType){
		if(!StringUtils.isBlank(parentType)){
			model.setModelParentType(parentType);
		}
		if(!StringUtils.isBlank(childrenType)){
			model.setModelChildrenType(childrenType);
		}
		JsonModel json=new JsonModel();
		return service.insert(model, json);
	};
	/**
	 * 修改模板
	 * @param model
	 * @return JsonModel
	 */
	@RequestMapping("updateByPrimaryKey")
	@ResponseBody
	public JsonModel updateByPrimaryKey(Model model){
		JsonModel json=new JsonModel();
		return this.service.updateByPrimaryKey(model, json);
	};
	/**
	 * 删除模板
	 * @param id
	 * @return JsonModel
	 */
	@RequestMapping("deleteByPrimaryKey")
	@ResponseBody
	public JsonModel deleteByPrimaryKey(Integer id){
		JsonModel json=new JsonModel();
		return this.service.deleteByPrimaryKey(id, json);
	};
	/**
	 * 根据主键查询模板
	 * @param id
	 * @return JsonModel
	 */
	@RequestMapping("selectByPrimaryKey")
	@ResponseBody
	public JsonModel selectByPrimaryKey(String id){
		JsonModel json=new JsonModel();
		Integer newId=null;
		if(!StringUtils.isBlank(id)){
			newId=Integer.parseInt(id);
		}
		return this.service.selectByPrimaryKey(newId, json);
	};
	/**
	 * 根据条件查询模板列表
	 * @param model [modelName;//模板名称 modelParentType;//模板大类  modelChildrenType;//模板小类 id;//id modelStatus;//1-启用 2-停用 parentId;//父id]
	 * @return JsonModel
	 */
	@RequestMapping("selectForList")
	@ResponseBody
	public JsonModel selectForList(Model model,String look,AbstractPage page){
		JsonModel json=new JsonModel();
		if("1".equals(look)){
			model.setCreaterId(UserSessionOperator.getCurrentUserId());
		}else{
			model.setHpId(UserSessionOperator.getCurrentHospitalId().longValue()+"");
		}
		return this.service.selectForList(model, json,page);
	};
	/**
	 * 搜索部门大类
	 * @return JsonModel
	 */
	@RequestMapping("selectParentType")
	@ResponseBody
	public JsonModel selectParentType(){
		JsonModel json=new JsonModel();
		json=this.service.selectParentType(json);
		return json;
	};
	/**
	 * 根据大类查询小类
	 * @param modelParentType 大类
	 * @return JsonModel
	 */
	@RequestMapping("selectChildrenType")
	@ResponseBody
	public JsonModel selectChildrenType(String modelParentType){
		JsonModel json=new JsonModel();
		return this.service.selectChildrenType(modelParentType,json);
	};
}
