package com.qazit.hospital.web.model;

import java.util.List;

/**
 * 短信参数模板
 * 
 * @author Administrator
 * 
 */
public class SMSParamModel {
	private String customeId;// 客户ID，由医信通平台统一分配。
	private String sign;// 签名,32位MD5字符串
	private int templateType;// 短信模板类型 1 代表：检查/检验结果下发 2 代表：导诊提示
	private long timeStamp;// 时间戳
	private int senderId;//发送者ID
	private int departmentId;//科室ID
	private List<SMSdetalInfo> detalInfos;// 下发数据集合

	public String getCustomeId() {
		return customeId;
	}

	public void setCustomeId(String customeId) {
		this.customeId = customeId;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public int getTemplateType() {
		return templateType;
	}

	public void setTemplateType(int templateType) {
		this.templateType = templateType;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public List<SMSdetalInfo> getDetalInfos() {
		return detalInfos;
	}

	public void setDetalInfos(List<SMSdetalInfo> detalInfos) {
		this.detalInfos = detalInfos;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	

}
