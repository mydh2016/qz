package com.qazit.sysmanager.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.sysmanager.web.model.Menu;
import com.qazit.sysmanager.web.service.IMenuService;

@Controller
@RequestMapping("/menu")
public class MenuAction {

	Logger log = Logger.getLogger(MenuAction.class);

	@Autowired
	private IMenuService menuService;

	/**
	 * 按树形结构输出菜单表中的所有节点
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getRootMenuList")
	@ResponseBody
	public List<Menu> getRootMenuList() throws Exception {
		return menuService.getRootMenuList();
	}

	@RequestMapping(value = "/getMenuById")
	@ResponseBody
	public Menu getMenuById(int id) throws Exception {
		return menuService.getById(id);
	}

	/**
	 * 添加或修改节点
	 * 
	 * @return
	 */
	public int saveOrUpdateMenu(Menu menu) throws Exception {
		return menuService.addMenu(menu);
	}

	/**
	 * 删除节点
	 * 
	 * @return
	 * @throws Exception
	 */
	public int delete(int id) throws Exception {
		return menuService.deleteById(id);
	}

}
