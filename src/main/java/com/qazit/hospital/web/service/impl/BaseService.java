package com.qazit.hospital.web.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseService {
	/**
	 * 日期格式化
	 * @return String
	 */
	public String formateTime(String format){
		SimpleDateFormat sf=new SimpleDateFormat(format);
		Date date=new Date(System.currentTimeMillis());
		return sf.format(date);
	}
	public String parseTime(String stringTime){
		stringTime=stringTime.replaceAll("-", "");
		return stringTime;
	}
}
