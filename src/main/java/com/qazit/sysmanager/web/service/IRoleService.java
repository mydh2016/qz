package com.qazit.sysmanager.web.service;

import java.util.List;
import java.util.Map;

import com.qazit.sysmanager.web.model.JsonResultMessage;
import com.qazit.sysmanager.web.model.Role;
import com.qazit.sysmanager.web.model.User;

public interface IRoleService {
	
	/**
	 * 获得当前(ssid)渠道下的所有角色信息
	 * @param ssid
	 * @return
	 */
	public List<Role> getAllRoleList(String ssid);
	
	/**
	 * 带分页的角色对象返回
	 * 
	 * @param role
	 * @return
	 */
	public Map<String, Object> getRoles(Role role,User currUser);

	//----------------------------------------------------------------------------------------------
	
	/**
	 * 根据当前用户id获取用户所关联的角色
	 * 
	 * @param currentUserId
	 * @return
	 */
//	public List<Role> getRoles(long currentUserId);

	/**
	 * @method roleId
	 * @description 获取角色id所关联的所有用户id
	 * @return List<Long>
	 */
	public List<Long> selectUserIdsByRoleId(int roleId);

	/**
	 * 根据角色id和资源类型id获取资源id
	 * 
	 * @param roleId
	 * @param resourcetypeid
	 */
	public List<Integer> selectPermissionIdsByRoleIdAndResType(int roleId,int resourcetypeid);

	/**
	 * @method addRoleMenuPerm
	 * @description 保存角色菜单权限
	 * @param operator
	 * @param role
	 *            @
	 * @return void
	 */
	public int saveRoleMenuPerm(Integer roleId, String permissionIds);

	
	
	/**
	 * @method addRole
	 * @description 新建角色，保存基本信息
	 * @param operator
	 * @param role
	 *            @
	 * @return void
	 */
	public JsonResultMessage saveOrUpdateRoleInfo(Role role,String checkedUserIds,String permissionIds,User currUser);

	/**
	 * @method deleteRole
	 * @description 删除角色,删除所有关联表信息
	 * @param operator
	 * @param role
	 *            @
	 * @return void
	 */
	public void deleteRole(Role role);

	/**
	 * @method getRole
	 * @description 根据角色id，返回角色对象
	 * @param roleId
	 * @return Role
	 */
	public Role getRole(int roleId);

	/**
	 * 返回所有角色
	 * 
	 * @return
	 */
	public List<Role> getAllRoles();


}