package com.qazit.register.service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppUserVO;


public interface AppUserVOService {
	public JsonModel getUser(AppUserVO uv,JsonModel json);
	public JsonModel createUser(AppUserVO uv,JsonModel json);
	public JsonModel updateUser(AppUserVO uv,JsonModel json);
	public JsonModel selectUserById(AppUserVO uv,JsonModel json);
	public JsonModel selectUserByPhone(AppUserVO uv,JsonModel json);
}
