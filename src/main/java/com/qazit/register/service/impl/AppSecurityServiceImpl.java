package com.qazit.register.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.dao.mapper.AppUserVOMapper;
import com.qazit.register.model.AppUserVO;
import com.qazit.register.service.AppSecurityService;

/*
 * 	账户安全页面
 * 
 * */
@Service("appSecurityService")
public class AppSecurityServiceImpl implements AppSecurityService
{
	@Autowired
	private AppUserVOMapper dao;

	@Override
	public JsonModel updatebyUser(AppUserVO user, JsonModel json) 
	{
		if (user==null) {
			json.setJsonData("2", "参数异常");
		}else{
			try 
			{
				dao.updateByUser(user);
				user=dao.selectByUserId(user.getUserid());
				json.setJsonData("0", user);
				
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("2", "信息修改异常");
			}
		}
		
		return json;
	}
	
//	//根据用户信息修改邮箱
//	@Override
//	public JsonModel updateByMail(AppUserVO user,JsonModel json) {
//		if(user==null)
//		{
//			json.setJsonData("1", "参数异常");
//		}else{
//			try {
//				dao.updateByMail(user.getUserid(),user.getEmail());
//				 user=dao.selectByUserId(user.getUserid());
//				json.setJsonData("0", user);
//			} catch (Exception e) {
//				e.printStackTrace();
//				json.setJsonData("2", "信息修改异常");
//			}
//		}
//		return json;
//
//	}
//	//根据用户信息修改手机号
//	@Override
//	public JsonModel updateByCellphone(AppUserVO user, JsonModel json) {
//		if(user==null){
//			json.setJsonData("1", "参数错误");
//		}else{
//			AppUserVO u=dao.selectByUserPhone(user.getCellphonenumber());
//			if(u!=null){
//				json.setJsonData("3", "手机号已经存在");
//			}else{
//			try {
//				dao.updateByCellphone(user.getUserid(),user.getCellphonenumber());
//				user=dao.selectByUserId(user.getUserid());
//				json.setJsonData("0", user);
//			} catch (Exception e) {
//				e.printStackTrace();
//				json.setJsonData("2", "信息修改异常");
//			}
//			}
//		}
//		return json;
//
//	}
}
