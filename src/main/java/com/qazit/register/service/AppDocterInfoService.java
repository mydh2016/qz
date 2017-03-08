package com.qazit.register.service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppDocterVO;


public interface AppDocterInfoService {
	//查询所有的医生信息
	public JsonModel queryAllDocter(JsonModel json,AppDocterVO dv);
	public JsonModel selectById(JsonModel json,AppDocterVO dv,Integer id);
}
