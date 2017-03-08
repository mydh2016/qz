package com.qazit.hospital.web.service;

public interface TimedTaskService {
	
	
	/**
	 * 定时获取上行短信
	 * @return
	 */
	public void getMO();
	
	/**
	 * 获取短信提交报告
	 * @return
	 */
	public void getSubmitReport();
	
	/**
	 * 获取短信状态报告
	 * @return
	 */
	public void getReport();
	
	/**
	 * 定时任务,发送定时短信
	 */
	public void sendTimedMsg();
}
