package com.qazit.register.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qazit.register.model.AppMedpediaVO;

public interface AppMedpediaMapper {

	//public List<AppMedpediaVO> getMedpediaList(AppMedpediaVO appMedpediaVO);
	public List<AppMedpediaVO> getMedpediaList(@Param("startNum")Integer startNum,@Param("pageNum")Integer pageNum,@Param("publish_module_sn")String publish_module_sn);
	
	public AppMedpediaVO getMedpediaById(@Param("publish_content_id")Integer publish_content_id);
	
}
