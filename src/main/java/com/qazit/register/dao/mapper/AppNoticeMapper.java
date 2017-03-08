package com.qazit.register.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qazit.register.model.AppNoticeVO;

public interface AppNoticeMapper 
{
	//遍历所有的医院公告
	public List<AppNoticeVO> queryAllpublicNotice(@Param("startNum")Integer startNum,@Param("pageNum")Integer pageNum);
	
	//查询某个医院公告
	public AppNoticeVO selectByNotice(@Param("publicNoticeId")Integer publicNoticeId);
	
}
