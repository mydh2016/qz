package com.qazit.hospital.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecycleBoxExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
     */
    public RecycleBoxExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
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
     * This method corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
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

        public Criteria andRefIdIsNull() {
            addCriterion("ref_id is null");
            return (Criteria) this;
        }

        public Criteria andRefIdIsNotNull() {
            addCriterion("ref_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefIdEqualTo(Integer value) {
            addCriterion("ref_id =", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdNotEqualTo(Integer value) {
            addCriterion("ref_id <>", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdGreaterThan(Integer value) {
            addCriterion("ref_id >", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ref_id >=", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdLessThan(Integer value) {
            addCriterion("ref_id <", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdLessThanOrEqualTo(Integer value) {
            addCriterion("ref_id <=", value, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdIn(List<Integer> values) {
            addCriterion("ref_id in", values, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdNotIn(List<Integer> values) {
            addCriterion("ref_id not in", values, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdBetween(Integer value1, Integer value2) {
            addCriterion("ref_id between", value1, value2, "refId");
            return (Criteria) this;
        }

        public Criteria andRefIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ref_id not between", value1, value2, "refId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andSendNameIsNull() {
            addCriterion("send_name is null");
            return (Criteria) this;
        }

        public Criteria andSendNameIsNotNull() {
            addCriterion("send_name is not null");
            return (Criteria) this;
        }

        public Criteria andSendNameEqualTo(String value) {
            addCriterion("send_name =", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameNotEqualTo(String value) {
            addCriterion("send_name <>", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameGreaterThan(String value) {
            addCriterion("send_name >", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameGreaterThanOrEqualTo(String value) {
            addCriterion("send_name >=", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameLessThan(String value) {
            addCriterion("send_name <", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameLessThanOrEqualTo(String value) {
            addCriterion("send_name <=", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameLike(String value) {
            addCriterion("send_name like", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameNotLike(String value) {
            addCriterion("send_name not like", value, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameIn(List<String> values) {
            addCriterion("send_name in", values, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameNotIn(List<String> values) {
            addCriterion("send_name not in", values, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameBetween(String value1, String value2) {
            addCriterion("send_name between", value1, value2, "sendName");
            return (Criteria) this;
        }

        public Criteria andSendNameNotBetween(String value1, String value2) {
            addCriterion("send_name not between", value1, value2, "sendName");
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

        public Criteria andSendTelphoneIsNull() {
            addCriterion("send_telphone is null");
            return (Criteria) this;
        }

        public Criteria andSendTelphoneIsNotNull() {
            addCriterion("send_telphone is not null");
            return (Criteria) this;
        }

        public Criteria andSendTelphoneEqualTo(String value) {
            addCriterion("send_telphone =", value, "sendTelphone");
            return (Criteria) this;
        }

        public Criteria andSendTelphoneNotEqualTo(String value) {
            addCriterion("send_telphone <>", value, "sendTelphone");
            return (Criteria) this;
        }

        public Criteria andSendTelphoneGreaterThan(String value) {
            addCriterion("send_telphone >", value, "sendTelphone");
            return (Criteria) this;
        }

        public Criteria andSendTelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("send_telphone >=", value, "sendTelphone");
            return (Criteria) this;
        }

        public Criteria andSendTelphoneLessThan(String value) {
            addCriterion("send_telphone <", value, "sendTelphone");
            return (Criteria) this;
        }

        public Criteria andSendTelphoneLessThanOrEqualTo(String value) {
            addCriterion("send_telphone <=", value, "sendTelphone");
            return (Criteria) this;
        }

        public Criteria andSendTelphoneLike(String value) {
            addCriterion("send_telphone like", value, "sendTelphone");
            return (Criteria) this;
        }

        public Criteria andSendTelphoneNotLike(String value) {
            addCriterion("send_telphone not like", value, "sendTelphone");
            return (Criteria) this;
        }

        public Criteria andSendTelphoneIn(List<String> values) {
            addCriterion("send_telphone in", values, "sendTelphone");
            return (Criteria) this;
        }

        public Criteria andSendTelphoneNotIn(List<String> values) {
            addCriterion("send_telphone not in", values, "sendTelphone");
            return (Criteria) this;
        }

        public Criteria andSendTelphoneBetween(String value1, String value2) {
            addCriterion("send_telphone between", value1, value2, "sendTelphone");
            return (Criteria) this;
        }

        public Criteria andSendTelphoneNotBetween(String value1, String value2) {
            addCriterion("send_telphone not between", value1, value2, "sendTelphone");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIsNull() {
            addCriterion("receive_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIsNotNull() {
            addCriterion("receive_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveNameEqualTo(String value) {
            addCriterion("receive_name =", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotEqualTo(String value) {
            addCriterion("receive_name <>", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameGreaterThan(String value) {
            addCriterion("receive_name >", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameGreaterThanOrEqualTo(String value) {
            addCriterion("receive_name >=", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLessThan(String value) {
            addCriterion("receive_name <", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLessThanOrEqualTo(String value) {
            addCriterion("receive_name <=", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameLike(String value) {
            addCriterion("receive_name like", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotLike(String value) {
            addCriterion("receive_name not like", value, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameIn(List<String> values) {
            addCriterion("receive_name in", values, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotIn(List<String> values) {
            addCriterion("receive_name not in", values, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameBetween(String value1, String value2) {
            addCriterion("receive_name between", value1, value2, "receiveName");
            return (Criteria) this;
        }

        public Criteria andReceiveNameNotBetween(String value1, String value2) {
            addCriterion("receive_name not between", value1, value2, "receiveName");
            return (Criteria) this;
        }

        public Criteria andRecevieTimeIsNull() {
            addCriterion("recevie_time is null");
            return (Criteria) this;
        }

        public Criteria andRecevieTimeIsNotNull() {
            addCriterion("recevie_time is not null");
            return (Criteria) this;
        }

        public Criteria andRecevieTimeEqualTo(Date value) {
            addCriterion("recevie_time =", value, "recevieTime");
            return (Criteria) this;
        }

        public Criteria andRecevieTimeNotEqualTo(Date value) {
            addCriterion("recevie_time <>", value, "recevieTime");
            return (Criteria) this;
        }

        public Criteria andRecevieTimeGreaterThan(Date value) {
            addCriterion("recevie_time >", value, "recevieTime");
            return (Criteria) this;
        }

        public Criteria andRecevieTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("recevie_time >=", value, "recevieTime");
            return (Criteria) this;
        }

        public Criteria andRecevieTimeLessThan(Date value) {
            addCriterion("recevie_time <", value, "recevieTime");
            return (Criteria) this;
        }

        public Criteria andRecevieTimeLessThanOrEqualTo(Date value) {
            addCriterion("recevie_time <=", value, "recevieTime");
            return (Criteria) this;
        }

        public Criteria andRecevieTimeIn(List<Date> values) {
            addCriterion("recevie_time in", values, "recevieTime");
            return (Criteria) this;
        }

        public Criteria andRecevieTimeNotIn(List<Date> values) {
            addCriterion("recevie_time not in", values, "recevieTime");
            return (Criteria) this;
        }

        public Criteria andRecevieTimeBetween(Date value1, Date value2) {
            addCriterion("recevie_time between", value1, value2, "recevieTime");
            return (Criteria) this;
        }

        public Criteria andRecevieTimeNotBetween(Date value1, Date value2) {
            addCriterion("recevie_time not between", value1, value2, "recevieTime");
            return (Criteria) this;
        }

        public Criteria andRecevieTelphoneIsNull() {
            addCriterion("recevie_telphone is null");
            return (Criteria) this;
        }

        public Criteria andRecevieTelphoneIsNotNull() {
            addCriterion("recevie_telphone is not null");
            return (Criteria) this;
        }

        public Criteria andRecevieTelphoneEqualTo(String value) {
            addCriterion("recevie_telphone =", value, "recevieTelphone");
            return (Criteria) this;
        }

        public Criteria andRecevieTelphoneNotEqualTo(String value) {
            addCriterion("recevie_telphone <>", value, "recevieTelphone");
            return (Criteria) this;
        }

        public Criteria andRecevieTelphoneGreaterThan(String value) {
            addCriterion("recevie_telphone >", value, "recevieTelphone");
            return (Criteria) this;
        }

        public Criteria andRecevieTelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("recevie_telphone >=", value, "recevieTelphone");
            return (Criteria) this;
        }

        public Criteria andRecevieTelphoneLessThan(String value) {
            addCriterion("recevie_telphone <", value, "recevieTelphone");
            return (Criteria) this;
        }

        public Criteria andRecevieTelphoneLessThanOrEqualTo(String value) {
            addCriterion("recevie_telphone <=", value, "recevieTelphone");
            return (Criteria) this;
        }

        public Criteria andRecevieTelphoneLike(String value) {
            addCriterion("recevie_telphone like", value, "recevieTelphone");
            return (Criteria) this;
        }

        public Criteria andRecevieTelphoneNotLike(String value) {
            addCriterion("recevie_telphone not like", value, "recevieTelphone");
            return (Criteria) this;
        }

        public Criteria andRecevieTelphoneIn(List<String> values) {
            addCriterion("recevie_telphone in", values, "recevieTelphone");
            return (Criteria) this;
        }

        public Criteria andRecevieTelphoneNotIn(List<String> values) {
            addCriterion("recevie_telphone not in", values, "recevieTelphone");
            return (Criteria) this;
        }

        public Criteria andRecevieTelphoneBetween(String value1, String value2) {
            addCriterion("recevie_telphone between", value1, value2, "recevieTelphone");
            return (Criteria) this;
        }

        public Criteria andRecevieTelphoneNotBetween(String value1, String value2) {
            addCriterion("recevie_telphone not between", value1, value2, "recevieTelphone");
            return (Criteria) this;
        }

        public Criteria andDeleteIdIsNull() {
            addCriterion("delete_id is null");
            return (Criteria) this;
        }

        public Criteria andDeleteIdIsNotNull() {
            addCriterion("delete_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteIdEqualTo(Long value) {
            addCriterion("delete_id =", value, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdNotEqualTo(Long value) {
            addCriterion("delete_id <>", value, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdGreaterThan(Long value) {
            addCriterion("delete_id >", value, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdGreaterThanOrEqualTo(Long value) {
            addCriterion("delete_id >=", value, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdLessThan(Long value) {
            addCriterion("delete_id <", value, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdLessThanOrEqualTo(Long value) {
            addCriterion("delete_id <=", value, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdIn(List<Long> values) {
            addCriterion("delete_id in", values, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdNotIn(List<Long> values) {
            addCriterion("delete_id not in", values, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdBetween(Long value1, Long value2) {
            addCriterion("delete_id between", value1, value2, "deleteId");
            return (Criteria) this;
        }

        public Criteria andDeleteIdNotBetween(Long value1, Long value2) {
            addCriterion("delete_id not between", value1, value2, "deleteId");
            return (Criteria) this;
        }

        public Criteria andHpIdIsNull() {
            addCriterion("hp_id is null");
            return (Criteria) this;
        }

        public Criteria andHpIdIsNotNull() {
            addCriterion("hp_id is not null");
            return (Criteria) this;
        }

        public Criteria andHpIdEqualTo(String value) {
            addCriterion("hp_id =", value, "hpId");
            return (Criteria) this;
        }

        public Criteria andHpIdNotEqualTo(String value) {
            addCriterion("hp_id <>", value, "hpId");
            return (Criteria) this;
        }

        public Criteria andHpIdGreaterThan(String value) {
            addCriterion("hp_id >", value, "hpId");
            return (Criteria) this;
        }

        public Criteria andHpIdGreaterThanOrEqualTo(String value) {
            addCriterion("hp_id >=", value, "hpId");
            return (Criteria) this;
        }

        public Criteria andHpIdLessThan(String value) {
            addCriterion("hp_id <", value, "hpId");
            return (Criteria) this;
        }

        public Criteria andHpIdLessThanOrEqualTo(String value) {
            addCriterion("hp_id <=", value, "hpId");
            return (Criteria) this;
        }

        public Criteria andHpIdLike(String value) {
            addCriterion("hp_id like", value, "hpId");
            return (Criteria) this;
        }

        public Criteria andHpIdNotLike(String value) {
            addCriterion("hp_id not like", value, "hpId");
            return (Criteria) this;
        }

        public Criteria andHpIdIn(List<String> values) {
            addCriterion("hp_id in", values, "hpId");
            return (Criteria) this;
        }

        public Criteria andHpIdNotIn(List<String> values) {
            addCriterion("hp_id not in", values, "hpId");
            return (Criteria) this;
        }

        public Criteria andHpIdBetween(String value1, String value2) {
            addCriterion("hp_id between", value1, value2, "hpId");
            return (Criteria) this;
        }

        public Criteria andHpIdNotBetween(String value1, String value2) {
            addCriterion("hp_id not between", value1, value2, "hpId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table recycle_box
     *
     * @mbggenerated do_not_delete_during_merge Fri Feb 17 09:59:47 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table recycle_box
     *
     * @mbggenerated Fri Feb 17 09:59:47 CST 2017
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