package com.qazit.sysmanager.web.service;

import java.util.List;

import com.qazit.sysmanager.web.model.VResource;


public interface IResourceService {
	
	/**
	 * 获得某个角色下的所有菜单资源，并标记为选上（适用于编辑角色）
	 * @param resourcetTypeId
	 * @param roleId
	 * @param isCheck 是增加还是编辑的标识
	 * @return
	 */
	public List<VResource> getTreeMenuNodesByRoleId(int resourcetTypeId,int roleId);
	
	/**
	 * 获得某个用户下的所有菜单资源，并标记为选上（适用于编辑用户）
	 * @param resourcetTypeId
	 * @return
	 */
//	public List<VResource> getTreeMenuNodesByUserId(int resourcetTypeId);
	
	/**
	 * 获得当前ssid下的菜单（resourcetTypeId）资源（新增用户，新增角色等）
	 * @param resourcetTypeId
	 * @return
	 */
	public List<VResource> getTreeMenuNodes(int resourcetTypeId);
	
	/**
	 * 获得当前ssid下的菜单（resourcetTypeId）资源（适用于首页菜单列表显示）
	 * @param resourcetTypeId
	 * @return
	 */
	public List<VResource> getTreeMenuNodesForIndex(int resourcetTypeId);
	
	
	/**
	 * 根据资源类型获取当前用户所关联的资源
	 * @param resourceTypeId
	 * @return
	 */
	public List<VResource> getResourcesByTypeId(int resourceTypeId);
	
	/**
	 * 根据资源类型和角色id获取相应的权限资源
	 * @param roleId
	 * @param resourceTypeId
	 * @return
	 */
	public List<VResource> getRolePermissions(int roleId, int resourceTypeId);
	

}
