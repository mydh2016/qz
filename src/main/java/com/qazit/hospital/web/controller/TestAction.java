package com.qazit.hospital.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.service.MasSendMsgService;

@Controller
public class TestAction {
	@Resource(name = "masSendServiceImpl")
	private MasSendMsgService masService;
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public JsonModel test1() {
		try {
			//MasService.singleSendMessage("15210402789", "测试短信qqwdwqdqdwd","444", 5, "12345678912345678912345678912345", true, 1);
			 return 	masService.sendMessage(new String[]{"15210402789"}, "测试","234", 1, true, 1, 1);
//			MasService.getReport();
//		  return 	MasService.singleSendMessage("15210402789", "测试短信qqwdwqdqdwd","444", 5, "12345678912345678912345678912345", true, 1);
			// 正式环境IP，登录验证URL，用户名，密码，集团客户名称
//			client.login("http://mas.ecloud.10086.cn/app/sdk/login",
//					"SDK账号名称（不是页面端账号）", "密码", "集团客户名称");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
	
	@RequestMapping(value = "/time")
	@ResponseBody
	public JsonModel payOrderAgain() {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, 2);
		 List<Date> sendDate = new ArrayList<Date>();
		 sendDate.add(calendar.getTime());
	       calendar.set(2017, 0, 6);  //年月日  也可以具体到时分秒如calendar.set(2015, 10, 12,11,32,52); 
	       Date startTime=calendar.getTime();//date就是你需要的时间
	       calendar.set(2017, 0, 8);  //年月日  也可以具体到时分秒如calendar.set(2015, 10, 12,11,32,52); 
	       Date endTime=calendar.getTime();//date就是你需要的时间
		 return 	masService.sendTimedTaskMsg(new String[]{"15210402789"}, "定时短信", "234",3, 1, true, 1, 1, "1", sendDate, startTime, endTime);

}
}

