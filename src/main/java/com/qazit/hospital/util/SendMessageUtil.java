package com.qazit.hospital.util;

import java.util.List;


import com.mascloud.model.MoModel;
import com.mascloud.model.StatusReportModel;
import com.mascloud.model.SubmitReportModel;
import com.mascloud.sdkclient.Client;

public class SendMessageUtil {
	private static Client client;

	public void initMethod() {
		try {
			client = Client.getInstance();
			// masService.sendMessage(new String[]
			// {"13600000000","13600011111"}, "adadad");
			// 正式环境IP，登录验证URL，用户名，密码，集团客户名称
			client.login(ConfigUtil.getProperty("auth.maswsurl"), ConfigUtil
					.getProperty("auth.userAccount"), ConfigUtil
					.getProperty("auth.password"),ConfigUtil.getProperty("auth.ecname"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 短信发送
	 * @param mobiles  手机号数组
	 * @param smsPriority 短信级别
	 * @param content 短信内容
	 * @param msgGroup 发送数据批次号，uuid
	 * @param isMo  是否需要 短信上行
	 * @return
	 */
	public static int sendMessage(String[] mobiles, String content,String addSerial,
			int smsPriority, String msgGroup, boolean isMo) {
		try {
			int sendResult = client.sendDSMS(mobiles, content,addSerial, 1, ConfigUtil
					.getProperty("send.Sign"), msgGroup, isMo);
			return sendResult;
		} catch (Exception e) {
			e.printStackTrace();
			return 500;
		}

	}

	/**
	 * 获取提交报告
	 */
	public static List<SubmitReportModel> getSubmitReport() {
		try {
			List<SubmitReportModel> list = client.getSubmitReport();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 获取状态报告
	 */
	public static List<StatusReportModel> getStatusReport() {
		try {
			List<StatusReportModel> StatusReportlist = client.getReport();
			return StatusReportlist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 获取上行短信
	 */
	public static List<MoModel> getMO() {
		try {
			List<MoModel> lis = client.getMO();
			return lis;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
