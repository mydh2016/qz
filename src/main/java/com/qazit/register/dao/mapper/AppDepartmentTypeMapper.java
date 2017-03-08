package com.qazit.register.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qazit.register.model.AppDepartmentTypeVO;

public interface AppDepartmentTypeMapper 
{
	//遍历出所有的科室类型
	public List<AppDepartmentTypeVO> selectAlldepartmentType(@Param("hospitalSn")String hospitalSn);
}
