package com.qazit.hospital.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Hashtable;

public class ConfigUtil {
	
	private static File _cfFile = new File(ConfigUtil.class.getResource("/config.properties").getPath());

	private static long _lastModified = 0;

	private static final Properties Props = new Properties();

	private static final Hashtable<String, Integer> IntegerPorps = new Hashtable<String, Integer>();

	/**
	 * 从配置文件中取整数类型的配置。 原始配置均是字符串类型，该函数第一次调用时会将指定的配置转换成整数，
	 * 以后会直接返回转换后的值，避免每次都进行转换。
	 * @param name
	 * @return
	 */
	public static synchronized int getIntProperty(String name) {
		Integer pro = IntegerPorps.get(name);
		if (pro == null) {
			try {
				pro = Integer.parseInt(getProperty(name, "0").trim());
			} catch (Exception e) {
				pro = 0;
			}
			IntegerPorps.put(name, pro);
		}
		return pro;
	}


	public static void main(String args[]){
		System.out.println(ConfigUtil.getProperty("security.service.url"));
	}
	
	/**
	 * 取配置文件中的指定配置，配置名由name，如果指定的配置未定义则返回defaultvalue
	 * @param name 参数名
	 * @param defaultvalue 缺省的参数值
	 * @return
	 */
	public static String getProperty(String name, String defaultvalue) {
		String value = getProperty(name);
		return value != null ? value : defaultvalue;
	}

	/**
	 * 取配置文件中的指定配置，配置名由name，如果指定的配置未定义则返回“null”
	 * @param name
	 * @return
	 */
	public static synchronized String getProperty(String name) {
		if (_cfFile.lastModified() != _lastModified) {
			_lastModified = _cfFile.lastModified();
			init();
		}
		return Props.getProperty(name);
	}

	private static void init() {
		FileInputStream is = null;
		try {
			if (_cfFile.canRead()) {
				is = new FileInputStream(_cfFile);
				Props.load(is);
				IntegerPorps.clear();
			}
		} catch (IOException e) {
		}finally{
			try {
				if(is!=null){
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
