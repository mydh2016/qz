package com.qazit.hospital.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMasTaskQueueExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    public TMasTaskQueueExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSendBoxIdIsNull() {
            addCriterion("send_box_id is null");
            return (Criteria) this;
        }

        public Criteria andSendBoxIdIsNotNull() {
            addCriterion("send_box_id is not null");
            return (Criteria) this;
        }

        public Criteria andSendBoxIdEqualTo(Integer value) {
            addCriterion("send_box_id =", value, "sendBoxId");
            return (Criteria) this;
        }

        public Criteria andSendBoxIdNotEqualTo(Integer value) {
            addCriterion("send_box_id <>", value, "sendBoxId");
            return (Criteria) this;
        }

        public Criteria andSendBoxIdGreaterThan(Integer value) {
            addCriterion("send_box_id >", value, "sendBoxId");
            return (Criteria) this;
        }

        public Criteria andSendBoxIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_box_id >=", value, "sendBoxId");
            return (Criteria) this;
        }

        public Criteria andSendBoxIdLessThan(Integer value) {
            addCriterion("send_box_id <", value, "sendBoxId");
            return (Criteria) this;
        }

        public Criteria andSendBoxIdLessThanOrEqualTo(Integer value) {
            addCriterion("send_box_id <=", value, "sendBoxId");
            return (Criteria) this;
        }

        public Criteria andSendBoxIdIn(List<Integer> values) {
            addCriterion("send_box_id in", values, "sendBoxId");
            return (Criteria) this;
        }

        public Criteria andSendBoxIdNotIn(List<Integer> values) {
            addCriterion("send_box_id not in", values, "sendBoxId");
            return (Criteria) this;
        }

        public Criteria andSendBoxIdBetween(Integer value1, Integer value2) {
            addCriterion("send_box_id between", value1, value2, "sendBoxId");
            return (Criteria) this;
        }

        public Criteria andSendBoxIdNotBetween(Integer value1, Integer value2) {
            addCriterion("send_box_id not between", value1, value2, "sendBoxId");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(Integer value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(Integer value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(Integer value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(Integer value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(Integer value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<Integer> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<Integer> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(Integer value1, Integer value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andTimingRecordIdIsNull() {
            addCriterion("timing_record_id is null");
            return (Criteria) this;
        }

        public Criteria andTimingRecordIdIsNotNull() {
            addCriterion("timing_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andTimingRecordIdEqualTo(Integer value) {
            addCriterion("timing_record_id =", value, "timingRecordId");
            return (Criteria) this;
        }

        public Criteria andTimingRecordIdNotEqualTo(Integer value) {
            addCriterion("timing_record_id <>", value, "timingRecordId");
            return (Criteria) this;
        }

        public Criteria andTimingRecordIdGreaterThan(Integer value) {
            addCriterion("timing_record_id >", value, "timingRecordId");
            return (Criteria) this;
        }

        public Criteria andTimingRecordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("timing_record_id >=", value, "timingRecordId");
            return (Criteria) this;
        }

        public Criteria andTimingRecordIdLessThan(Integer value) {
            addCriterion("timing_record_id <", value, "timingRecordId");
            return (Criteria) this;
        }

        public Criteria andTimingRecordIdLessThanOrEqualTo(Integer value) {
            addCriterion("timing_record_id <=", value, "timingRecordId");
            return (Criteria) this;
        }

        public Criteria andTimingRecordIdIn(List<Integer> values) {
            addCriterion("timing_record_id in", values, "timingRecordId");
            return (Criteria) this;
        }

        public Criteria andTimingRecordIdNotIn(List<Integer> values) {
            addCriterion("timing_record_id not in", values, "timingRecordId");
            return (Criteria) this;
        }

        public Criteria andTimingRecordIdBetween(Integer value1, Integer value2) {
            addCriterion("timing_record_id between", value1, value2, "timingRecordId");
            return (Criteria) this;
        }

        public Criteria andTimingRecordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("timing_record_id not between", value1, value2, "timingRecordId");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSmsPriorityIsNull() {
            addCriterion("sms_priority is null");
            return (Criteria) this;
        }

        public Criteria andSmsPriorityIsNotNull() {
            addCriterion("sms_priority is not null");
            return (Criteria) this;
        }

        public Criteria andSmsPriorityEqualTo(Integer value) {
            addCriterion("sms_priority =", value, "smsPriority");
            return (Criteria) this;
        }

        public Criteria andSmsPriorityNotEqualTo(Integer value) {
            addCriterion("sms_priority <>", value, "smsPriority");
            return (Criteria) this;
        }

        public Criteria andSmsPriorityGreaterThan(Integer value) {
            addCriterion("sms_priority >", value, "smsPriority");
            return (Criteria) this;
        }

        public Criteria andSmsPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("sms_priority >=", value, "smsPriority");
            return (Criteria) this;
        }

        public Criteria andSmsPriorityLessThan(Integer value) {
            addCriterion("sms_priority <", value, "smsPriority");
            return (Criteria) this;
        }

        public Criteria andSmsPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("sms_priority <=", value, "smsPriority");
            return (Criteria) this;
        }

        public Criteria andSmsPriorityIn(List<Integer> values) {
            addCriterion("sms_priority in", values, "smsPriority");
            return (Criteria) this;
        }

        public Criteria andSmsPriorityNotIn(List<Integer> values) {
            addCriterion("sms_priority not in", values, "smsPriority");
            return (Criteria) this;
        }

        public Criteria andSmsPriorityBetween(Integer value1, Integer value2) {
            addCriterion("sms_priority between", value1, value2, "smsPriority");
            return (Criteria) this;
        }

        public Criteria andSmsPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("sms_priority not between", value1, value2, "smsPriority");
            return (Criteria) this;
        }

        public Criteria andAddSerialIsNull() {
            addCriterion("add_serial is null");
            return (Criteria) this;
        }

        public Criteria andAddSerialIsNotNull() {
            addCriterion("add_serial is not null");
            return (Criteria) this;
        }

        public Criteria andAddSerialEqualTo(String value) {
            addCriterion("add_serial =", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialNotEqualTo(String value) {
            addCriterion("add_serial <>", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialGreaterThan(String value) {
            addCriterion("add_serial >", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialGreaterThanOrEqualTo(String value) {
            addCriterion("add_serial >=", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialLessThan(String value) {
            addCriterion("add_serial <", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialLessThanOrEqualTo(String value) {
            addCriterion("add_serial <=", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialLike(String value) {
            addCriterion("add_serial like", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialNotLike(String value) {
            addCriterion("add_serial not like", value, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialIn(List<String> values) {
            addCriterion("add_serial in", values, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialNotIn(List<String> values) {
            addCriterion("add_serial not in", values, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialBetween(String value1, String value2) {
            addCriterion("add_serial between", value1, value2, "addSerial");
            return (Criteria) this;
        }

        public Criteria andAddSerialNotBetween(String value1, String value2) {
            addCriterion("add_serial not between", value1, value2, "addSerial");
            return (Criteria) this;
        }

        public Criteria andMsgGroupIsNull() {
            addCriterion("msg_group is null");
            return (Criteria) this;
        }

        public Criteria andMsgGroupIsNotNull() {
            addCriterion("msg_group is not null");
            return (Criteria) this;
        }

        public Criteria andMsgGroupEqualTo(String value) {
            addCriterion("msg_group =", value, "msgGroup");
            return (Criteria) this;
        }

        public Criteria andMsgGroupNotEqualTo(String value) {
            addCriterion("msg_group <>", value, "msgGroup");
            return (Criteria) this;
        }

        public Criteria andMsgGroupGreaterThan(String value) {
            addCriterion("msg_group >", value, "msgGroup");
            return (Criteria) this;
        }

        public Criteria andMsgGroupGreaterThanOrEqualTo(String value) {
            addCriterion("msg_group >=", value, "msgGroup");
            return (Criteria) this;
        }

        public Criteria andMsgGroupLessThan(String value) {
            addCriterion("msg_group <", value, "msgGroup");
            return (Criteria) this;
        }

        public Criteria andMsgGroupLessThanOrEqualTo(String value) {
            addCriterion("msg_group <=", value, "msgGroup");
            return (Criteria) this;
        }

        public Criteria andMsgGroupLike(String value) {
            addCriterion("msg_group like", value, "msgGroup");
            return (Criteria) this;
        }

        public Criteria andMsgGroupNotLike(String value) {
            addCriterion("msg_group not like", value, "msgGroup");
            return (Criteria) this;
        }

        public Criteria andMsgGroupIn(List<String> values) {
            addCriterion("msg_group in", values, "msgGroup");
            return (Criteria) this;
        }

        public Criteria andMsgGroupNotIn(List<String> values) {
            addCriterion("msg_group not in", values, "msgGroup");
            return (Criteria) this;
        }

        public Criteria andMsgGroupBetween(String value1, String value2) {
            addCriterion("msg_group between", value1, value2, "msgGroup");
            return (Criteria) this;
        }

        public Criteria andMsgGroupNotBetween(String value1, String value2) {
            addCriterion("msg_group not between", value1, value2, "msgGroup");
            return (Criteria) this;
        }

        public Criteria andIsMoIsNull() {
            addCriterion("is_mo is null");
            return (Criteria) this;
        }

        public Criteria andIsMoIsNotNull() {
            addCriterion("is_mo is not null");
            return (Criteria) this;
        }

        public Criteria andIsMoEqualTo(Integer value) {
            addCriterion("is_mo =", value, "isMo");
            return (Criteria) this;
        }

        public Criteria andIsMoNotEqualTo(Integer value) {
            addCriterion("is_mo <>", value, "isMo");
            return (Criteria) this;
        }

        public Criteria andIsMoGreaterThan(Integer value) {
            addCriterion("is_mo >", value, "isMo");
            return (Criteria) this;
        }

        public Criteria andIsMoGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_mo >=", value, "isMo");
            return (Criteria) this;
        }

        public Criteria andIsMoLessThan(Integer value) {
            addCriterion("is_mo <", value, "isMo");
            return (Criteria) this;
        }

        public Criteria andIsMoLessThanOrEqualTo(Integer value) {
            addCriterion("is_mo <=", value, "isMo");
            return (Criteria) this;
        }

        public Criteria andIsMoIn(List<Integer> values) {
            addCriterion("is_mo in", values, "isMo");
            return (Criteria) this;
        }

        public Criteria andIsMoNotIn(List<Integer> values) {
            addCriterion("is_mo not in", values, "isMo");
            return (Criteria) this;
        }

        public Criteria andIsMoBetween(Integer value1, Integer value2) {
            addCriterion("is_mo between", value1, value2, "isMo");
            return (Criteria) this;
        }

        public Criteria andIsMoNotBetween(Integer value1, Integer value2) {
            addCriterion("is_mo not between", value1, value2, "isMo");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated do_not_delete_during_merge Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}