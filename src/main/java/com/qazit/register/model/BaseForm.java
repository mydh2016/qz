package com.qazit.register.model;

import java.util.Date;

public class BaseForm {
	private Integer userId;//医生ID
	private String userName;//医生用户名
	private String userPasswd;//密码
	private String positionId;//位置住 
	private String realName;
	private String gender;
	private String qualification;
	private String hospital;//所属医院
	private String depart;//所属科室
	private String jobId;//所属工作
	private String identifyNumber;
	private String userType;
	private String eMail;
	private String cellphoneNumber;
	private String officephoneNumber;
	private String userState;
	private Date effectTime;
	private Date unendTime;
	private Integer erroTest;
	private String specialty;//专长
	private String personalDetails;//个人描述
	private String ifSpecial;//是否是专家
	private String image;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPasswd() {
		return userPasswd;
	}
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
	public String getPositionId() {
		return positionId;
	}
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getCellphoneNumber() {
		return cellphoneNumber;
	}
	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}
	public String getOfficephoneNumber() {
		return officephoneNumber;
	}
	public void setOfficephoneNumber(String officephoneNumber) {
		this.officephoneNumber = officephoneNumber;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public Date getEffectTime() {
		return effectTime;
	}
	public void setEffectTime(Date effectTime) {
		this.effectTime = effectTime;
	}
	public Date getUnendTime() {
		return unendTime;
	}
	public void setUnendTime(Date unendTime) {
		this.unendTime = unendTime;
	}
	public Integer getErroTest() {
		return erroTest;
	}
	public void setErroTest(Integer erroTest) {
		this.erroTest = erroTest;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getPersonalDetails() {
		return personalDetails;
	}
	public void setPersonalDetails(String personalDetails) {
		this.personalDetails = personalDetails;
	}
	public String getIfSpecial() {
		return ifSpecial;
	}
	public void setIfSpecial(String ifSpecial) {
		this.ifSpecial = ifSpecial;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	private Integer productId;
	private Integer departId;
	private String productType;
	private String departName;
	private String hospitalName;
	private Integer orderNumber;
	private Integer orderCount;
	private Float orderPrice;
	//private String userName;
	private String timeSolt;//时段 0 全天 1上午 2 下午 3夜晚
	private Integer consRoom;
	private Date consDate;
	private Integer hospitalId;
	private Float plantPrice;
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
