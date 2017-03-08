package com.qazit.hospital.web.service;


import java.util.Date;
import java.util.List;

import com.qazit.hospital.web.model.JsonModel;

public interface MasSendMsgService {

	/**
	 * 发送短信(1,单发一个手机号,2群发数组多个手机号)
	 * @param mobiles  手机号数组
	 * @param content 短信内容
	 * @param addSerial 医院对应的扩展码
	 * @param sendBoxId 发件箱ID
	 * @param smsPriority 短信优先级，取值1-5，填其余值，系统默认选择1, 1最低，5最高
	 * @param modelId 模板ID
	 * @param isMo  是否需要 短信上行
	 * @return
	 */
	public JsonModel sendMessage(String[] mobiles, String content,String addSerial,int smsPriority,boolean isMo,int sendBoxId,Integer modelId);
	
	
	
	/**
	 * 发送定时短信
	 * @param mobiles  手机号数组
	 * @param content 短信内容
	 * @param sendBoxId 发件箱ID
	 * @param smsPriority 短信优先级，取值1-5，填其余值，系统默认选择1, 1最低，5最高
	 * @param isMo  是否需要 短信上行
	 * @param sendBoxId 发件箱ID
	 * @param  timedType 定时任务类型1：仅发送一次，2:每天发送，3：每周发送，4：每月发送，5：自定义发送
	 * @param  rule 参数规则   例子（星期一12点发送参数为 1#12，星期几用0到6代表，0为星期天）（每月12号凌晨发送为 12#0，每月几号用1到31代表，小时为0到23，0为凌晨24点 ）
	 *@param sendDate  1：仅发送一次 和 5：自定义发送 时使用
	 * @param startTime 开始发送时间
	 * @param endTime 结束时间
	 * @return
	 */
	public JsonModel sendTimedTaskMsg(String[] mobiles, String content,String addSerial,int modelId,int smsPriority,boolean isMo,int sendBoxId,int timedType ,String rule,List<Date> sendDate,Date startTime,Date endTime);
	

	
	
	

	
	
	
	
}
