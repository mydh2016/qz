package com.qazit.register.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 读取配置文件工具类
 * @author zgx
 *
 */
public class PropertiesUtil {

	public static Log logger = LogFactory.getLog(PropertiesUtil.class);
	
	private static Hashtable<String,Properties> table = new Hashtable<String,Properties>();
	
	public static String getValue(String fileName,String key){
		Properties pro = null;
		if(!table.containsKey(fileName)){
			if(fileName != null && !fileName.trim().equals("")){
				pro = new Properties();
				InputStream fis = null;
				try {
					ClassPathResource cpr = new ClassPathResource(fileName);
					fis = cpr.getInputStream();
					pro.load(fis);
				} catch (FileNotFoundException e) {
					logger.error("-------------> Load Properties "+fileName+" failer!");
					e.printStackTrace();
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(null != fis){
						try {
							fis.close();
						} catch (IOException e) {
							logger.error("Close inputStream failer");
							e.printStackTrace();
						}
					}
				}
				table.put(fileName, pro);
			}
		}
		pro = (Properties)table.get(fileName);
		return (String)pro.getProperty(key);
	}
}
