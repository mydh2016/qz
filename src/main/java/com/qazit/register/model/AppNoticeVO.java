package com.qazit.register.model;

import java.util.Date;

public class AppNoticeVO 
{
	private Integer publicNoticeId;    	//公告id
	private String publicNoticeSn;		//公告编码
	private String publicNoticeName;	//公告名字
	private Byte publicNoticeLevel;		//公告级别
	private Byte status;				//状态
	private Byte publicNoticeOrder;		//公告通知
	private String doctorSn;			//医生编码
	private Date publishedTime;			//公布时间
	private Date deadline;				//截止时间
	private String description;			//内容
	private String hospitalSn;			//医院编码
	private String departmentSn;		//科室编码
	
	private String publishedTime1;
	
	
	
	public String getPublishedTime1() {
		return publishedTime1;
	}
	public void setPublishedTime1(String publishedTime1) {
		this.publishedTime1 = publishedTime1;
	}
	public Date getPublishedTime() {
		return publishedTime;
	}
	public void setPublishedTime(Date publishedTime) {
		this.publishedTime = publishedTime;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Integer getPublicNoticeId() {
		return publicNoticeId;
	}
	public void setPublicNoticeId(Integer publicNoticeId) {
		this.publicNoticeId = publicNoticeId;
	}
	public String getPublicNoticeSn() {
		return publicNoticeSn;
	}
	public void setPublicNoticeSn(String publicNoticeSn) {
		this.publicNoticeSn = publicNoticeSn;
	}
	public String getPublicNoticeName() {
		return publicNoticeName;
	}
	public void setPublicNoticeName(String publicNoticeName) {
		this.publicNoticeName = publicNoticeName;
	}
	public Byte getPublicNoticeLevel() {
		return publicNoticeLevel;
	}
	public void setPublicNoticeLevel(Byte publicNoticeLevel) {
		this.publicNoticeLevel = publicNoticeLevel;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Byte getPublicNoticeOrder() {
		return publicNoticeOrder;
	}
	public void setPublicNoticeOrder(Byte publicNoticeOrder) {
		this.publicNoticeOrder = publicNoticeOrder;
	}
	public String getDoctorSn() {
		return doctorSn;
	}
	public void setDoctorSn(String doctorSn) {
		this.doctorSn = doctorSn;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHospitalSn() {
		return hospitalSn;
	}
	public void setHospitalSn(String hospitalSn) {
		this.hospitalSn = hospitalSn;
	}
	public String getDepartmentSn() {
		return departmentSn;
	}
	public void setDepartmentSn(String departmentSn) {
		this.departmentSn = departmentSn;
	}
	
	
}
