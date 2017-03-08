package com.qazit.register.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.dao.mapper.AppLinkmanMapper;
import com.qazit.register.model.AppLinkmanVO;
import com.qazit.register.model.AppUserVO;
import com.qazit.register.service.AppLinkmanService;

@Service("appLinkmanService")
public class AppLinkmanServiceImpl implements AppLinkmanService
{
	@Autowired
	private AppLinkmanMapper dao;
	
	//根据主键查询
	@Override
	public JsonModel selectByLid(AppUserVO uv,JsonModel json) 
	{
		try {
			List<AppLinkmanVO> user= dao.selectByLId(uv.getUserid());
			json.setJsonData("0", user);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("2", "信息修改异常");
		}
			
			return json;
		
	}
	//添加
		@Override
		public JsonModel createLink(AppLinkmanVO lm,JsonModel json) 
		{    
			if (lm==null) {
			json.setJsonData("1", "参数错误");
				}else{ 
				 AppLinkmanVO selectBycard = dao.selectBycard(lm.getUserid(),lm.getIdentifynumber());
				if(selectBycard!=null)
				{
					json.setJsonData("3","身份证已存在!");
					
				}
				else{
					try {
						dao.createLinkm(lm);
						AppLinkmanVO ak=dao.selectBycard(lm.getUserid(),lm.getIdentifynumber());
						json.setJsonData("0", ak);
						}
						catch (Exception e) 
						{
						e.printStackTrace();
						json.setJsonData("2", "添加异常");
						}
					}
				}
			return json;
		}
		
	
	//删除
	@Override
	public JsonModel deleteLink(Integer linkmanid, JsonModel json) {
		try {
			dao.deleteLinkm(linkmanid);
			json.setJsonData("0", "删除成功");
		} catch (Exception e) {
		e.printStackTrace();
		json.setJsonData("1", "删除异常");
		}
		return json;
	}
	
	//修改
	@Override
	public JsonModel updateLink(AppLinkmanVO lm, JsonModel json)
	{
		Integer id=0;
		boolean da=true;
		if (lm==null) {
			json.setJsonData("1", "参数错误");
			}else{
				List<AppLinkmanVO> ByLId = dao.selectByLId(lm.getUserid());
				for (AppLinkmanVO appLinkmanVO : ByLId) {
					if(appLinkmanVO.getIdentifynumber().equals(lm.getIdentifynumber())){
						da=false;
						id=appLinkmanVO.getLinkmanid();
					}
				}
				if(da==false){
					if(id.equals(lm.getLinkmanid())){
						try 
						{
						dao.updateLinkm(lm);
						AppLinkmanVO select = dao.selectLId(lm.getLinkmanid());
						json.setJsonData("0", select);
						} 
						catch (Exception e) 
						{
						e.printStackTrace();
						json.setJsonData("2", "修改异常");
						}
					}else{
						json.setJsonData("3","身份证已存在!");
					}
				}else{
						try 
						{
						dao.updateLinkm(lm);
						AppLinkmanVO select = dao.selectLId(lm.getLinkmanid());
						json.setJsonData("0", select);
						} 
						catch (Exception e) 
						{
						e.printStackTrace();
						json.setJsonData("2", "修改异常");
						}
					}
			}
		return json;
	}
	@Override
	public JsonModel selectLid(AppLinkmanVO lm, JsonModel json) {
		try {
			AppLinkmanVO link = dao.selectLId(lm.getLinkmanid());
			json.setJsonData("0", link);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("2", "信息修改异常");
		}
			
			return json;
	}

}
