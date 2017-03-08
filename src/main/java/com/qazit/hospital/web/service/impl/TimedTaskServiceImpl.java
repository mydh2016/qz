package com.qazit.hospital.web.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mascloud.model.MoModel;
import com.mascloud.model.StatusReportModel;
import com.mascloud.model.SubmitReportModel;
import com.qazit.hospital.util.MsgTaskState;
import com.qazit.hospital.util.SendMessageUtil;
import com.qazit.hospital.web.dao.mapper.TMasMessageMoMapper;
import com.qazit.hospital.web.dao.mapper.TMasMessageMtMapper;
import com.qazit.hospital.web.dao.mapper.TMasTaskQueueMapper;
import com.qazit.hospital.web.dao.mapper.TSendMessageMapper;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.ReciveMessage;
import com.qazit.hospital.web.model.TMasMessageMo;
import com.qazit.hospital.web.model.TMasMessageMt;
import com.qazit.hospital.web.model.TMasMessageMtExample;
import com.qazit.hospital.web.model.TMasTaskQueue;
import com.qazit.hospital.web.model.TMasTaskQueueExample;
import com.qazit.hospital.web.model.TSendMessage;
import com.qazit.hospital.web.service.MasSendMsgService;
import com.qazit.hospital.web.service.ReceiveMessageService;
import com.qazit.hospital.web.service.TimedTaskService;

@Service("timedTaskServiceImpl")
public class TimedTaskServiceImpl  implements TimedTaskService{
	private static final Logger logger = Logger.getLogger(MasSendServiceImpl.class);
	@Resource
	private TMasMessageMoMapper tMasMessageMoMapper;//上行短信
	@Resource
	private TMasMessageMtMapper tMasMessageMtMapper;//下行短信
	@Resource
	private TMasTaskQueueMapper tMasTaskQueueMapper;//短信队列
	@Resource(name = "masSendServiceImpl")
	private MasSendMsgService masService;
	@Resource
	private TSendMessageMapper tSendMessageMapper;//发件箱
	@Resource(name = "receiveMessageService")
	private ReceiveMessageService receiveMessageService;//收件箱
	private SimpleDateFormat ab = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public void getMO() {
		try {
			// 获取上行短信
			List<MoModel> mos = SendMessageUtil.getMO();
			if (mos.isEmpty()) {
				logger.info("定时任务获取上行短信，暂无上行短信。时间-->" + ab.format(new Date()));
				return;
			}
			logger.info("定时任务获取上行短信，暂无上行短信。时间-->" + ab.format(new Date())
					+ "返回条数" + mos.size());
			// 将短信上行短信存入数据库
			for (MoModel mo : mos) {
				// 插入数据库作为记录
				TMasMessageMo tmm = new TMasMessageMo();
				tmm.setSendTime(mo.getSendTime());
				tmm.setSmsContent(mo.getSmsContent());
				tmm.setAddSerial(mo.getAddSerial());
				tmm.setMobile(mo.getMobile());
				tmm.setCreateTime(new Date());
				tMasMessageMoMapper.insertSelective(tmm);
				// 查询出发件箱ID，插入收件箱
				TMasMessageMtExample tme = new TMasMessageMtExample();
				com.qazit.hospital.web.model.TMasMessageMtExample.Criteria tmec = tme
						.createCriteria();
				tmec.andMobileEqualTo(mo.getMobile());
				tmec.andAddSerialEqualTo(mo.getAddSerial());
				tme.setOrderByClause("create_time desc");
				List<TMasMessageMt> listMt = tMasMessageMtMapper
						.selectByExample(tme);
				// 取时间最大的,相当于回复最新一条信息
				TMasMessageMt mt = listMt.get(0);
				// 保存到收件箱
				ReciveMessage receive = new ReciveMessage();
				receive.setSendId(mt.getSendBoxId());// 发件箱ID
				receive.setSmsContent(mo.getSmsContent());
				receive.setAnserTelphone(mo.getMobile());
				receive.setSmsStatus(1);// 设置为未读
				receive.setAnserTime(new Date());// 回复时间
				JsonModel json = new JsonModel();
				receiveMessageService.insert(receive, null, json);
			}
		} catch (Exception e) {
			logger.info("获取上行短信任务异常,时间-->" + ab.format(new Date()));
			e.printStackTrace();

		}

	}
	
	@Override
	public void getSubmitReport() {
		try {
			List<SubmitReportModel> list = SendMessageUtil.getSubmitReport();
			if (list.isEmpty()) {
				logger.info("定时任务获取短信提交MAS状态报告，暂无报告或发生异常。时间-->"
						+ ab.format(new Date()));
				return;
			}
			for (SubmitReportModel srm : list) {

				for (String mobile : srm.getMobiles()) {
					TMasMessageMtExample tme = new TMasMessageMtExample();
					com.qazit.hospital.web.model.TMasMessageMtExample.Criteria tmec = tme
							.createCriteria();
					tmec.andMsgGroupEqualTo(srm.getMsgGroup());
					tmec.andMobileEqualTo(mobile);
					// 通过MsgGroup和手机号信息 查询出发件箱信息,并且查询出就一条
					List<TMasMessageMt> mtList = tMasMessageMtMapper
							.selectByExample(tme);
					// 修改短信功能侧发件信息表状态
					TMasMessageMt mt = new TMasMessageMt();
					mt.setMasErrorCode(srm.getErrorCode());
					mt.setMasReportStatus(srm.getReportStatus());
					if (StringUtils.isNotBlank(srm.getReceiveDate())) {
						mt.setMasReceiveDate(ab.parse(srm.getReceiveDate()));
					}
					if (StringUtils.isNotBlank(srm.getSubmitDate())) {
						mt.setMasSubmitDate(ab.parse(srm.getSubmitDate()));
					}
					logger.info("定时任务获取短信提交短信网关状态报告，MAS返回结果。时间-->"
							+ ab.format(new Date()) + "手机号" + mobile + "返回码-->"
							+ srm.getReportStatus());
					mt.setId(mtList.get(0).getId());
					tMasMessageMtMapper.updateByPrimaryKeySelective(mt);
					// 修改发件箱状态
					// **********************修改短信来源的状态

					TSendMessage tsme = new TSendMessage();
					tsme.setId(mtList.get(0).getSendBoxId());
					// 需要判断回执状态如果发送成功 状态修改成0

					if (srm.getReportStatus().equalsIgnoreCase("CM:0000")) {
						tsme.setState(2);// MAS返回成功
					} else {
						tsme.setState(3);// MAS返回失败
					}
					tSendMessageMapper.updateByPrimaryKeySelective(tsme);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public void getReport() {
		try {
			List<StatusReportModel> list = SendMessageUtil.getStatusReport();
			if (list.isEmpty()) {
				logger.info("定时任务获取短信发送状态报告，暂无报告或发生异常。时间-->" + new Date());
				return;
			}
			// 更新短信发送状态，并且修改短信来源处的状态
			for (StatusReportModel srm : list) {

				TMasMessageMtExample tme = new TMasMessageMtExample();
				com.qazit.hospital.web.model.TMasMessageMtExample.Criteria tmec = tme
						.createCriteria();
				tmec.andMsgGroupEqualTo(srm.getMsgGroup());
				tmec.andMobileEqualTo(srm.getMobile());
				// 通过MsgGroup和手机号信息 查询出发件箱信息,并且查询出就一条
				List<TMasMessageMt> mtList = tMasMessageMtMapper
						.selectByExample(tme);
				// 修改短信功能侧发件信息表状态
				TMasMessageMt mt = new TMasMessageMt();
				mt.setSmsErrorCode(srm.getErrorCode());
				mt.setSmsReportStatus(srm.getReportStatus());
				if (StringUtils.isNotBlank(srm.getReceiveDate())) {
					mt.setSmsReceiveDate(ab.parse(srm.getReceiveDate()));
				}
				if (StringUtils.isNotBlank(srm.getSubmitDate())) {
					mt.setSmsSubmitDate(ab.parse(srm.getSubmitDate()));
				}
				logger.info("定时任务获取短信提交短信网关状态报告，MAS返回结果。时间-->"
						+ ab.format(new Date()) + "手机号" + srm.getMobile()
						+ "返回码-->" + srm.getReportStatus());
				mt.setId(mtList.get(0).getId());
				tMasMessageMtMapper.updateByPrimaryKeySelective(mt);
				// 修改发件箱状态
				// **********************修改短信来源的状态

				TSendMessage tsme = new TSendMessage();
				tsme.setId(mtList.get(0).getSendBoxId());
				// 需要判断回执状态如果发送成功 状态修改成0

				if (srm.getReportStatus().endsWith("0")) {
					tsme.setState(0);// 短信网关返回成功,设置为发送成功
				} else {
					tsme.setState(4);// MAS返回失败
				}
				tSendMessageMapper.updateByPrimaryKeySelective(tsme);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void sendTimedMsg() {
		try {
			logger.info("发送定时任务短信,开始时间-->" + ab.format(new Date()));
			// 查询出小于当前时间的任务进行发送短信
			TMasTaskQueueExample tq = new TMasTaskQueueExample();
			com.qazit.hospital.web.model.TMasTaskQueueExample.Criteria tqc = tq
					.createCriteria();
			tqc.andSendTimeLessThan(new Date());
			List<TMasTaskQueue> listTq = tMasTaskQueueMapper
					.selectByExample(tq);
			if (listTq.isEmpty()) {
				return;
			}
			logger.info("发送定时任务短信,本次发送条数" + listTq.size());
			// 循环发送消息
			for (TMasTaskQueue ttq : listTq) {
				boolean ismo = false;
				 if(ttq.getIsMo()==MsgTaskState.IS_MO){
					 ismo=true;
					}
				//发送短信
				JsonModel jsonModel = masService.sendMessage(new String[] { ttq
						.getMobile() }, ttq.getContent(),ttq.getAddSerial(), 1, ismo, ttq
						.getSendBoxId(), ttq.getModelId());
				 
				// 修改发件箱短信状态
				TSendMessage tsme = new TSendMessage();
				tsme.setId(ttq.getSendBoxId());
				// 需要判断回执状态如果发送成功 状态修改成0
				if (jsonModel.getResultCode().endsWith("1")) {
					//删除任务队列中的数据防止重复发送
					tMasTaskQueueMapper.deleteByPrimaryKey(ttq.getId());
					tsme.setState(1);// 短信网关返回成功,设置为发送成功
				} else {
					TMasTaskQueue queue = new TMasTaskQueue();
					queue.setState(2);
					queue.setId(ttq.getId());
					tMasTaskQueueMapper.updateByPrimaryKeySelective(queue);
					tsme.setState(5);// 发送失败
				}
				tSendMessageMapper.updateByPrimaryKeySelective(tsme);
			}
			logger.info("发送定时任务短信,结束时间-->" + ab.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
}
