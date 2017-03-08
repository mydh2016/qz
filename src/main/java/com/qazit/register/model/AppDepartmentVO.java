package com.qazit.register.model;


/*
 * 科室
 * */
public class AppDepartmentVO 
{
	private Integer departmentId;			//科室Id号	
	private String hospitalSn;				//医院编码--由医院表Hospital的hcode获取
	private String departmentSn;			//医院科室编码
	
	private String departmentName;			//医院科室名称
	private String departmentTypeSn;		//科室类型号
	private String description;				//联系人电话--家庭成员的电话
	
	private Byte isSpecialDepartment;		//是否为特色科室
	private String specialDescription;		//特色科室介绍
	private String picturePath;				//图片路径
	
	private String telephone;				//科室办公电话
	private Byte status;					//状态--是否正常开设
	
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
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
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentTypeSn() {
		return departmentTypeSn;
	}
	public void setDepartmentTypeSn(String departmentTypeSn) {
		this.departmentTypeSn = departmentTypeSn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Byte getIsSpecialDepartment() {
		return isSpecialDepartment;
	}
	public void setIsSpecialDepartment(Byte isSpecialDepartment) {
		this.isSpecialDepartment = isSpecialDepartment;
	}
	public String getSpecialDescription() {
		return specialDescription;
	}
	public void setSpecialDescription(String specialDescription) {
		this.specialDescription = specialDescription;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	
	
}
