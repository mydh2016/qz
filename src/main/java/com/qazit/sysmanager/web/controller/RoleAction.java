package com.qazit.sysmanager.web.controller;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.sysmanager.web.model.JsonResultMessage;
import com.qazit.sysmanager.web.model.Role;
import com.qazit.sysmanager.web.model.User;
import com.qazit.sysmanager.web.model.VResource;
import com.qazit.sysmanager.web.security.UserSessionOperator;
import com.qazit.sysmanager.web.service.IResourceService;
import com.qazit.sysmanager.web.service.IRoleService;
import com.qazit.sysmanager.web.service.IUserService;

@Controller
@RequestMapping("/role")
public class RoleAction {

	private static final Logger logger = Logger.getLogger(RoleAction.class);

	@Resource
	private IRoleService roleServiceImpl;
	@Resource
	private IUserService userServiceImpl;
	@Resource
	private IResourceService resourceServiceImpl;

	/**
	 * 保存角色基本信息及关联的用户
	 * @param role
	 * @param checkedUserIds
	 * @return
	 */
	@RequestMapping(value = "/saveRoleInfo")
	@ResponseBody
	public JsonResultMessage saveRoleInfo(Role role, String checkedUserIds,String permissionIds) {
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		User currUser = UserSessionOperator.getCurrentUser();
		try{
			if(role.getRoleName()==null||"".equals(role.getRoleName())){
				jsonResultMessage.setResultCode("1");
				jsonResultMessage.setData("角色名不能为空");
			}else{
				jsonResultMessage = roleServiceImpl.saveOrUpdateRoleInfo(role, checkedUserIds, permissionIds,currUser);
			}
		}catch(Exception e){
			jsonResultMessage.setResultCode("1");
		}
		return jsonResultMessage;
	}
	
	/**
	 * 删除角色
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteRole")
	@ResponseBody
	public JsonResultMessage deleteUser(Role role) throws Exception {
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		if (role != null && role.getRoleId() != null) {
			int isDeleted =  1 ; // isdeleted 0未删除，1删除
			role.setIsDeleted(isDeleted);
			this.roleServiceImpl.deleteRole(role);
		}
		jsonResultMessage.setJsonData("0", "ok");
		return jsonResultMessage;
	}
	
	
	/**
	 * 根据条件查询
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getRoles")
	@ResponseBody
	public JsonResultMessage getRoles(Role role) {
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		try{
			User currUser = UserSessionOperator.getCurrentUser();
			jsonResultMessage.setJsonData("0",this.roleServiceImpl.getRoles(role,currUser));
		}catch(Exception e){
			e.printStackTrace();
			jsonResultMessage.setJsonData("1", "查询角色错误");
		}
		return jsonResultMessage;
	}	
	
	/**
	 * 获取所有用户列表并且把与角色关联的用户选上
	 * @param type 0是新增  1是编辑
	 * @return
	 */
	@RequestMapping(value = "/getAllUserList")
	@ResponseBody
	public JSONArray getAllUserList(Integer roleId,int type) {
		User curentUser = UserSessionOperator.getCurrentUser();
		List<User> userList = userServiceImpl.getAllUsers(curentUser);
		JSONArray arry = new JSONArray();
		List<Long> selectUserIdsByRoleId = null;
		//新增角色的时候默认roleid为0 (roleid用于页面上的请求是新增还是编辑的)
		if (type == 1) {
			selectUserIdsByRoleId = roleServiceImpl.selectUserIdsByRoleId(roleId);
		}
		if (userList != null && userList.size() > 0) {
			for (User user : userList) {
				//只显示不是管理员的用户
				if(user.getIsAdmin()==0){
					JSONObject json = new JSONObject();
					json.put("id", user.getUserId());
					json.put("parentid", 0);
					json.put("name", user.getUserName());
					if (roleId != 0&&roleId!=null&&selectUserIdsByRoleId!=null) {
						if (selectUserIdsByRoleId.contains(user.getUserId())) {
							json.put("checked", true);
						}
					}
					arry.add(json);
				}
			}
		}
		return arry;
	}
	
	/**
	 * 根据资源类型和角色id获取相应的权限资源并转换为json数组
	 * @param roleId
	 * @param type 0是新增请求   1是编辑的请求
	 * @return
	 */
	@RequestMapping(value = "/getResourcesJson")
	@ResponseBody
	public List<VResource> getResourcesJson(Integer roleId,int type ) {
		int resourcetTypeid =1;
		try{
			
		}catch(Exception e){
			
		}
		if(type==0){//新增
			return this.resourceServiceImpl.getTreeMenuNodes(resourcetTypeid);
		}else if(type==1){
			return this.resourceServiceImpl.getTreeMenuNodesByRoleId(resourcetTypeid,roleId);
		}else{
			return null;
		}
	}
	
	/**
	 * @method getRole
	 * @description 根据角色id，返回角色对象
	 * @param roleId
	 * @return Role
	 */
	@RequestMapping(value = "/getRoleById")
	@ResponseBody
	public Role getRoleById(int roleId) {
		return this.roleServiceImpl.getRole(roleId);
	}
	
}
