package com.qazit.register.service.impl;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.dao.mapper.AppNoticeMapper;
import com.qazit.register.model.AppNoticeVO;
import com.qazit.register.service.AppNoticeService;

@Service("AppNoticeService")
public class AppNoticeServiceImpl implements AppNoticeService
{
	@Autowired
	private AppNoticeMapper nvDao;
	
	@Override
	public JsonModel queryAllPublicNotice(int startNum, int pageNum,JsonModel json) 
	{
		try {
				List<AppNoticeVO> publicNotice = nvDao.queryAllpublicNotice(startNum, pageNum);
				for (AppNoticeVO appNoticeVO : publicNotice) {
					
				SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				 String format = time.format(appNoticeVO.getPublishedTime());
				 appNoticeVO.setPublishedTime1(format);
				json.setJsonData("0",publicNotice);
					}
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("2", "查询异常");
		}
		return json;
	}
	
	@Override
	public JsonModel AllPublicNotice(int startNum, int pageNum,JsonModel json) 
	{
		try {
				int chaNum=startNum-pageNum;
				startNum=pageNum+chaNum;
				
				List<AppNoticeVO> publicNotice = nvDao.queryAllpublicNotice(startNum, pageNum);
				for (AppNoticeVO appNoticeVO : publicNotice) {
					
				SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				 String format = time.format(appNoticeVO.getPublishedTime());
				 appNoticeVO.setPublishedTime1(format);
				json.setJsonData("0",publicNotice);
					}
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("2", "查询异常");
		}
		return json;
	}
	@Override
	public JsonModel selectByNotice(AppNoticeVO nv, JsonModel json)
	{
		try {
			AppNoticeVO publicNotice = nvDao.selectByNotice(nv.getPublicNoticeId());
			SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			 String format = time.format(publicNotice.getPublishedTime());
			 publicNotice.setPublishedTime1(format);
			json.setJsonData("0",publicNotice);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("2", "查询异常");
		}
		return json;
	}
	
}
