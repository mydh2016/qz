package com.qazit.sysmanager.web.model;

import java.util.Date;

import com.qazit.sysmanager.util.AbstractPage;

public class User  extends AbstractPage{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_id
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_name
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private String userName;
    
    private String oldUserName;
    
    public String getOldUserName() {
		return oldUserName;
	}

	public void setOldUserName(String oldUserName) {
		this.oldUserName = oldUserName;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.is_admin
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private Integer isAdmin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.hospitalId
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private String hospitalId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.mobile_phone
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private String mobilePhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.is_deleted
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private Integer isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.create_user_id
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private Long createUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.create_time
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.city_id
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private Integer cityId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.office_phone
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private String officePhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.last_login_time
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private Date lastLoginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.address
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.description
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.init_status
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private Integer initStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.delete_time
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private Date deleteTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.delete_user_id
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    private Integer deleteUserId;

    private Integer departmentId;
    
    private String departmentName;
    
    /**
     * 医院编码
     */
    private String hospitalNo;
    
    public String getHospitalNo() {
		return hospitalNo;
	}

	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_id
     *
     * @return the value of user.user_id
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_id
     *
     * @param userId the value for user.user_id
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_name
     *
     * @return the value of user.user_name
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_name
     *
     * @param userName the value for user.user_name
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.is_admin
     *
     * @return the value of user.is_admin
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public Integer getIsAdmin() {
        return isAdmin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.is_admin
     *
     * @param isAdmin the value for user.is_admin
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.hospitalId
     *
     * @return the value of user.hospitalId
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public String getHospitalId() {
        return hospitalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.hospitalId
     *
     * @param hospitalId the value for user.hospitalId
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId == null ? null : hospitalId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email
     *
     * @return the value of user.email
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public String getEmail() {
        return email;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.email
     *
     * @param email the value for user.email
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.mobile_phone
     *
     * @return the value of user.mobile_phone
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.mobile_phone
     *
     * @param mobilePhone the value for user.mobile_phone
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.is_deleted
     *
     * @return the value of user.is_deleted
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.is_deleted
     *
     * @param isDeleted the value for user.is_deleted
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.create_user_id
     *
     * @return the value of user.create_user_id
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.create_user_id
     *
     * @param createUserId the value for user.create_user_id
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.create_time
     *
     * @return the value of user.create_time
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.create_time
     *
     * @param createTime the value for user.create_time
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.city_id
     *
     * @return the value of user.city_id
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.city_id
     *
     * @param cityId the value for user.city_id
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.office_phone
     *
     * @return the value of user.office_phone
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public String getOfficePhone() {
        return officePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.office_phone
     *
     * @param officePhone the value for user.office_phone
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone == null ? null : officePhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.last_login_time
     *
     * @return the value of user.last_login_time
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.last_login_time
     *
     * @param lastLoginTime the value for user.last_login_time
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.address
     *
     * @return the value of user.address
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.address
     *
     * @param address the value for user.address
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.description
     *
     * @return the value of user.description
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.description
     *
     * @param description the value for user.description
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.init_status
     *
     * @return the value of user.init_status
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public Integer getInitStatus() {
        return initStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.init_status
     *
     * @param initStatus the value for user.init_status
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setInitStatus(Integer initStatus) {
        this.initStatus = initStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.delete_time
     *
     * @return the value of user.delete_time
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.delete_time
     *
     * @param deleteTime the value for user.delete_time
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.delete_user_id
     *
     * @return the value of user.delete_user_id
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public Integer getDeleteUserId() {
        return deleteUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.delete_user_id
     *
     * @param deleteUserId the value for user.delete_user_id
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    public void setDeleteUserId(Integer deleteUserId) {
        this.deleteUserId = deleteUserId;
    }
}