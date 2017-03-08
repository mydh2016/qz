package com.qazit.register.model;

import java.util.Date;
import java.util.List;

/*
 * 科室类型
 * */

public class AppDepartmentTypeVO 
{
	private Integer departmentTypeId;
	private String departmentTypeSn;
	private String departmentTypeName;
	private String description;
	
	private Character pidDicnTypeCode;
	private Character ifDefault;
	private Character dicnState;
	private Character deleteId;
	private Date deleteDate;
	
	private List<AppDepartmentVO> deptList; 
	
	
	public List<AppDepartmentVO> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<AppDepartmentVO> deptList) {
		this.deptList = deptList;
	}
	public Integer getDepartmentTypeId() {
		return departmentTypeId;
	}
	public void setDepartmentTypeId(Integer departmentTypeId) {
		this.departmentTypeId = departmentTypeId;
	}
	public String getDepartmentTypeSn() {
		return departmentTypeSn;
	}
	public void setDepartmentTypeSn(String departmentTypeSn) {
		this.departmentTypeSn = departmentTypeSn;
	}
	public String getDepartmentTypeName() {
		return departmentTypeName;
	}
	public void setDepartmentTypeName(String departmentTypeName) {
		this.departmentTypeName = departmentTypeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Character getPidDicnTypeCode() {
		return pidDicnTypeCode;
	}
	public void setPidDicnTypeCode(Character pidDicnTypeCode) {
		this.pidDicnTypeCode = pidDicnTypeCode;
	}
	public Character getIfDefault() {
		return ifDefault;
	}
	public void setIfDefault(Character ifDefault) {
		this.ifDefault = ifDefault;
	}
	public Character getDicnState() {
		return dicnState;
	}
	public void setDicnState(Character dicnState) {
		this.dicnState = dicnState;
	}
	public Character getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(Character deleteId) {
		this.deleteId = deleteId;
	}
	public Date getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	
}
