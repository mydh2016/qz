package com.qazit.register.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qazit.register.model.AppDocterVO;

public interface AppDocterInfoMapper {
	//查询所有的医生信息
	public List<AppDocterVO> queryAllDocter(@Param("hospitalSn")String hospitalSn);
	public AppDocterVO selectById(@Param("id")Integer id);
}
