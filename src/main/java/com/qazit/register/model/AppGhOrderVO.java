package com.qazit.register.model;

import java.util.Date;

public class AppGhOrderVO {
	private Integer orderId;
	private Integer userId;
	private Integer productId;
	private String realName;
	private Date orderDate;//创建时间
	private String identityNumber;
	private String departName;//科室名称
	private String hospitalName;//医院名称
	private String time;//就诊日期
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private String timeSolt;//就诊时间
	private String doctorName;//医生名字
	private Float surplus;//诊费
	
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getTimeSolt() {
		return timeSolt;
	}
	public void setTimeSolt(String timeSolt) {
		this.timeSolt = timeSolt;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Float getSurplus() {
		return surplus;
	}
	public void setSurplus(Float surplus) {
		this.surplus = surplus;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	
	
	
}
