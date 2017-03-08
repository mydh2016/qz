package com.qazit.register.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppLinkmanVO;
import com.qazit.register.model.AppUserVO;

public interface AppLinkmanService 
{
	//查询
	public JsonModel selectByLid(AppUserVO uv,JsonModel json);
	//添加
	public JsonModel createLink(AppLinkmanVO lm, JsonModel json);
	//删除
	public JsonModel deleteLink(Integer linkmanid,JsonModel json);
	//修改
	public JsonModel updateLink(AppLinkmanVO lm,JsonModel json);
	
	public JsonModel selectLid(AppLinkmanVO lm,JsonModel json);
}
