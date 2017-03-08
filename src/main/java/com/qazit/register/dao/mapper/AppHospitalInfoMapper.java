package com.qazit.register.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qazit.register.model.AppHospitalVO;

public interface AppHospitalInfoMapper {
	//遍历所有的医院信息
	public List<AppHospitalVO> queryAllHospital();
	//查询医院详情介绍
	public AppHospitalVO selectById(Integer hospitalId);
	//查询某个医院的信息
	public AppHospitalVO selectbyHospital(@Param("hcode")String hcode);
}
