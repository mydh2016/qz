package com.qazit.register.service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppNoticeVO;

public interface AppNoticeService 
{
	public JsonModel queryAllPublicNotice(int startNum,int pageNum,JsonModel json);
	
	public JsonModel AllPublicNotice(int startNum, int pageNum, JsonModel json);
	
	public JsonModel selectByNotice(AppNoticeVO nv,JsonModel json);

}
