package com.qazit.sysmanager.util;

public class StaticValue {
	/**
	 * 是否是管理员 可能是渠道管理员也可能是整个平台的管理员
	 */
	public static int IS_ADMIN = 1;
	
	/**
	 * 未被删除的
	 */
	public static int AVAILABLE = 0;
	
	/**
	 * 已经被删除
	 */
	public static int UN_AVAILABLE = 1;
	
	/*********
	 * 针对想在菜单中并没有进行ssid的权限分配的临时方案
	 * 在菜单基础信息表中默认ssid为asiainfo的亚信超级管理员所拥有的菜单
	 * ssid为default的为渠道商所拥有的菜单
	 * */
	/**
	 * 超级管理员的医院编号
	 */
	public static String SUPER_ADMIN_DEFAULT_NO = "gsyd";
	
	/**
	 * 超级管理员的默认医院ID
	 */
	public static String SUPER_HOSPITAL_ID = "0";
	
	/**
	 * 渠道管理员
	 */
	public static String HOSPITAL_DEFAULT_ID = "1";
	
	/**
	 * 管理员用户的默认科室ID
	 */
	public static Integer departmentId = 0;
	
	
	public static int IS_DELETED_YES=1;
	
	public static int IS_DELETED_NO=0;
}
