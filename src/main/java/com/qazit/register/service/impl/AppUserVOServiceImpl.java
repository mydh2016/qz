package com.qazit.register.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.dao.mapper.AppUserVOMapper;
import com.qazit.register.model.AppUserVO;
import com.qazit.register.service.AppUserVOService;


@Service("AppUserVOService")
public class AppUserVOServiceImpl implements AppUserVOService {
	@Autowired
	private AppUserVOMapper appUserDAO;
	@Override
	public JsonModel getUser(AppUserVO uv,JsonModel json) {
		if(uv==null){
			json.setJsonData("1", "参数错误");
		}else{
			try {
				AppUserVO user=new AppUserVO();
				user=appUserDAO.getUser(uv.getUsername(), uv.getUserpassword());
				if(user!=null){
					if(user.getUserstate().equals("1")){
					json.setJsonData("0", user);
					}else{
						json.setJsonData("4", "账户被冻结");
					}
				}else{
					json.setJsonData("3", "用户名或密码不正确");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("2", "登陆异常");
			}
			
			
			
		}
		return json;
	}
	//注册新用户
	@Override
	public JsonModel createUser(AppUserVO uv,JsonModel json) {
		if(uv==null){
			json.setJsonData("1", "参数错误");
		}else{
			AppUserVO u=appUserDAO.selectByUserPhone(uv.getUsername());
			if(u!=null){
				json.setJsonData("3", "手机号已经存在");
			}else{
			try {
				AppUserVO user=new AppUserVO();
				uv.setUserstate("1");
				uv.setEffecttime(new Date());
				appUserDAO.createUser(uv);
				user=appUserDAO.selectByUserPhone(uv.getUsername());
				json.setJsonData("0", user);
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("2", "注册异常");
			}
			
			}
			
		}
		return json;

	}
	//用户个人信息修改
	@Override
	public JsonModel updateUser(AppUserVO uv, JsonModel json) {
		if(uv==null){
			json.setJsonData("1", "参数错误");
		}else{
			//AppUserVO u=appUserDAO.selectByUserIdCard(uv.getIdentifynumber());
			/*if(u!=null){
				json.setJsonData("3", "手机号已经存在");
			}else{*/
			try {
				AppUserVO user=new AppUserVO();
				appUserDAO.updateUser(uv);
				user=appUserDAO.selectByUserId(uv.getUserid());
				json.setJsonData("0", user);
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("2", "信息修改异常");
			}
			/*}*/
		}
		return json;

	}
	//按主键查询用户信息
	@Override
	public JsonModel selectUserById(AppUserVO uv, JsonModel json) {
		if(uv==null){
			json.setJsonData("1", "参数错误");
		}else{
			try {
				
				AppUserVO user=appUserDAO.selectByUserId(uv.getUserid());
				json.setJsonData("0", user);
				
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("2", "查询");
			}
			
			
			
		}
		return json;

	}
	@Override
	public JsonModel selectUserByPhone(AppUserVO user, JsonModel json) {
		// TODO Auto-generated method stub
		return null;
	}

}
