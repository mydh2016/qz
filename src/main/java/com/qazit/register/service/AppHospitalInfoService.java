package com.qazit.register.service;


import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppHospitalVO;

public interface AppHospitalInfoService {
	public JsonModel queryAllHospital(JsonModel json,AppHospitalVO av);
	public JsonModel selectById(JsonModel json,AppHospitalVO av);
	public JsonModel selectByhospital(JsonModel json,AppHospitalVO av);
}
