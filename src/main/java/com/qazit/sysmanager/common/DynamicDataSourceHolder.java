package com.qazit.sysmanager.common;

import org.springframework.util.Assert;

public class DynamicDataSourceHolder {
	// 线程本地环境  
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
	  
	// 设置数据源类型  
	public static void setDataSourceType(String dataSourceType) {  
	    Assert.notNull(dataSourceType, "DataSourceType cannot be null");  
	    contextHolder.set(dataSourceType);  
	}  
	  
	// 获取数据源类型  
	public static String getDataSourceType() {  
	    return (String) contextHolder.get();  
	}  
	  
	// 清除数据源类型  
	public static void clearDataSourceType() {  
	    contextHolder.remove();  
	}  

}
