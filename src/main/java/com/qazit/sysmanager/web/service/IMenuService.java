package com.qazit.sysmanager.web.service;

import java.util.List;

import com.qazit.sysmanager.web.model.Menu;

public interface IMenuService {

	public List<Menu> getAllMenu();

	public Menu getTMenuByUrl(String url);

	public List<Menu> getTMenusByCurrentId(int currentId);

	/**
	 * 查找当前节点的子节点
	 * return String
	 */
	public String getChileds(int currentId);

	public Menu getById(int menuId);

	public int addMenu(Menu menu);

	public int update(Menu menu);

	public int deleteById(int menuId);

	public List<Menu> getRootMenuList();

}
