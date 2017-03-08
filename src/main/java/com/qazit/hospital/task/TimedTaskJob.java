package com.qazit.hospital.task;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.qazit.hospital.web.service.TimedTaskService;

@Component
@Lazy(value = false)
public class TimedTaskJob {
	
	@Resource(name = "timedTaskServiceImpl")
	private TimedTaskService timedTaskService;

	/**
	 * 定时查询短信发送状态并且做业务处理（每2分钟执行一次）
	 */                
	@Scheduled(cron = "0 0/2 * * * ?")
	public void getReport() {
		timedTaskService.getReport();
	}

	/**
	 * 定时查询短信提交状态并且做业务处理（每2分钟执行一次）
	 */
	@Scheduled(cron = "0 0/2 * * * ?")
	public void getSubmitReport() {
		timedTaskService.getSubmitReport();
	}

	/**
	 * 定时从短信网关获取上行短信（每5分钟执行一次）
	 */
	@Scheduled(cron = "0 0/5 * * * ?")
	public void getMO() {
		timedTaskService.getMO();
	}

	/**
	 * 发送定时短信（每3分钟执行一次）
	 */
	@Scheduled(cron = "0 0/3 * * * ?")
	public void sendTimedMsg() {
		timedTaskService.sendTimedMsg();
	}

}
