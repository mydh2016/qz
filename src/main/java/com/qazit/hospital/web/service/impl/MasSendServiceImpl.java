package com.qazit.hospital.web.service.impl;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.qazit.hospital.util.ConfigUtil;
import com.qazit.hospital.util.MsgTaskState;
import com.qazit.hospital.util.SendMessageUtil;
import com.qazit.hospital.web.dao.mapper.TMasMessageMtMapper;
import com.qazit.hospital.web.dao.mapper.TMasNumberContrastModelMapper;
import com.qazit.hospital.web.dao.mapper.TMasTaskQueueMapper;
import com.qazit.hospital.web.dao.mapper.TMasTimingRecordMapper;
import com.qazit.hospital.web.dao.mapper.TMasWaitSendMsgMapper;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.TMasMessageMt;
import com.qazit.hospital.web.model.TMasNumberContrastModel;
import com.qazit.hospital.web.model.TMasNumberContrastModelExample;
import com.qazit.hospital.web.model.TMasTaskQueue;
import com.qazit.hospital.web.model.TMasTimingRecord;
import com.qazit.hospital.web.model.TMasWaitSendMsg;
import com.qazit.hospital.web.service.MasSendMsgService;

@Service("masSendServiceImpl")
public class MasSendServiceImpl implements MasSendMsgService {

	private static final Logger logger = Logger
			.getLogger(MasSendServiceImpl.class);
	private static final int STATUS_NO_CHECK = 1;// 1：已发送，短信结果未查询

	@Resource
	private TMasTimingRecordMapper tMasTimingRecordMapper;// 任务记录表
	@Resource
	private TMasNumberContrastModelMapper tmncmms;// 获取发送短信号码后三位数
	@Resource
	private TMasMessageMtMapper tMasMessageMtMapper;
	@Resource
	private TMasTaskQueueMapper tMasTaskQueueMapper;// 任务队列
	@Resource
	private TMasWaitSendMsgMapper tMasWaitSendMsgMapper;

	/**
	 * 短信发送
	 */
	@Override
	public JsonModel sendMessage(String[] mobiles, String content,String addSerial,
			int smsPriority, boolean isMo, int sendBoxId, Integer modelId) {
		JsonModel json = new JsonModel();
		// 存入短信的表
		try {
			if(modelId==null){
				json.setJsonData("503", "模板ID不能为空!");
				return json;
			}
			// 参数校验
			if (mobiles == null || mobiles.length == 0 || content == null
					|| sendBoxId == 0 ) {
				json.setJsonData("501", "短信发送失败，参数校验失败！");
				return json;
			}
			// 参数校验
			if (StringUtils.isBlank(addSerial)) {
				json.setJsonData("504", "医院扩展码不能为空！");
				return json;
			}
			
			//短信是否允许上行(允许上行的短信要模板要找对应的号码，不允许上行的使用统一号码发送)
			String number="";//发送短信的扩展码
			int moStatus=0;
            if(isMo){
            	moStatus = MsgTaskState.IS_MO;
            	String  modelNum = getMasNumber(modelId,addSerial);//获取模板对应的号码
            	if (StringUtils.isBlank(modelNum)) {
    				json.setJsonData("505", "短信发送失败，生成短信模板扩展码失败！");
    				return json;
    			}
            	if (modelNum.equals("10000")) {
    				json.setJsonData("506", "短信发送失败，扩展码已达到最大数量！");
    				return json;
    			}
            	
            	
            	number = addSerial.trim()+modelNum;
			}else{
				moStatus = MsgTaskState.IS_NOT_MO;
				//不需要上行的短信接口后三位数为固定的号码
				String notMoNub=ConfigUtil.getProperty("isnotmo.number");
				number =addSerial.trim()+notMoNub;
			}
			
			if (StringUtils.isBlank(number)) {
				json.setJsonData("502", "短信发送失败，生成短信号码扩展码失败！");
				return json;
			}
			String uuid = UUID.randomUUID().toString();// 32位世界唯一字符串
			uuid = uuid.replace("-", "");
			int smspriority = ConfigUtil.getIntProperty("send.sms.priority");// 短信级别
			int res = SendMessageUtil.sendMessage(mobiles, content, number,
					smspriority, uuid, isMo);
			for (String mobile : mobiles) {
				TMasMessageMt tmm = new TMasMessageMt();
				tmm.setAddSerial(ConfigUtil.getProperty("send.add.serial")+number);
				tmm.setCreateTime(new Date());
				tmm.setIsMo(moStatus);// 暂时默认是允许上行的
				tmm.setMobile(mobile);
				tmm.setSmsPriority(smspriority);
				tmm.setModelId(modelId);
				tmm.setMsgGroup(uuid);
				tmm.setSendBoxId(sendBoxId);
				tmm.setSmsContent(content);
				tmm.setState(res);
				tMasMessageMtMapper.insertSelective(tmm);
			}
			logger.info("短信网关返回值==" + res + "手机号" + mobiles);
			// 非1为发送失败
			if (res == 500) {
				json.setJsonData(String.valueOf(res), "短信接口连接失败");
				return json;
			}
			if (res == STATUS_NO_CHECK) {
				logger.info("短信发送成功==" + mobiles);
				json.setJsonData("0", "短信已发送");

			} else {
				logger.info("短信发送失败，手机号==" + mobiles);
				json.setJsonData(String.valueOf(res), "短信发送失败，短信网关返回码" + res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("50", "短信发送异常");
		}
		return json;
	}



	@Override
	public JsonModel sendTimedTaskMsg(String[] mobiles, String content,String addSerial,
			int modelId, int smsPriority, boolean isMo, int sendBoxId,
			int timedType, String rule, List<Date> sendDate, Date startTime,
			Date endTime) {
		JsonModel json = new JsonModel();
		try {
			if (mobiles == null || StringUtils.isBlank(content) || modelId == 0
					|| sendBoxId == 0) {
				json.setJsonData("501", "参数校验失败");
				return json;
			}
			if (StringUtils.isBlank(addSerial)) {
				json.setJsonData("502", "短信发送失败 ,短信号码扩展码不能为空！");
				return json;
			}
			//短信是否允许上行(允许上行的短信要模板要找对应的号码，不允许上行的使用统一号码发送)
			int moStatus=0;
            if(isMo){
            	moStatus = MsgTaskState.IS_MO;
			}else{
				moStatus = MsgTaskState.IS_NOT_MO;
			}
			
			Date nowDate = new Date();
			//校验开始时间大于当前时间
			if (startTime != null && endTime != null) {
				// boolean res = timeCompare(startTime);
				// 结束时间小于当前时间
				if (endTime.getTime() < nowDate.getTime()) {
					json.setJsonData("508", "结束时间不能小于当前时间");
					return json;
				}
				// 当前时间大于开始时间，从当前时间开始计算
				if (startTime.getTime() < nowDate.getTime()) {
					startTime = nowDate;
				}
			}
			
			// 将信息插入任务记录表,并返回ID
			TMasTimingRecord tmr = new TMasTimingRecord();
			tmr.setAddSerial(addSerial);
			tmr.setCreateTime(new Date());
			tmr.setEndSendTime(endTime);
			tmr.setIsMo(moStatus);
			tmr.setModelId(modelId);
			tmr.setSendBoxId(sendBoxId);
			tmr.setSendModel(1);
			tmr.setSendRule(2);
			tmr.setSmsPriority(ConfigUtil.getIntProperty("send.sms.priority"));
			tmr.setStartSendTime(startTime);
			tmr.setState(1);
			tmr.setTimingType(timedType);
			tMasTimingRecordMapper.insertSelective(tmr);
			// 插入单个手机号放入任务队列记录表TMasWaitSendMsg(发送信息记录表)
			for (String mobile : mobiles) {
				TMasWaitSendMsg tms = new TMasWaitSendMsg();
				tms.setContent(content);
				tms.setCreateTime(new Date());
				tms.setMobile(mobile);
				tms.setModelId(modelId);
				tms.setSendBoxId(sendBoxId);
				tms.setTimingRecordId(tmr.getId());
				// 插入队列表
				json = addTimerTask(mobile, content, modelId, smsPriority,
						isMo, sendBoxId, timedType, rule, sendDate, startTime,
						endTime, tmr.getId(), addSerial);
				if ("0".equals(json.getResultCode())) {
					tms.setState(MsgTaskState.WAIT_SEND_ADD_TASK_OK);
				} else {
					tms.setState(MsgTaskState.WAIT_SEND_ADD_TASK_FAIL);
				}
				tMasWaitSendMsgMapper.insertSelective(tms);
			}
			json.setJsonData("0", "成功保存定到定时任务队列！");
		} catch (Exception e) {
			json.setJsonData("50", "保存定时任务信息异常！");
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 根据定时类型添加任务队列
	 * 
	 * @param mobiles
	 * @param content
	 * @param modelId
	 * @param smsPriority
	 * @param isMo
	 * @param sendBoxId
	 * @param timedType
	 * @param rule
	 * @param sendDate
	 * @param startTime
	 * @param endTime
	 * @param recordId
	 * @param addSerial
	 * @return
	 */
	private JsonModel addTimerTask(String mobile, String content, int modelId,
			int smsPriority, boolean isMo, int sendBoxId, int timedType,
			String rule, List<Date> sendDate, Date startTime, Date endTime,
			int recordId, String addSerial) {
		JsonModel json = new JsonModel();
		try {
			if (MsgTaskState.RECORD_TYPE_ONLY_ONE == timedType) {
				// 仅发送一次,直接通过设置的时间存入任务队列
				insertTimeTask(mobile, content, modelId, smsPriority, isMo,
						sendBoxId, sendDate.get(0), recordId, addSerial);
				json.setJsonData("0", "仅一次，保存到任务队列成功");
				return json;
			} else if (MsgTaskState.RECORD_TYPE_EVERY_DAY == timedType) {
				// 每天发送，先获取时间段内的说有发送时间
				List<Date> list = getEveryDayByTimeSlot(Integer.valueOf(rule),
						startTime, endTime);
				if (list.isEmpty()) {
					json.setJsonData("502", "每天发送，获取发送时间失败");
					return json;
				}

				for (Date sendTime : list) {
					insertTimeTask(mobile, content, modelId, smsPriority, isMo,
							sendBoxId, sendTime, recordId, addSerial);
				}
				json.setJsonData("0", "每天发送,保存到任务队列成功");
				return json;

			} else if (MsgTaskState.RECORD_TYPE_EVERY_MONTH == timedType) {
				// 每月发送
				List<Date> list = getMonthDayByTimeSlot(rule, startTime,
						endTime);
				if (list.isEmpty()) {
					json.setJsonData("502", "每月发送，获取发送时间失败");
					return json;
				}

				for (Date sendTime : list) {
					insertTimeTask(mobile, content, modelId, smsPriority, isMo,
							sendBoxId, sendTime, recordId, addSerial);
				}
				json.setJsonData("0", "每月发送,保存到任务队列成功");
				return json;

			} else if (MsgTaskState.RECORD_TYPE_EVERY_WEEK == timedType) {
				// 每周发送
				List<Date> list = getWeekByTimeSlot(rule, startTime, endTime);
				if (list.isEmpty()) {
					json.setJsonData("502", "每月发送，获取发送时间失败");
					return json;
				}
				for (Date sendTime : list) {
					insertTimeTask(mobile, content, modelId, smsPriority, isMo,
							sendBoxId, sendTime, recordId, addSerial);
				}
				json.setJsonData("0", "每周发送,保存到任务队列成功");
				return json;

			} else if (MsgTaskState.RECORD_TYPE_SELF == timedType) {
				// 自定义发送
				for (Date sendTime : sendDate) {
					insertTimeTask(mobile, content, modelId, smsPriority, isMo,
							sendBoxId, sendTime, recordId, addSerial);
				}
				json.setJsonData("0", "自定义发送,保存到任务队列成功");
				return json;
			} else {
				json.setJsonData("501", "定时类型不存在");
				return json;
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("500", "添加到定时任务队列异常");
		}
		return json;
	}

	/**
	 * 待发送信息插入任务队列
	 * 
	 * @param mobile
	 * @param content
	 * @param modelId
	 * @param smsPriority
	 * @param isMo
	 * @param sendBoxId
	 * @param sendDate
	 * @param recordId
	 * @param addSerial
	 */
	private void insertTimeTask(String mobile, String content, int modelId,
			int smsPriority, boolean isMo, int sendBoxId, Date sendDate,
			int recordId, String addSerial) {
		try {
			TMasTaskQueue ttq = new TMasTaskQueue();
			ttq.setAddSerial(addSerial);
			ttq.setContent(content);
			ttq.setCreateTime(new Date());
			ttq.setIsMo(1);
			ttq.setMobile(mobile);
			ttq.setModelId(modelId);
			ttq.setSendBoxId(sendBoxId);
			ttq.setSendTime(sendDate);
			ttq.setSmsPriority(smsPriority);
			ttq.setState(MsgTaskState.TASK_STATUS_WAIT_SEND);// 设置为等待发送的状态
			ttq.setTimingRecordId(recordId);
			tMasTaskQueueMapper.insertSelective(ttq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据模板id获取短信发送号码扩展码 规则:若存在对应关系,返回当前数.若不存在获取最大数加1并插入
	 * 
	 * @param modelId
	 * @return
	 */
	private String getMasNumber(int modelId,String addSerial) {
		try {
			TMasNumberContrastModelExample tne = new TMasNumberContrastModelExample();
			com.qazit.hospital.web.model.TMasNumberContrastModelExample.Criteria tnc = tne
					.createCriteria();
			tnc.andModelIdEqualTo(modelId);
			tnc.andAddSerialEqualTo(addSerial);
			// 检查模板ID以前有没有生成过后三位数,如果生成用当前最大数,如果没有生成就在最大的三位数上加1 新生成一个
			List<TMasNumberContrastModel> list = tmncmms.selectByExample(tne);
			if (list.isEmpty()) {
				// 没有生成重新生成一个，查询当前最大的数+1
				Integer maxNum = tmncmms.maxRandomNum(addSerial);//获取每个医院的最大值
				if (maxNum == null) {
					maxNum = 1;
				} else {
					if(maxNum>998){
						logger.error("模板号码达到最大数量!");
						return String.valueOf(10000);
					}
					maxNum = maxNum + 1;
				}
				TMasNumberContrastModel model = new TMasNumberContrastModel();
				model.setModelId(modelId);// 模板ID
				model.setRandomNum(maxNum);// 发送号码后三位数
				model.setState(MsgTaskState.NUMBER_STATUS_OK);// 模板正常使用
				model.setCreateTime(new Date());
				model.setAddSerial(addSerial);
				tmncmms.insertSelective(model);
				return String.valueOf(maxNum);
			}
			// 如果存在使用以前的三位数
			int maxNum = list.get(0).getRandomNum();
			return String.valueOf(maxNum);

		} catch (Exception e) {
			logger.error("生成短信发送号码后三位异常" + e);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取时间段内有个有几个周N
	 * 
	 * @param rule
	 *            1#2 代表星期一的凌晨两点 0是星期天
	 * @param startDate
	 * @param endTime
	 * @return
	 */
	private List<Date> getWeekByTimeSlot(String rule, Date startDate,
			Date endTime) {
		try {
			String[] parms = rule.split("#");
			int week = Integer.valueOf(parms[0]);// 周几
			int hour = Integer.valueOf(parms[1]);// 几点
			Calendar c_begin = new GregorianCalendar();
			Calendar c_end = new GregorianCalendar();
			DateFormatSymbols dfs = new DateFormatSymbols();
			String[] weeks = dfs.getWeekdays();
			// c_begin.set(); //Calendar的月从0-11，所以4月是3.
			c_begin.setTime(startDate);
			c_end.setTime(endTime); // Calendar的月从0-11，所以5月是4.
			int count = 1;
			c_end.add(Calendar.DAY_OF_YEAR, 1); // 结束日期下滚一天是为了包含最后一天
			List<Date> list = new ArrayList<Date>();
			while (c_begin.before(c_end)) {
				int day = c_begin.get(Calendar.DAY_OF_WEEK) - 1;
				if (day == week) {
					Calendar start = new GregorianCalendar();
					start = c_begin;
					SimpleDateFormat ab = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					start.set(Calendar.HOUR_OF_DAY, hour);
					start.set(Calendar.MINUTE, 0);
					start.set(Calendar.SECOND, 0);
					list.add(start.getTime());
					logger.info("每周发送短信获取日期，第" + count + "周  日期："
							+ ab.format(start.getTime()) + ","
							+ weeks[start.get(Calendar.DAY_OF_WEEK)]);
					count++;
					c_begin.add(Calendar.DAY_OF_YEAR, 1);
				}
				
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取时间段内每个月的 N号(例如获取每个月的12号)
	 * 
	 * @param rule
	 *            1#2 代表每个月1号的凌晨2点
	 * @param startDate
	 * @param endTime
	 * @return
	 */
	private List<Date> getMonthDayByTimeSlot(String rule, Date startDate,
			Date endTime) {
		try {
			String[] parms = rule.split("#");
			int dayNumb = Integer.valueOf(parms[0]);// 周几
			int hour = Integer.valueOf(parms[1]);// 几点
			Calendar c_begin = new GregorianCalendar();
			Calendar c_end = new GregorianCalendar();
			// c_begin.set(); //Calendar的月从0-11，所以4月是3.
			c_begin.setTime(startDate);
			c_end.setTime(endTime); // Calendar的月从0-11，所以5月是4.
			int count = 1;
			c_end.add(Calendar.DAY_OF_YEAR, 1); // 结束日期下滚一天是为了包含最后一天
			List<Date> list = new ArrayList<Date>();
			while (c_begin.before(c_end)) {
				int day = c_begin.get(Calendar.DAY_OF_WEEK);
				if (day == dayNumb) {
					Calendar start = new GregorianCalendar();
					start = c_begin;
					SimpleDateFormat ab = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					start.set(Calendar.HOUR_OF_DAY, hour);
					start.set(Calendar.MINUTE, 0);
					start.set(Calendar.SECOND, 0);
					list.add(start.getTime());
					logger.info("每月发送短信获取日期，第" + count + "次  日期："
							+ ab.format(start.getTime()));
					count++;
					c_begin.add(Calendar.DAY_OF_YEAR, 1);
				}
			
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取时间段内每天的 几点
	 * 
	 * @param hour
	 *            每天的第几个小时
	 * @param startDate
	 * @param endTime
	 * @return
	 */
	private List<Date> getEveryDayByTimeSlot(int hour, Date startDate,
			Date endTime) {
		try {
			Calendar c_begin = new GregorianCalendar();
			Calendar c_end = new GregorianCalendar();
			// c_begin.set(); //Calendar的月从0-11，所以4月是3.
			c_begin.setTime(startDate);
			c_end.setTime(endTime); // Calendar的月从0-11，所以5月是4.
			int count = 1;
			c_end.add(Calendar.DAY_OF_YEAR, 1); // 结束日期下滚一天是为了包含最后一天
			List<Date> list = new ArrayList<Date>();
			while (c_begin.before(c_end)) {
				Calendar start = new GregorianCalendar();
				SimpleDateFormat ab = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				start = c_begin;
				start.set(Calendar.HOUR_OF_DAY, hour);
				start.set(Calendar.MINUTE, 0);
				start.set(Calendar.SECOND, 0);
				list.add(start.getTime());
				logger.info("每天发送短信获取日期，第" + count + "次  日期："
						+ ab.format(start.getTime()));
				count++;
				c_begin.add(Calendar.DAY_OF_YEAR, 1);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 开始时间大于当前时间校验
	 * @param startTime
	 * @return
	 */
//	private boolean timeCompare(Date startTime) {
//		try {
//			// 开始时间
//			Calendar start = Calendar.getInstance();
//			start.setTime(startTime);
//			start.set(Calendar.HOUR_OF_DAY, 0);
//			start.set(Calendar.MINUTE, 0);
//			start.set(Calendar.SECOND, 0);
//			// 当前时间
//			Calendar nowTime = Calendar.getInstance();
//			nowTime.setTime(new Date());
//			nowTime.set(Calendar.HOUR_OF_DAY, 0);
//			nowTime.set(Calendar.MINUTE, 0);
//			nowTime.set(Calendar.SECOND, 0);
//			// 当前时间小于开始时间
//			if (nowTime.getTimeInMillis() < start.getTimeInMillis()) {
//				return true;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//
//	}
	

}
