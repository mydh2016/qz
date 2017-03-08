package com.qazit.hospital.web.model;

public class DepartmentType {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department_type.DEPARTMENT_TYPE_ID
     *
     * @mbggenerated Tue Feb 21 10:03:13 CST 2017
     */
    private Integer departmentTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department_type.DEPARTMENT_TYPE_SN
     *
     * @mbggenerated Tue Feb 21 10:03:13 CST 2017
     */
    private String departmentTypeSn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department_type.DEPARTMENT_TYPE_NAME
     *
     * @mbggenerated Tue Feb 21 10:03:13 CST 2017
     */
    private String departmentTypeName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department_type.DESCRIPTION
     *
     * @mbggenerated Tue Feb 21 10:03:13 CST 2017
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department_type.HP_ID
     *
     * @mbggenerated Tue Feb 21 10:03:13 CST 2017
     */
    private String hpId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department_type.DEPARTMENT_TYPE_ID
     *
     * @return the value of department_type.DEPARTMENT_TYPE_ID
     *
     * @mbggenerated Tue Feb 21 10:03:13 CST 2017
     */
    public Integer getDepartmentTypeId() {
        return departmentTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department_type.DEPARTMENT_TYPE_ID
     *
     * @param departmentTypeId the value for department_type.DEPARTMENT_TYPE_ID
     *
     * @mbggenerated Tue Feb 21 10:03:13 CST 2017
     */
    public void setDepartmentTypeId(Integer departmentTypeId) {
        this.departmentTypeId = departmentTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department_type.DEPARTMENT_TYPE_SN
     *
     * @return the value of department_type.DEPARTMENT_TYPE_SN
     *
     * @mbggenerated Tue Feb 21 10:03:13 CST 2017
     */
    public String getDepartmentTypeSn() {
        return departmentTypeSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department_type.DEPARTMENT_TYPE_SN
     *
     * @param departmentTypeSn the value for department_type.DEPARTMENT_TYPE_SN
     *
     * @mbggenerated Tue Feb 21 10:03:13 CST 2017
     */
    public void setDepartmentTypeSn(String departmentTypeSn) {
        this.departmentTypeSn = departmentTypeSn == null ? null : departmentTypeSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department_type.DEPARTMENT_TYPE_NAME
     *
     * @return the value of department_type.DEPARTMENT_TYPE_NAME
     *
     * @mbggenerated Tue Feb 21 10:03:13 CST 2017
     */
    public String getDepartmentTypeName() {
        return departmentTypeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department_type.DEPARTMENT_TYPE_NAME
     *
     * @param departmentTypeName the value for department_type.DEPARTMENT_TYPE_NAME
     *
     * @mbggenerated Tue Feb 21 10:03:13 CST 2017
     */
    public void setDepartmentTypeName(String departmentTypeName) {
        this.departmentTypeName = departmentTypeName == null ? null : departmentTypeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department_type.DESCRIPTION
     *
     * @return the value of department_type.DESCRIPTION
     *
     * @mbggenerated Tue Feb 21 10:03:13 CST 2017
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department_type.DESCRIPTION
     *
     * @param description the value for department_type.DESCRIPTION
     *
     * @mbggenerated Tue Feb 21 10:03:13 CST 2017
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department_type.HP_ID
     *
     * @return the value of department_type.HP_ID
     *
     * @mbggenerated Tue Feb 21 10:03:13 CST 2017
     */
    public String getHpId() {
        return hpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department_type.HP_ID
     *
     * @param hpId the value for department_type.HP_ID
     *
     * @mbggenerated Tue Feb 21 10:03:13 CST 2017
     */
    public void setHpId(String hpId) {
        this.hpId = hpId == null ? null : hpId.trim();
    }
}