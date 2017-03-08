package com.qazit.register.service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppUserVO;

public interface AppSecurityService 
{
//	//根据用户信息修改邮箱
//	public JsonModel updateByMail(AppUserVO user,JsonModel json);
//	
//	//根据用户信息修改手机
//	public JsonModel updateByCellphone(AppUserVO user,JsonModel json);
	
	public JsonModel updatebyUser(AppUserVO user,JsonModel json);

	
}
