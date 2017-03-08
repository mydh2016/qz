package com.qazit.sysmanager.web.security;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.qazit.sysmanager.util.StaticValue;
import com.qazit.sysmanager.web.model.User;

public class UserSessionOperator {
	
	/**
	 * @return
	 */
	public static long getCurrentUserId() {
		Subject sub = SecurityUtils.getSubject();
		CurrentUser currUser = (CurrentUser) sub.getPrincipal();
		if (currUser.getCurrentUser() != null && currUser.getCurrentUser().getUserId() != 0) {
			return currUser.getCurrentUser().getUserId();
		}
		return 0l;
	}

	public static Long getCurrentHospitalId() {
		Subject sub = SecurityUtils.getSubject();
		CurrentUser currUser = (CurrentUser) sub.getPrincipal();
		if (currUser.getCurrentUser() != null ) {
			return Long.valueOf(currUser.getCurrentUser().getHospitalId()) ;
		}
		return 0l;
	}
	
	/**
	 * @return
	 */
	public static String getCurrentHospitalNo() {
		Subject sub = SecurityUtils.getSubject();
		CurrentUser currUser = (CurrentUser) sub.getPrincipal();
		if (currUser.getCurrentUser() != null ) {
			return currUser.getCurrentUser().getHospitalNo() ;
		}
		return null;
	}
	
	/**
	 * @return
	 */
	public static User getCurrentUser() {
		Subject sub = SecurityUtils.getSubject();
		CurrentUser currUser = (CurrentUser) sub.getPrincipal();
		if (currUser.getCurrentUser() != null && currUser.getCurrentUser().getUserId() != 0) {
			return currUser.getCurrentUser() ;
		}
		return null;
	}

	/**
	 * @return
	 */
	public static String getCurrentUserName() {
		Subject sub = SecurityUtils.getSubject();
		CurrentUser currUser = (CurrentUser) sub.getPrincipal();
		if (currUser.getCurrentUser() != null && currUser.getCurrentUser().getUserId() != 0) {
			return currUser.getCurrentUser().getUserName() ;
		}
		return null;
	}
	
	/**
	 * 判断是否是管理员
	 * @return
	 */
	public static boolean isAdmin(){
		boolean flag = false;
		Subject sub = SecurityUtils.getSubject();
		CurrentUser currUser = (CurrentUser) sub.getPrincipal();
		if(StaticValue.IS_ADMIN==currUser.getCurrentUser().getIsAdmin()){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 判断用户是否是超级运营管理员
	 * @return
	 */
	public static boolean isSupperAdmin(){
		boolean flag = false;
		Subject sub = SecurityUtils.getSubject();
		CurrentUser currUser = (CurrentUser) sub.getPrincipal();
		if(StaticValue.SUPER_HOSPITAL_ID.equals(currUser.getCurrentUser().getHospitalId())&&currUser.getCurrentUser().getIsAdmin()==StaticValue.IS_ADMIN){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 判断该用户是否是医院管理员
	 * @return
	 */
	public static boolean isSupper(){
		Subject sub = SecurityUtils.getSubject();
		CurrentUser currUser = (CurrentUser) sub.getPrincipal();
		if (currUser != null && currUser.getCurrentUser().getUserId() != 0 
				&& currUser.getCurrentUser().getIsAdmin() == StaticValue.IS_ADMIN
				&&!StaticValue.SUPER_HOSPITAL_ID.equals(currUser.getCurrentUser().getHospitalId())){
			return true;
		}
		return false;
	}

}
