package com.qazit.register.dao.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qazit.register.model.AppDepartmentTypeVO;
import com.qazit.register.model.AppDepartmentVO;

public interface AppDepartmentMapper 
{	
	
		
	//遍历出所有的科室
	public List<AppDepartmentVO> selectAlldepartment(@Param("hospitalSn")String hospitalSn,@Param("departmentTypeSn")String departmentTypeSn);
	
	//根据特色科室遍历科室
	public List<AppDepartmentVO> selectdepartment(@Param("hospitalSn")String hospitalSn);
	
	//通过科室编码医院编码查询科室
	public AppDepartmentVO selectDepart(@Param("hospitalSn")String hospitalSn,@Param("departmentSn")String departmentSn);
	
	//根据科室id和医院编码查询科室介绍
	public AppDepartmentVO selectDepartmentx(@Param("departmentId")Integer departmentId,@Param("hospitalSn")String hospitalSn);
	
	//遍历出所有的科室 web使用
	public List<AppDepartmentVO> queryAlldepartment(@Param("hospitalSn")String hospitalSn,@Param("departmentTypeSn")String departmentTypeSn);
}
