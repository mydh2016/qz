package com.qazit.hospital.web.model;

import java.util.Date;

public class TMasMessageMo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mas_message_mo.id
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mas_message_mo.state
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mas_message_mo.mobile
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mas_message_mo.sms_content
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    private String smsContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mas_message_mo.send_time
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    private String sendTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mas_message_mo.add_serial
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    private String addSerial;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_mas_message_mo.create_time
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mas_message_mo.id
     *
     * @return the value of t_mas_message_mo.id
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mas_message_mo.id
     *
     * @param id the value for t_mas_message_mo.id
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mas_message_mo.state
     *
     * @return the value of t_mas_message_mo.state
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mas_message_mo.state
     *
     * @param state the value for t_mas_message_mo.state
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mas_message_mo.mobile
     *
     * @return the value of t_mas_message_mo.mobile
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mas_message_mo.mobile
     *
     * @param mobile the value for t_mas_message_mo.mobile
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mas_message_mo.sms_content
     *
     * @return the value of t_mas_message_mo.sms_content
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    public String getSmsContent() {
        return smsContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mas_message_mo.sms_content
     *
     * @param smsContent the value for t_mas_message_mo.sms_content
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    public void setSmsContent(String smsContent) {
        this.smsContent = smsContent == null ? null : smsContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mas_message_mo.send_time
     *
     * @return the value of t_mas_message_mo.send_time
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    public String getSendTime() {
        return sendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mas_message_mo.send_time
     *
     * @param sendTime the value for t_mas_message_mo.send_time
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    public void setSendTime(String sendTime) {
        this.sendTime = sendTime == null ? null : sendTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mas_message_mo.add_serial
     *
     * @return the value of t_mas_message_mo.add_serial
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    public String getAddSerial() {
        return addSerial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mas_message_mo.add_serial
     *
     * @param addSerial the value for t_mas_message_mo.add_serial
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    public void setAddSerial(String addSerial) {
        this.addSerial = addSerial == null ? null : addSerial.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_mas_message_mo.create_time
     *
     * @return the value of t_mas_message_mo.create_time
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_mas_message_mo.create_time
     *
     * @param createTime the value for t_mas_message_mo.create_time
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}