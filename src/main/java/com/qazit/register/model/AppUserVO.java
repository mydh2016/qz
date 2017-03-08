package com.qazit.register.model;

import java.util.Date;
import java.util.List;

public class AppUserVO {
	private Integer userid;
	private String username;
	private String userpassword;
	private String realname;
	private String identifynumber;
	private String email;
	private String cellphonenumber;
	private String officephonenumber;
	private String userstate;
	private Date effecttime;
	private Date unendtime;
	private String testcnt;
	private String gender;
	private List<AppLinkmanVO> appLinkmanVOList;
	
	
	
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getIdentifynumber() {
		return identifynumber;
	}
	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellphonenumber() {
		return cellphonenumber;
	}
	public void setCellphonenumber(String cellphonenumber) {
		this.cellphonenumber = cellphonenumber;
	}
	public String getOfficephonenumber() {
		return officephonenumber;
	}
	public void setOfficephonenumber(String officephonenumber) {
		this.officephonenumber = officephonenumber;
	}
	public String getUserstate() {
		return userstate;
	}
	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}

	public Date getEffecttime() {
		return effecttime;
	}
	public void setEffecttime(Date effecttime) {
		this.effecttime = effecttime;
	}
	public Date getUnendtime() {
		return unendtime;
	}
	public void setUnendtime(Date unendtime) {
		this.unendtime = unendtime;
	}
	public String getTestcnt() {
		return testcnt;
	}
	public void setTestcnt(String testcnt) {
		this.testcnt = testcnt;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<AppLinkmanVO> getAppLinkmanVOList() {
		return appLinkmanVOList;
	}
	public void setAppLinkmanVOList(List<AppLinkmanVO> appLinkmanVOList) {
		this.appLinkmanVOList = appLinkmanVOList;
	}
	
	
}
