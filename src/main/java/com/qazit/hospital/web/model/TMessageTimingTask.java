package com.qazit.hospital.web.model;

import java.util.Date;

public class TMessageTimingTask {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_MESSAGE_TIMING_TASK.id
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_MESSAGE_TIMING_TASK.send_box_id
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    private Integer sendBoxId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_MESSAGE_TIMING_TASK.msg_group
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    private String msgGroup;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_MESSAGE_TIMING_TASK.sms_priority
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    private Integer smsPriority;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_MESSAGE_TIMING_TASK.add_serial
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    private String addSerial;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_MESSAGE_TIMING_TASK.is_mo
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    private Integer isMo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_MESSAGE_TIMING_TASK.target_mobile
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    private String targetMobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_MESSAGE_TIMING_TASK.content
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_MESSAGE_TIMING_TASK.task_type
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    private Integer taskType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_MESSAGE_TIMING_TASK.model_id
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    private Integer modelId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_MESSAGE_TIMING_TASK.task_satus
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    private Integer taskSatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_MESSAGE_TIMING_TASK.update_time
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_MESSAGE_TIMING_TASK.create_time
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_MESSAGE_TIMING_TASK.id
     *
     * @return the value of T_MESSAGE_TIMING_TASK.id
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_MESSAGE_TIMING_TASK.id
     *
     * @param id the value for T_MESSAGE_TIMING_TASK.id
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_MESSAGE_TIMING_TASK.send_box_id
     *
     * @return the value of T_MESSAGE_TIMING_TASK.send_box_id
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public Integer getSendBoxId() {
        return sendBoxId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_MESSAGE_TIMING_TASK.send_box_id
     *
     * @param sendBoxId the value for T_MESSAGE_TIMING_TASK.send_box_id
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public void setSendBoxId(Integer sendBoxId) {
        this.sendBoxId = sendBoxId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_MESSAGE_TIMING_TASK.msg_group
     *
     * @return the value of T_MESSAGE_TIMING_TASK.msg_group
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public String getMsgGroup() {
        return msgGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_MESSAGE_TIMING_TASK.msg_group
     *
     * @param msgGroup the value for T_MESSAGE_TIMING_TASK.msg_group
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public void setMsgGroup(String msgGroup) {
        this.msgGroup = msgGroup == null ? null : msgGroup.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_MESSAGE_TIMING_TASK.sms_priority
     *
     * @return the value of T_MESSAGE_TIMING_TASK.sms_priority
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public Integer getSmsPriority() {
        return smsPriority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_MESSAGE_TIMING_TASK.sms_priority
     *
     * @param smsPriority the value for T_MESSAGE_TIMING_TASK.sms_priority
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public void setSmsPriority(Integer smsPriority) {
        this.smsPriority = smsPriority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_MESSAGE_TIMING_TASK.add_serial
     *
     * @return the value of T_MESSAGE_TIMING_TASK.add_serial
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public String getAddSerial() {
        return addSerial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_MESSAGE_TIMING_TASK.add_serial
     *
     * @param addSerial the value for T_MESSAGE_TIMING_TASK.add_serial
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public void setAddSerial(String addSerial) {
        this.addSerial = addSerial == null ? null : addSerial.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_MESSAGE_TIMING_TASK.is_mo
     *
     * @return the value of T_MESSAGE_TIMING_TASK.is_mo
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public Integer getIsMo() {
        return isMo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_MESSAGE_TIMING_TASK.is_mo
     *
     * @param isMo the value for T_MESSAGE_TIMING_TASK.is_mo
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public void setIsMo(Integer isMo) {
        this.isMo = isMo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_MESSAGE_TIMING_TASK.target_mobile
     *
     * @return the value of T_MESSAGE_TIMING_TASK.target_mobile
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public String getTargetMobile() {
        return targetMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_MESSAGE_TIMING_TASK.target_mobile
     *
     * @param targetMobile the value for T_MESSAGE_TIMING_TASK.target_mobile
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public void setTargetMobile(String targetMobile) {
        this.targetMobile = targetMobile == null ? null : targetMobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_MESSAGE_TIMING_TASK.content
     *
     * @return the value of T_MESSAGE_TIMING_TASK.content
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_MESSAGE_TIMING_TASK.content
     *
     * @param content the value for T_MESSAGE_TIMING_TASK.content
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_MESSAGE_TIMING_TASK.task_type
     *
     * @return the value of T_MESSAGE_TIMING_TASK.task_type
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public Integer getTaskType() {
        return taskType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_MESSAGE_TIMING_TASK.task_type
     *
     * @param taskType the value for T_MESSAGE_TIMING_TASK.task_type
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_MESSAGE_TIMING_TASK.model_id
     *
     * @return the value of T_MESSAGE_TIMING_TASK.model_id
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public Integer getModelId() {
        return modelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_MESSAGE_TIMING_TASK.model_id
     *
     * @param modelId the value for T_MESSAGE_TIMING_TASK.model_id
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_MESSAGE_TIMING_TASK.task_satus
     *
     * @return the value of T_MESSAGE_TIMING_TASK.task_satus
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public Integer getTaskSatus() {
        return taskSatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_MESSAGE_TIMING_TASK.task_satus
     *
     * @param taskSatus the value for T_MESSAGE_TIMING_TASK.task_satus
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public void setTaskSatus(Integer taskSatus) {
        this.taskSatus = taskSatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_MESSAGE_TIMING_TASK.update_time
     *
     * @return the value of T_MESSAGE_TIMING_TASK.update_time
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_MESSAGE_TIMING_TASK.update_time
     *
     * @param updateTime the value for T_MESSAGE_TIMING_TASK.update_time
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_MESSAGE_TIMING_TASK.create_time
     *
     * @return the value of T_MESSAGE_TIMING_TASK.create_time
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_MESSAGE_TIMING_TASK.create_time
     *
     * @param createTime the value for T_MESSAGE_TIMING_TASK.create_time
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}