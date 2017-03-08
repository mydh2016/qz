package com.qazit.register.dao.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qazit.register.model.AppLinkmanVO;
import com.qazit.register.model.AppUserVO;


public interface AppLinkmanMapper 
{
	//查询家属信息
	public List<AppLinkmanVO> selectByLId(@Param("userid")Integer userid);
	
	//添加
	public void createLinkm(AppLinkmanVO lm);
	
	//删除
	public void deleteLinkm(@Param("linkmanid")Integer linkmanid);
	
	//修改
	public void updateLinkm(AppLinkmanVO lm);

	public AppLinkmanVO selectLId(@Param("linkmanid")Integer linkmanid);
	//查询校验
	public AppLinkmanVO selectBycard(@Param("userid")Integer userid,@Param("identifynumber")String identifynumber);
	//校验身份证
	public Integer Bycard(@Param("userid")Integer userid,@Param("identifynumber")String identifynumber);
	
	
}
