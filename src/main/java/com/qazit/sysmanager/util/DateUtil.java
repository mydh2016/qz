package com.qazit.sysmanager.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * @param ad_Date
	 * @param ai_Number
	 * @return 返回相差指定年数的日期对象
	 */
	public static Date relativeYear(Date ad_Date, int ai_Number) {
		return relativeDate(ad_Date, Calendar.YEAR, ai_Number);
	}

	/**
	 * 
	 * @param ad_Date
	 * @param ai_Number
	 * @return 返回相差指定月份数的日期对象
	 */
	public static Date relativeMonth(Date ad_Date, int ai_Number) {
		return relativeDate(ad_Date, Calendar.MONTH, ai_Number);
	}

	/**
	 * 
	 * @param ad_Date
	 * @param ai_Number
	 * @return 返回相差指定天数的日期对象
	 */
	public static Date relativeDay(Date ad_Date, int ai_Number) {
		return relativeDate(ad_Date, Calendar.DATE, ai_Number);
	}

	/**
	 * 
	 * @param ad_Date
	 * @param ai_Type
	 * @param ai_Number
	 * @return 返回处理过的日期
	 */
	public static Date relativeDate(Date ad_Date, int ai_Type, int ai_Number) {
		if (ad_Date == null)
			return null;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(ad_Date);
		calendar.add(ai_Type, ai_Number);

		return calendar.getTime();
	}
	
	public static Date dateFormat(Date date){
		String fmt = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		try {
			return sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date parseDate(String dateString) {
		return parseDate(dateString, "yyyy-MM-dd");
	}

	/**
	 * 
	 * @param dateString
	 * @return 
	 */
	public static Date parseDateTime(String dateString) {
		Date rtData = parseDate(dateString, "yyyy-MM-dd HH:mm:ss");
		if(null == rtData){
			rtData = parseDate(dateString, "yyyy/MM/dd HH:mm:ss");
		}
		return rtData;
	}
	
	public static String formatDate(Date date){
		return format(date, "yyyy-MM-dd");
	}
	public static String formatDateTime(Date date){
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 日期格式化
	 * 
	 * @param date
	 *            日期对象
	 * @param pattern
	 *            日期格式,如：yyyy-MM-dd HH:mm:ss
	 * @return 返回一个String类型的日期。
	 */
	public static String format(Date date, String pattern) {
		SimpleDateFormat lsdf_Format;
		String ls_Formatted;

		if (pattern == null) {
			System.err.println("DateUtil.format(): pattern is null");
			return null;
		}
//		if (pattern == null) {
		if (date == null) {
			System.err.println("DateUtil.format(): date is null");
			return null;
		}

		try {
			lsdf_Format = new SimpleDateFormat(pattern);
			ls_Formatted = lsdf_Format.format(date);
		} catch (Exception e) {
			System.err.println("DateUtil.formatDate(): " + e.getMessage());
			lsdf_Format = new SimpleDateFormat("yyyy-MM-dd");
			ls_Formatted = lsdf_Format.format(date);
		}

		return ls_Formatted;
	}

	/**
	 * 
	 * @param dateString
	 * @param parsePartten
	 * @return
	 */
	public static Date parseDate(String dateString, String parsePartten) {
		Date ld_Value;
		SimpleDateFormat lsdf_Format = new SimpleDateFormat(parsePartten);

		if (dateString == null)
			return null;

		try {
			lsdf_Format.setLenient(false); //to be precise
			ld_Value = lsdf_Format.parse(dateString);
		} catch (ParseException e) {
			return null;
		}

		return ld_Value;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DateUtil.formatDateTime(new Date()));
		//当前时间加1个月
		System.out.println(DateUtil.formatDateTime(DateUtil.relativeMonth(new Date(), 1)));
		//当前时间加3个月
		System.out.println(DateUtil.formatDateTime(DateUtil.relativeMonth(new Date(), 3)));
		//当前时间加1年
		System.out.println(DateUtil.formatDateTime(DateUtil.relativeYear(new Date(), 1)));
		//当前时间加1天的时间
		System.out.println(DateUtil.formatDateTime(DateUtil.relativeDay(new Date(), 1)));
	}

}
