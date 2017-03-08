package com.qazit.hospital.web.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 院内（外）通讯录
 * @author 张红彬
 *
 */
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;//主键id
	private String name;//姓名
	private Integer sex;//性别
	private String telphone;//电话
	private Date dateBirth;//出生日期 yyyyMMdd
	private Integer departmentId;//科室Id
	private String duties;//职务
	private String title;//职称
	private String unit;//单元
	private String address;//地址
	private Integer status;//内外院区别标识 1-院内 2-院外
	private Integer state;//逻辑删除 0-正常 1-删除
	private Date createTime;//创建时间 yyyyMMddHHmm
	private Date beginTime;//查询条件  出生日期区间-开始时间 yyyyMMdd
	private Date endTime;//查询条件  出生日期区间-结束时间 yyyyMMdd
	private Integer firstRecord;//当前页
	private Integer pageSize;//一页多少条
	private Long createrId;
	private String createrName;
	private String hpId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getDateBirth() {
		String time=null;
		if(dateBirth!=null){
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time=sf.format(dateBirth);
		}
		return time;
	}
	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDuties() {
		return duties;
	}
	public void setDuties(String duties) {
		this.duties = duties;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreateTime() {
		String time=null;
		if(createTime!=null){
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time=sf.format(createTime);
		}
		return time;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getFirstRecord() {
		return firstRecord;
	}
	public void setFirstRecord(Integer firstRecord) {
		this.firstRecord = firstRecord;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Long getCreaterId() {
		return createrId;
	}
	public void setCreaterId(Long createrId) {
		this.createrId = createrId;
	}
	public String getCreaterName() {
		return createrName;
	}
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}
	public String getHpId() {
		return hpId;
	}
	public void setHpId(String hpId) {
		this.hpId = hpId;
	}
	
}
