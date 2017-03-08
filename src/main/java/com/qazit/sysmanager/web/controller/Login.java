package com.qazit.sysmanager.web.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.sysmanager.util.MD5Utils;
import com.qazit.sysmanager.web.model.JsonResultMessage;
import com.qazit.sysmanager.web.security.UserSessionOperator;
import com.qazit.sysmanager.web.service.IPartnerService;

@Controller
public class Login {

	private static final Logger logger = Logger.getLogger(Login.class);

	/**
	 * 跳转登陆页面
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String proName = request.getContextPath();
		Subject currentUser = SecurityUtils.getSubject();
		try {
			if (!currentUser.isAuthenticated()) {
				response.sendRedirect(proName + "/hospital/login.html");
			} else {
//				String currUserName = UserSessionOperator.getCurrentUserName();
//				if ("auditor".equals(currUserName)) {
//					response.sendRedirect(proName + "/admin/indexAuditor.html");
//					return null;
//				} else if ("admin".equals(currUserName)) {
//					response.sendRedirect(proName + "/admin/index.html");
//					return null;
//				} else {
//					response.sendRedirect(proName + "/admin/indexChannel.html");
//				}
				response.sendRedirect(proName + "/hospital/index.html");
				return null;
			}
		} catch (Exception e) {
			logger.debug("登陆出错");
		}
		return null;
	}

	@Resource
	private IPartnerService partnerServiceImpl;
	
	/**
	 * 检查用户是否登陆
	 * 
	 * @return
	 */
	@RequestMapping(value = "/check")
	@ResponseBody
	public JsonResultMessage check(String userName, String pwd,String hospitalNO) {
		JsonResultMessage jsonResultMessage = null;
		try {
			jsonResultMessage = new JsonResultMessage();
			pwd = MD5Utils.hash(pwd);
			Subject currentUser = SecurityUtils.getSubject();
			//获取当前用户的渠道标识，并判断该渠道商是否过期
//			int isExpiry = partnerServiceImpl.getIsExpiry(userName);
//			if(isExpiry==1){
//				jsonResultMessage.setJsonData("2", "用户已经过期，暂时不能登陆,请联系管理员!");
//				return jsonResultMessage;
//			}
			
			UsernamePasswordToken token = new UsernamePasswordToken(userName,pwd,hospitalNO);
			currentUser.login(token);
			if(UserSessionOperator.getCurrentUser().getIsDeleted() != 0){
				jsonResultMessage.setJsonData("2", "用户已经过期，暂时不能登陆,请联系管理员!");
				return jsonResultMessage;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("登陆check出错");
			jsonResultMessage.setJsonData("1", "登陆用户信息出错!");
			return jsonResultMessage;
		}
		jsonResultMessage.setJsonData("0", "ok");
		return jsonResultMessage;
	}

	@RequestMapping(value = "/exit")
	public String exit(HttpServletRequest request, HttpServletResponse response) {
		try {
			String proName = request.getContextPath();
			Subject currentUser = SecurityUtils.getSubject();
			currentUser.logout();
			response.sendRedirect(proName + "/hospital/login.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.debug("退出出错" + e.getMessage());
		}
		return null;
	}

}
