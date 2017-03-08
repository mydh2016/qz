package com.qazit.register.service;

import java.util.List;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppMedpediaVO;

public interface AppMedpediaService {

	public List<AppMedpediaVO> getMedpediaList(int startNum,int pageNum,String publish_module_sn);
	
	public AppMedpediaVO getMedpediaById(AppMedpediaVO appMedpediaVO,JsonModel json);
	
}
