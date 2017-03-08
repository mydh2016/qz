package com.qazit.sysmanager.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.qazit.sysmanager.util.StaticValue;
import com.qazit.sysmanager.web.dao.mapper.MenuMapper;
import com.qazit.sysmanager.web.model.Menu;
import com.qazit.sysmanager.web.model.MenuExample;
import com.qazit.sysmanager.web.service.IMenuService;

@Service("menuServiceImpl")
public class MenuServiceImpl implements IMenuService {

	@Resource
	private MenuMapper menuDaoImpl;

	public Menu getTMenuByUrl(String url) {
		MenuExample menuExample = new MenuExample();
		menuExample.createCriteria().andStatusEqualTo(1).andUrlEqualTo(url);
		List<Menu> menuList = menuDaoImpl.selectByExample(menuExample);
		Menu menu = null;
		if (menuList != null && menuList.size() > 0) {
			menu = menuList.get(0);
		}
		return menu;
	}

	public List<Menu> getTMenusByCurrentId(int currentId) {
		MenuExample menuExample = new MenuExample();
		menuExample.createCriteria().andStatusEqualTo(1).andParentEqualTo(
				currentId);
		menuExample.setOrderByClause("sortnum");
		return menuDaoImpl.selectByExample(menuExample);
	}

	/**
	 * 查找当前节点的子节点 
	 * return String
	 */
	public String getChileds(int currentId) {
		List<Menu> menuList = this.getTMenusByCurrentId(currentId);
		JSONArray arry = new JSONArray();
		JSONObject json = null;

		if (menuList.size() == 0) {
			json = new JSONObject();
			json.put("id", 0);
			json.put("name", "无数据");
			arry.add(json);
		} else {
			json = new JSONObject();
			json.put("id", 0);
			json.put("name", "请选择");
			arry.add(json);
			for (Menu menu : menuList) {
				json = new JSONObject();
				json.put("id", menu.getId());
				json.put("name", menu.getName());
				arry.add(json);
			}
		}
		return arry.toString();
	}

	public int addMenu(Menu menu) {
		if (menu.getId() != null && menu.getId() > 0) {
			menuDaoImpl.updateByPrimaryKey(menu);
		} else {
			menuDaoImpl.insert(menu);
		}
		return menu.getId();
	}

	public int deleteById(int menuId) {
		Menu menu = new Menu();
		menu.setId(menuId);
		menu.setStatus(0);
		int rows = menuDaoImpl.updateByPrimaryKeySelective(menu);
		return rows;
	}

	public List<Menu> getAllMenu() {
		MenuExample menuExample = new MenuExample();
		menuExample.createCriteria().andStatusEqualTo(StaticValue.AVAILABLE);
		menuExample.setOrderByClause("sortnum");
		return menuDaoImpl.selectByExample(menuExample);
	}

	public Menu getById(int menuId) {
		return menuDaoImpl.selectByPrimaryKey(menuId);
	}

	public int update(Menu menu) {
		return menuDaoImpl.updateByPrimaryKey(menu);
	}

	public List<Menu> getRootMenuList() {
		List<Menu> menuList = this.getAllMenu();
		List<Menu> rootList = new ArrayList<Menu>();
		if (menuList != null && menuList.size() > 0) {
			for (Menu tmenu : menuList) {
				if(tmenu.getParent() == 0){
					rootList.add(tmenu);
				}
			}
			
			for (Menu mu : rootList) {
				List<Menu> listC = new ArrayList<Menu>();
				for (Menu muC : menuList) {
					if ( mu.getId() == muC.getParent()) {
						listC.add(muC);
					}
				}
				mu.setChildren(listC);
			}
		}
		return rootList;
	}

}
