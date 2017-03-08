package com.qazit.register.model;

import java.util.List;
/*
 * 家庭联系人，多的一方
 * */
public class AppLinkmanVO 
{
	private String linkmanname;		//家属名字
	private String gender;			//性别
	private String identifynumber;	//身份证号
	private String cellphonenumber;	//手机号
	private Integer linkmanid;		//家属id
	private Integer userid;
	


	
	public Integer getLinkmanid() {
		return linkmanid;
	}
	public void setLinkmanid(Integer linkmanid) {
		this.linkmanid = linkmanid;
	}
	public String getLinkmanname() {
		return linkmanname;
	}
	public void setLinkmanname(String linkmanname) {
		this.linkmanname = linkmanname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIdentifynumber() {
		return identifynumber;
	}
	public void setIdentifynumber(String identifynumber) {
		this.identifynumber = identifynumber;
	}
	public String getCellphonenumber() {
		return cellphonenumber;
	}
	public void setCellphonenumber(String cellphonenumber) {
		this.cellphonenumber = cellphonenumber;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	
	
	
}
