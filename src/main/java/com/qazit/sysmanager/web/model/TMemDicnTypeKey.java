package com.qazit.sysmanager.web.model;

public class TMemDicnTypeKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_MEM_DICN_TYPE.dicn_type_id
     *
     * @mbggenerated Wed Feb 22 16:07:35 GMT+08:00 2017
     */
    private Long dicnTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_MEM_DICN_TYPE.dicn_type_code
     *
     * @mbggenerated Wed Feb 22 16:07:35 GMT+08:00 2017
     */
    private String dicnTypeCode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_MEM_DICN_TYPE.dicn_type_id
     *
     * @return the value of T_MEM_DICN_TYPE.dicn_type_id
     *
     * @mbggenerated Wed Feb 22 16:07:35 GMT+08:00 2017
     */
    public Long getDicnTypeId() {
        return dicnTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_MEM_DICN_TYPE.dicn_type_id
     *
     * @param dicnTypeId the value for T_MEM_DICN_TYPE.dicn_type_id
     *
     * @mbggenerated Wed Feb 22 16:07:35 GMT+08:00 2017
     */
    public void setDicnTypeId(Long dicnTypeId) {
        this.dicnTypeId = dicnTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_MEM_DICN_TYPE.dicn_type_code
     *
     * @return the value of T_MEM_DICN_TYPE.dicn_type_code
     *
     * @mbggenerated Wed Feb 22 16:07:35 GMT+08:00 2017
     */
    public String getDicnTypeCode() {
        return dicnTypeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_MEM_DICN_TYPE.dicn_type_code
     *
     * @param dicnTypeCode the value for T_MEM_DICN_TYPE.dicn_type_code
     *
     * @mbggenerated Wed Feb 22 16:07:35 GMT+08:00 2017
     */
    public void setDicnTypeCode(String dicnTypeCode) {
        this.dicnTypeCode = dicnTypeCode == null ? null : dicnTypeCode.trim();
    }
}