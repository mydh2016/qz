package com.qazit.sysmanager.web.service;

import java.util.List;
import java.util.Map;

import com.qazit.sysmanager.web.model.JsonResultMessage;
import com.qazit.sysmanager.web.model.User;


public interface IUserService {
//	
//	/**
//	 * 校验用户唯一性
//	 * @param userName
//	 * @param ssid
//	 * @return
//	 */
//	public boolean checkUserUniq(String userName);
	
	/**
	 * 用户新增或修改端口
	 * @param user
	 * @param checkedRoleIds 
	 * @param curentUserId
	 * @return
	 */
	JsonResultMessage saveOrUpdateUser(User user, String checkedRoleIds);
	
	/**
	 * 删除用户
	 * @param user
	 */
	public JsonResultMessage deleteUser(User user);
	
	/**
	 * 查询用户
	 * @param user
	 * @param currUser
	 * @return
	 */
	public Map<String,Object> getUsers(User user);
	
	//---------------------------------------------------------------------------------------------
	

	/**
	 * 删除用户id所对应的角色
	 * @param userId
	 */
	public void deleteUserRoles( long userId);
	
	
	/**
	 * 修改密码
	 * @param userid
	 * @param oldPassword
	 * @param newPassword
	 */
	public JsonResultMessage updatePassword(long userid, String oldPassword, String newPassword );
	
	
	/**
	 * 获取userid对应的用户
	 * @param userId
	 * @return
	 */
	public User getUserById(long userid);
	
	
	/**
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(User record);
	
	
	
	 /** @method	selectByUserId
	 * @description 获取用户id所关联的所有角色id   
	 * @return	List
	 */
	public  List<Integer> selectRoleIdsByUserId(long userId);
	
	/**
	 * 查询当前用户权限下面的用户信息
	 * @param user
	 * @return
	 */
	public List<User> getAllUsers(User user); 
	
	public List<User> getAllUsers();
	


}
