package com.qazit.sysmanager.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.sysmanager.web.model.JsonResultMessage;
import com.qazit.sysmanager.web.model.Partner;
import com.qazit.sysmanager.web.model.TMemDicnPara;
import com.qazit.sysmanager.web.model.User;
import com.qazit.sysmanager.web.security.UserSessionOperator;
import com.qazit.sysmanager.web.service.IPartnerService;
import com.qazit.sysmanager.web.service.IUserService;

@Controller
@RequestMapping("/partner")
public class PartnerAction {

	private static final Logger logger = Logger.getLogger(PartnerAction.class);

	private static String NOT_SUPPER_USER = "不是管理员!";
	private static String NOT_DEL_SELF = "不能删除自己！";

	@Resource
	private IUserService userServiceImpl;

	@Resource
	private IPartnerService partnerServiceImpl;
	
	/**
	 * 根据条件查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getPartners")
	@ResponseBody
	public JsonResultMessage getPartners(Partner partner) {
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		try{
			jsonResultMessage.setJsonData("0", this.partnerServiceImpl.getPartners(partner));
		}catch(Exception e){
			jsonResultMessage.setJsonData("1", "系统出错，请重试");
			logger.error("查询医院出错！");
			e.printStackTrace();
		}
		return jsonResultMessage;
	}
	
	/**
	 * 新增或者修改医院信息
	 * @return
	 */
	@RequestMapping(value = "/saveOrUpdatePartner")
	@ResponseBody
	public JsonResultMessage saveOrUpdatePartner(Partner partner,User user) {
		JsonResultMessage jresult = new JsonResultMessage();
		try{
			//进行信息校验
			jresult=partnerServiceImpl.saveOrUpdatePartner(partner, user);
		}catch(Exception e){
			e.printStackTrace();
			jresult.setJsonData("1", "内部异常，请重试");
		}
		return jresult;
	}
	
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deletePartner")
	@ResponseBody
	public JsonResultMessage deletePartner(Long partnerId) throws Exception {
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		try{
			jsonResultMessage = partnerServiceImpl.deletePartner(partnerId);
			jsonResultMessage.setJsonData("0", "ok");
		}catch(Exception e){
			e.printStackTrace();
			jsonResultMessage.setJsonData("1", "删除数据出错，请重试");
		}
		
		return jsonResultMessage;
	}


	/**
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getPartnerById")
	@ResponseBody
	public Partner getUserById(long partnerId){
		return partnerServiceImpl.getPartnerIdById(partnerId);
	}
	
	
	/**
	 * 获取userid对应的用户
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getSessionUser")
	@ResponseBody
	public User getSessionUser(){
		long curentUserId = UserSessionOperator.getCurrentUserId();
		return userServiceImpl.getUserById(curentUserId);
	}
	
	
	/**
	 * 获取省市信息
	 * @return
	 */
	@RequestMapping(value = "/provincialInfo")
	@ResponseBody
	public JsonResultMessage provincialInfo() {
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		List<Map<String, Object>> res = partnerServiceImpl.provincialInfo();
		jsonResultMessage.setJsonData("0", res);
		return jsonResultMessage;
	}
	/**
	 * 获取省市信息
	 * @return
	 */
	@RequestMapping(value = "/getHospLevel")
	@ResponseBody
	public JsonResultMessage getHospLevel() {
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		 List<TMemDicnPara> res = partnerServiceImpl.getHospLevel();
		jsonResultMessage.setJsonData("0", res);
		return jsonResultMessage;
	}
}
