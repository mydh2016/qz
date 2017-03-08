package com.qazit.sysmanager.web.controller;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.sysmanager.util.StaticValue;
import com.qazit.sysmanager.web.model.JsonResultMessage;
import com.qazit.sysmanager.web.model.Role;
import com.qazit.sysmanager.web.model.User;
import com.qazit.sysmanager.web.security.UserSessionOperator;
import com.qazit.sysmanager.web.service.IResourceService;
import com.qazit.sysmanager.web.service.IRoleService;
import com.qazit.sysmanager.web.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserAction {

	private static final Logger logger = Logger.getLogger(UserAction.class);

	private static String NOT_SUPPER_USER = "不是管理员!";
	private static String NOT_DEL_SELF = "不能删除自己！";

	@Resource
	private IUserService userServiceImpl;

	@Resource
	private IRoleService roleServiceImpl;

	@Resource
	private IResourceService resourceServiceImpl;
	
	/**
	 * 在用户登录的时候根据资源类型，获得当前用户菜单列表
	 * @param resourcetTypeid
	 * @return
	 */
	@RequestMapping(value = "/getResourcesJsonByUserId")
	@ResponseBody
	public JsonResultMessage getResourcesJsonByUserId(int resourcetTypeid ) {
		JsonResultMessage jresult = new JsonResultMessage();
		try{
			jresult.setJsonData("0", this.resourceServiceImpl.getTreeMenuNodesForIndex(resourcetTypeid));
		}catch(Exception e){
			e.printStackTrace();
			jresult.setJsonData("1", "查询菜单列表出错，请重试！");
		}
		return jresult;
	}
	
	/**
	 * 新增或修改用户
	 * 
	 * @param user
	 *            用户信息
	 * @param checkedRoleIds
	 *            用户选中的角色
	 * @return
	 */
	@RequestMapping(value = "/saveOrUpdateUser")
	@ResponseBody
	public JsonResultMessage saveOrUpdateUser(User user, String checkedRoleIds) {
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		try{
			jsonResultMessage = userServiceImpl.saveOrUpdateUser(user, checkedRoleIds);
		}catch(Exception e){
			jsonResultMessage.setResultCode("1");
			jsonResultMessage.setData("保存用户失败");
		}
		return jsonResultMessage;
	}
	
	/**
	 * 删除用户改变用户状态
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteUser")
	@ResponseBody
	public JsonResultMessage deleteUser(User user) throws Exception {
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		jsonResultMessage = userServiceImpl.deleteUser(user);
		return jsonResultMessage;
	}
	
	/**
	 * 根据条件查询所有列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getUsers")
	@ResponseBody
	public JsonResultMessage getUsers(User user) {
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		try{
			jsonResultMessage.setJsonData("0", this.userServiceImpl.getUsers(user));
		}catch(Exception e){
			logger.error("查询用户数据出现问题，请重试");
			jsonResultMessage.setJsonData("1", "查询用户数据出现问题，请重试");
			e.printStackTrace();
		}
		return jsonResultMessage;
	}
	
	/**
	 * 获得当前(HospitalId)渠道下的所有角色信息
	 * @return
	 */
	@RequestMapping(value = "/getAllRoleList")
	@ResponseBody
	public JSONArray getAllRoleList(int userId) {
		JSONArray arry = new JSONArray();
		try{
			String currentHospitalId = String.valueOf(UserSessionOperator.getCurrentHospitalId());
			//查询当前选择用户下面的所拥有的角色信息
			List<Role> roleList = roleServiceImpl.getAllRoleList(currentHospitalId);
			List<Integer> roleIds = null;
			
			//查询当前
			if (userId != 0) {
				roleIds = userServiceImpl.selectRoleIdsByUserId(userId);
			}

			if (roleList != null && roleList.size() > 0) {
				for (Role role : roleList) {
					JSONObject json = new JSONObject();
					json.put("id", role.getRoleId());
					json.put("parentid", 0);
					json.put("description", role.getDescription());
					json.put("name", role.getRoleName());
					if (userId != 0) {
						if (roleIds.contains(role.getRoleId())) {
							json.put("checked", true);
						}
					}
					arry.add(json);
				}
			}
		}catch(Exception e){
			
		}
		return arry ;
	}
	
	/**
	 * 获取userid对应的用户
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getUserById")
	@ResponseBody
	public User getUserById(long userid){
		return userServiceImpl.getUserById(userid);
	}
	
	/**
	 * 获取userid对应的用户
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getSessionUser")
	@ResponseBody
	public User getSessionUser(){
//		long curentUserId = UserSessionOperator.getCurrentUserId();
		User user = UserSessionOperator.getCurrentUser();
		return user;
	}
	
	/**
	 * 修改用户密码
	 * 
	 * @param userid
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	@RequestMapping(value = "/updatePassword")
	@ResponseBody
	public JsonResultMessage updatePassword(long userId, String oldPassword,
			String newPassword) {
		return userServiceImpl.updatePassword(userId, oldPassword, newPassword);
	}
	//-------------------------------------------------------------------------------------
	
	/**
	 * 新增或修改用户
	 * 
	 * @param user
	 *            用户信息
	 * @param checkedRoleIds
	 *            用户选中的角色
	 * @return
	 */
//	@RequestMapping(value = "/saveOrUpdateUserNoLogin")
//	@ResponseBody
//	public JsonResultMessage saveOrUpdateUserNoLogin(User user, String checkedRoleIds) {
//
//		long curentUserId =  0l;
//		return userServiceImpl.saveOrUpdateUser(user, checkedRoleIds,
//				curentUserId);
//	}

	/**
	 * 获取角色列表并且选上用户所拥有的角色
	 * 
	 * @return
	 */
//	@RequestMapping(value = "/getAllRoleList")
//	@ResponseBody
//	public JSONArray getAllRoleList(long userId) {
//		long curentUserId = UserSessionOperator.getCurrentUserId();
//	//	long curentUserId =1;
//		List<Role> roleList = roleServiceImpl.getRoles(curentUserId);
//		JSONArray arry = new JSONArray();
//		List<Integer> roleIds = null;
//		if (userId != 0) {
//			roleIds = userServiceImpl.selectRoleIdsByUserId(userId);
//		}
//
//		if (roleList != null && roleList.size() > 0) {
//			for (Role role : roleList) {
//				JSONObject json = new JSONObject();
//				json.put("id", role.getRoleId());
//				json.put("parentid", 0);
//				json.put("name", role.getRoleName());
//				if (userId != 0) {
//					if (roleIds.contains(role.getRoleId())) {
//						json.put("checked", true);
//					}
//				}
//				arry.add(json);
//			}
//		}
//		return arry;
//	}
	
	
	
	
	
	/**
	 * 审核
	 * @return 2:无审批权限
	 * @throws Exception
	 */
	@RequestMapping(value = "/auditor")
	@ResponseBody
	public int auditor(User user) throws Exception {
		String auditor = UserSessionOperator.getCurrentUserName();
		if( "auditor".equals(auditor) ){
		//	user.setStatus(0);
			return userServiceImpl.updateByPrimaryKeySelective(user);
		}
		return 2;
	}
	
}
