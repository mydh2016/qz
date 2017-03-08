package com.qazit.hospital.web.model;

public class Rule {
	private Integer sendType;
	private Integer type;
	private String time;
	private String startTime;
	private String endTime;
	private String cTimes;
	private String weak;
	private String point;
	public Integer getSendType() {
		return sendType;
	}
	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getcTimes() {
		return cTimes;
	}
	public void setcTimes(String cTimes) {
		this.cTimes = cTimes;
	}
	public String getWeak() {
		return weak;
	}
	public void setWeak(String weak) {
		this.weak = weak;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	
}
