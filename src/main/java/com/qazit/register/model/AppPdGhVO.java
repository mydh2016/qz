package com.qazit.register.model;

import java.util.Date;

public class AppPdGhVO {
	private Integer productId;
	private Integer departId;
	private String productType;
	private String departName;
	private String hospitalName;
	private Integer orderNumber;
	private Integer orderCount;
	private Float orderPrice;
	private String userName;
	private String timeSolt;//时段 0 全天 1上午 2 下午 3夜晚
	private Integer consRoom;
	private Date consDate;
	private Integer hospitalId;
	private Float plantPrice;
	private Float surplus;
	private String status;
	private String strDate;
	
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Float getSurplus() {
		return surplus;
	}
	public void setSurplus(Float surplus) {
		this.surplus = surplus;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getDepartId() {
		return departId;
	}
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
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
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Integer getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}
	public Float getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Float orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTimeSolt() {
		return timeSolt;
	}
	public void setTimeSolt(String timeSolt) {
		this.timeSolt = timeSolt;
	}
	public Integer getConsRoom() {
		return consRoom;
	}
	public void setConsRoom(Integer consRoom) {
		this.consRoom = consRoom;
	}
	public Date getConsDate() {
		return consDate;
	}
	public void setConsDate(Date consDate) {
		this.consDate = consDate;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Float getPlantPrice() {
		return plantPrice;
	}
	public void setPlantPrice(Float plantPrice) {
		this.plantPrice = plantPrice;
	}
	
	
}
