package com.qazit.register.model;

import java.util.Date;




public class AppDocterVO {
	private Integer doctorId;//医生ID
	private String hospitalSn;//医院编码
	private String hospitalName;
	private String departmentSn;//科室编码
	private String departName;
	private String doctorSn;//医生编码
	private String doctorName;
	private String sex;
	private String educationSn;
	private String profassionalTitle;
	private String biography;
	private String specialty;//专长
	private String specialtyDescription;//专长详情
	private Integer isExpert;//是否专家
	private String expert;
	private Integer status;
	private String picturePath;
	private String telephone;
	
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getExpert() {
		return expert;
	}
	public void setExpert(String expert) {
		this.expert = expert;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
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
	public String getDoctorSn() {
		return doctorSn;
	}
	public void setDoctorSn(String doctorSn) {
		this.doctorSn = doctorSn;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEducationSn() {
		return educationSn;
	}
	public void setEducationSn(String educationSn) {
		this.educationSn = educationSn;
	}
	public String getProfassionalTitle() {
		return profassionalTitle;
	}
	public void setProfassionalTitle(String profassionalTitle) {
		this.profassionalTitle = profassionalTitle;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getSpecialtyDescription() {
		return specialtyDescription;
	}
	public void setSpecialtyDescription(String specialtyDescription) {
		this.specialtyDescription = specialtyDescription;
	}
	public Integer getIsExpert() {
		return isExpert;
	}
	public void setIsExpert(Integer isExpert) {
		this.isExpert = isExpert;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	
	
}
