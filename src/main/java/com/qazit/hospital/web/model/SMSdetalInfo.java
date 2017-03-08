package com.qazit.hospital.web.model;

/**
 * 短信发送详细信息
 * 
 * @author gaohb
 */
public class SMSdetalInfo {
	private String name;// 接收人姓名
	private String mobilePhone;// 接收人手机号
	private String content;// 短信内容

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
