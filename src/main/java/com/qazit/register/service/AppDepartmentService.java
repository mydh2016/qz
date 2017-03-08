package com.qazit.register.service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppDepartmentTypeVO;
import com.qazit.register.model.AppDepartmentVO;
import com.qazit.register.model.AppHospitalVO;
//科室
public interface AppDepartmentService 
{
	public JsonModel selectAllDepartmentType(AppHospitalVO av,AppDepartmentTypeVO ad,JsonModel json);

	public JsonModel selectAllDepartment(AppHospitalVO av,AppDepartmentTypeVO ad,JsonModel json);
	
	public JsonModel selectTeDepartment(AppHospitalVO av,AppDepartmentTypeVO ad,JsonModel json);
	
	//查询科室详细介绍
	public JsonModel selectdepartmentX(AppDepartmentVO ad,JsonModel json);

	//web
	public JsonModel selectDepartmentForWeb(AppHospitalVO av, AppDepartmentTypeVO ad,
			JsonModel json);
}
