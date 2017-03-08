package com.qazit.hospital.web.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Model {

	private Integer id; //主键 id
	private String modelNumber;//模板编号
	private String modelName;//模板名称
	private String modelParentType;//模板大类
	private String modelChildrenType;//模板小类
	private String modelContent;//模板内容
	private Integer parentId;//父id
	private Integer state;//逻辑删除标识 0-正常 1-删除
	private Integer modelStatus;//模板状态 1-启用 2-停用
	private Date createTime;//创建时间 yyyyMMddHHmm(日期格式)
	private String creater;//创建人
	private Date updateTime;//修改时间 yyyyMMddHHmm(日期格式)
	private String updater;//修改人
	private Integer firstRecord;
	private Integer pageSize;
	private Long createrId;
	private String createrName;
	private String hpId;
	private Integer isOn;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelParentType() {
		return modelParentType;
	}
	public void setModelParentType(String modelParentType) {
		this.modelParentType = modelParentType;
	}
	public String getModelChildrenType() {
		return modelChildrenType;
	}
	public void setModelChildrenType(String modelChildrenType) {
		this.modelChildrenType = modelChildrenType;
	}
	public String getModelContent() {
		return modelContent;
	}
	public void setModelContent(String modelContent) {
		this.modelContent = modelContent;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getModelStatus() {
		return modelStatus;
	}
	public void setModelStatus(Integer modelStatus) {
		this.modelStatus = modelStatus;
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
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getUpdateTime() throws ParseException {
		String time=null;
		if(updateTime!=null){
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time=sf.format(updateTime);
		}
		return time;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public static void main(String[] args) {
		Address address=new Address();
		System.out.println(address.getClass().getDeclaredFields()[1]);
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
	public Integer getIsOn() {
		return isOn;
	}
	public void setIsOn(Integer isOn) {
		this.isOn = isOn;
	}
	
}
