package com.qazit.hospital.web.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.qazit.hospital.util.ConfigUtil;
import com.qazit.hospital.util.MD5Utils;
import com.qazit.hospital.util.SendMessageUtil;
import com.qazit.hospital.util.TemplateConfigUtil;
import com.qazit.hospital.web.dao.mapper.TMasAutoSendMapper;
import com.qazit.hospital.web.model.SMSParamModel;
import com.qazit.hospital.web.model.SMSdetalInfo;
import com.qazit.hospital.web.model.TMasAutoSend;
import com.qazit.hospital.web.service.SMSInterfaceService;

public class SMSInterfaceServiceImpl implements SMSInterfaceService {
	private static final Logger logger = Logger
			.getLogger(SMSInterfaceServiceImpl.class);
//	private static final String NAME_MARK = "name";
	@Resource
	private TMasAutoSendMapper tMasAutoSendMapper;

	@Override
	public String sendMessage(SMSParamModel paramModel) {
		try {
			 //签名校验
			boolean flage = checkSign(paramModel.getCustomeId(),paramModel.getTimeStamp(),paramModel.getSign());
			if(!flage){
				logger.info(paramModel.getCustomeId() + "签名校验失败"
						+ paramModel.getSign());
				return "1001";
			}
//			String template = TemplateConfigUtil.getProperty("message."+ paramModel.getTemplateType());//短信模板
//			logger.info(template);
//			if (StringUtils.isBlank(template)) {
//				logger.info(paramModel.getCustomeId() + "模板不存在,模板type="
//						+ paramModel.getTemplateType());
//				return "1002";
//			}
			List<SMSdetalInfo> infos = paramModel.getDetalInfos();
			if (infos.isEmpty()) {
				logger.info(paramModel.getCustomeId() + "请求信息不完整");
				return "1003";
			}
			String sendNumber = getSendNumber(
					paramModel.getCustomeId());
			for (SMSdetalInfo info : infos) {
				String mobile = info.getMobilePhone();// 手机号
				if(StringUtils.isBlank(info.getContent())){
					logger.info(paramModel.getCustomeId() + "发送失败，短信内容为空,姓名="
							+ info.getName() + "手机号=" + info.getMobilePhone());
					continue;
				}
				String content = getContent(info.getContent(), info
						.getName());// 短信内容
				// 记录发信信息
				TMasAutoSend tmas = new TMasAutoSend();
				tmas.setCustomeId(paramModel.getCustomeId());
				tmas.setTemplateType(paramModel.getTemplateType());
				tmas.setName(info.getName());
				tmas.setMobilePhone(mobile);
				tmas.setSendContent(content);
				tmas.setCreateTime(new Date());
				tmas.setSenderId(paramModel.getSenderId());
				tmas.setDepartment(paramModel.getDepartmentId());
				if (StringUtils.isBlank(content)) {
					// 短信内容拼装失败跳出本次循环
					logger.info(paramModel.getCustomeId() + "发送失败，拼装短信内容为空,姓名="
							+ info.getName() + "手机号=" + info.getMobilePhone());
					tmas.setSendState(10);
					tmas.setErrorDesc("获取拼装短信内容为空");
					tMasAutoSendMapper.insertSelective(tmas);
					continue;
				}
				String[] mobiles = { mobile };
				String uuid = UUID.randomUUID().toString();// 32位世界唯一字符串
				uuid = uuid.replace("-", "");
				int smspriority = ConfigUtil
						.getIntProperty("send.sms.priority");// 短信级别
				int res = SendMessageUtil.sendMessage(mobiles, content,
						sendNumber, smspriority, uuid, true);

				// 非1为发送失败
				if (res == 500) {
					logger.info(paramModel.getCustomeId() + "短信接口连接失败,姓名="
							+ info.getName() + "手机号=" + info.getMobilePhone());
					tmas.setSendState(11);
					tmas.setUuid(uuid);
					tmas.setErrorDesc("短信接口连接失败");
					tMasAutoSendMapper.insertSelective(tmas);
					continue;
				}
				if (res == 1) {
					logger.info(paramModel.getCustomeId() + "短信发送成功,姓名="
							+ info.getName() + "手机号=" + info.getMobilePhone());
					tmas.setUuid(uuid);
					tmas.setSendState(0);
					tmas.setSendNumber(sendNumber);
					tmas.setErrorDesc("发送成功");
					tMasAutoSendMapper.insertSelective(tmas);
					continue;
				} else {
					logger.info(paramModel.getCustomeId() + "短信发送失败,姓名="
							+ info.getName() + "手机号=" + info.getMobilePhone()
							+ "返回码=" + res);
					tmas.setUuid(uuid);
					tmas.setSendNumber(sendNumber);
					tmas.setSendState(1);
					tmas.setErrorDesc("发送失败");
					tMasAutoSendMapper.insertSelective(tmas);
					continue;
				}
			}
			return "1000";

		} catch (Exception e) {
			e.printStackTrace();
			TMasAutoSend tmas = new TMasAutoSend();
			tmas.setCustomeId(paramModel.getCustomeId());
			tmas.setTemplateType(paramModel.getTemplateType());
			tmas.setSendState(51);
			tmas.setErrorDesc("发送异常");
			tmas.setCreateTime(new Date());
			tMasAutoSendMapper.insertSelective(tmas);
			return "2001";
		}
	}

	/**
	 * 根据模板类型生成短信内容
	 * 
	 * @param templateType
	 * @param name
	 * @return
	 */
	private String getContent(String center,String name) {
		try {
//			String template = TemplateConfigUtil.getProperty("message."+ templateType);// 短信模板
//			String[] origTemp = template.split(NAME_MARK);
			String content = name+"您好！"+center;
			return content;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String getSendNumber(String customeId) {
		try {
			// String templateNum = TemplateConfigUtil.getProperty("temp.numb."
			// + templateType);// 短信模板对应号码
			String customNum = TemplateConfigUtil.getProperty(customeId);// 短信模板
			return customNum + 999;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	
		
	/**
	 *渠道签名校验，标准（签名正确，签名两分钟内有效）
	 * @param timestamp 时间戳
	 * @param sign 签名
	 * @param source 来源
	 * @return
	 */
	public static boolean checkSign(String customeId,long timeStamp,String sign) {
		boolean flage = false;
		try {
			// 当前时间
			long localTimestamp = System.currentTimeMillis();
			// 时间间隔不能大于两分钟
			long timeDifference = (localTimestamp - timeStamp) / 1000;
			if (timeDifference > 120) {
				logger.info("签名校验失败，时间戳超时，间隔时间" + timeDifference + "秒，请求来源："
						+ customeId);
				return flage;
			}

			// 生成签名sign
			String  key = TemplateConfigUtil.getProperty("md5.key."+customeId);// md5加密密钥
			if (StringUtils.isBlank(key)) {
				logger.info("签名校验失败，获取私钥为空");
				return flage;
			}
			String localSign = MD5Utils.hash(customeId+key+timeStamp);// 签名// 签名
		
			if (!localSign.equals(sign)) {
				logger.info("签名校验失败，本地签名==>" + localSign + "请求签名==>" + sign
						+ "请求来源=" + customeId);
				return flage;
			}

			flage = true;
		} catch (Exception e) {
			logger.info("签名校验失败");
			e.printStackTrace();
		}
		return flage;
	}
}
