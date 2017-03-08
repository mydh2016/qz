package com.qazit.hospital.web.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.dao.mapper.ModelMapper;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.Model;
import com.qazit.hospital.web.service.ModelService;
import com.qazit.sysmanager.web.security.UserSessionOperator;

@Service("modelService")
public class ModelServiceImpl extends BaseService implements ModelService{
	@Autowired
	private ModelMapper modelDAO;
	/**
	 * 添加模板
	 * @param model Model 实体
	 * @return JsonModel
	 */
	public JsonModel insert(Model model,JsonModel json){
		if(model==null){
			json.setJsonData("1", "参数错误");
		}else  if(StringUtils.isBlank(model.getModelChildrenType())||StringUtils.isBlank(model.getModelParentType())||StringUtils.isBlank(model.getModelName())||StringUtils.isBlank(model.getModelContent())){
			json.setJsonData("2", "信息填写不完整");
		}else{
			try {
				boolean flag=this.selectIsEXITS(model);
				if(flag){
					model.setCreateTime(new Date());
					model.setUpdateTime(new Date());
					model.setState(0);
					model.setCreaterId(UserSessionOperator.getCurrentUserId());
					model.setCreater(UserSessionOperator.getCurrentUser().getUserName());
					model.setUpdater(UserSessionOperator.getCurrentUser().getUserName());
					model.setHpId(UserSessionOperator.getCurrentHospitalId()+"");
					modelDAO.insert(model);
					json.setJsonData("0", model.getId());
				}else{
					json.setJsonData("4", "该模板已存在");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("3", "保存异常");
			}
			
			
			
		}
		return json;
	};
	/**
	 * 修改模板
	 * @param model
	 * @return JsonModel
	 */
	public JsonModel updateByPrimaryKey(Model model,JsonModel json){
		try {
			boolean flag=this.selectIsEXITS(model);
			if(flag){
				model.setUpdater(UserSessionOperator.getCurrentUser().getUserName());
				model.setUpdateTime(new Date());
				modelDAO.updateByPrimaryKey(model);
				json.setJsonData("0", "修改成功");
			}else{
				json.setJsonData("4", "该模板已存在");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "修改数据异常");
		}
		return json;
	};
	/**
	 * 删除模板
	 * @param id
	 * @return JsonModel
	 */
	public JsonModel deleteByPrimaryKey(Integer id,JsonModel json){
		try {
			modelDAO.deleteByPrimaryKey(id);
			json.setJsonData("0", "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "修改数据异常");
		}
		return json;
	};
	/**
	 * 根据主键查询模板
	 * @param id
	 * @return JsonModel
	 */
	public JsonModel selectByPrimaryKey(Integer id,JsonModel json){
		if(id==null){
			json.setJsonData("1", "参数错误");
		}else{
			try {
				Model model=modelDAO.selectByPrimaryKey(id);
				json.setJsonData("0", model);
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("3", "查询数据异常");
			}
		}
		return json;
	};
	/**
	 * 根据条件查询模板列表
	 * @param model [modelName;//模板名称 modelParentType;//模板大类  modelChildrenType;//模板小类 id;//id modelStatus;//1-启用 2-停用 parentId;//父id]
	 * @return JsonModel
	 */
	public JsonModel selectForList(Model model,JsonModel json,AbstractPage page){
		try {
			model.setFirstRecord(page.getFirstRecord());
			model.setPageSize(page.getPageSize());
			List<Model> modelList=modelDAO.selectForList(model);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("dataList", modelList);
			map.put("pageCountAll", this.modelDAO.selectCount(model));
//			map.put("type", type);
			json.setJsonData("0", map);
			System.out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "查询数据异常");
		}
		return json;
	};
	/**
	 * 搜索部门大类
	 * @return JsonModel
	 */
	public JsonModel selectParentType(JsonModel json){
		try {
			List<Model>modelList=this.modelDAO.selectParentType(UserSessionOperator.getCurrentHospitalId()+"");
			json.setJsonData("0", modelList);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "查询异常");
		}
		
		return json;
	};
	/**
	 * 根据大类查询小类
	 * @param modelParentType 大类
	 * @return JsonModel
	 */
	public JsonModel selectChildrenType(String modelParentType,JsonModel json){
		try {
			Map<String,Object>map=new HashMap<String, Object>();
			map.put("modelParentType",modelParentType );
			map.put("hpId",UserSessionOperator.getCurrentHospitalId()+"");
			List<Model>modelList=this.modelDAO.selectChildrenType(map);
			json.setJsonData("0", modelList);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "查询异常");
		}
		
		return json;
	};
	/**
	 * 模板验重
	 * @param model
	 * @return boolean
	 */
	public boolean selectIsEXITS(Model model){
		model.setHpId(UserSessionOperator.getCurrentHospitalId()+"");
		List<Model> modelList=this.modelDAO.selectForList(model);
		if(modelList==null || modelList.isEmpty()){
			return true;
		}
		return false;
	}
	/**
	 * 日期格式化
	 * @return String
	 */
//	public String formateTime(){
//		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmm");
//		Date date=new Date(System.currentTimeMillis());
//		return sf.format(date);
//	}
	public static void main(String[] args) {
		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmm");
		Date date=new Date(System.currentTimeMillis());
		System.out.println(sf.format(date));
	}
}
