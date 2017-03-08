package com.qazit.register.model;

import java.util.Date;

public class AppMedpediaVO {

	private Integer publish_content_id;
	private String publish_content_sn;
	private String publish_content_name;
	private String description;
	private String doctor_sn;
	private Date publish_date;
	private String publishDate;
	private String review_doctor_sn;
	private Date review_date;
	private Integer status;
	private String publish_module_sn;
	
	
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public Integer getPublish_content_id() {
		return publish_content_id;
	}
	public void setPublish_content_id(Integer publish_content_id) {
		this.publish_content_id = publish_content_id;
	}
	public String getPublish_content_sn() {
		return publish_content_sn;
	}
	public void setPublish_content_sn(String publish_content_sn) {
		this.publish_content_sn = publish_content_sn;
	}
	public String getPublish_content_name() {
		return publish_content_name;
	}
	public void setPublish_content_name(String publish_content_name) {
		this.publish_content_name = publish_content_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDoctor_sn() {
		return doctor_sn;
	}
	public void setDoctor_sn(String doctor_sn) {
		this.doctor_sn = doctor_sn;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public String getReview_doctor_sn() {
		return review_doctor_sn;
	}
	public void setReview_doctor_sn(String review_doctor_sn) {
		this.review_doctor_sn = review_doctor_sn;
	}
	public Date getReview_date() {
		return review_date;
	}
	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPublish_module_sn() {
		return publish_module_sn;
	}
	public void setPublish_module_sn(String publish_module_sn) {
		this.publish_module_sn = publish_module_sn;
	}
	
}
