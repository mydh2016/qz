package com.qazit.register.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.dao.mapper.AppMedpediaMapper;
import com.qazit.register.model.AppMedpediaVO;
import com.qazit.register.service.AppMedpediaService;

@Service("appMedpediaService")
public class AppMedpediaServiceImpl implements AppMedpediaService{

	@Autowired
	private AppMedpediaMapper dao;
	
	@Override
	public List<AppMedpediaVO> getMedpediaList(int startNum,int pageNum,String publish_module_sn) {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		List<AppMedpediaVO> list= dao.getMedpediaList(startNum, pageNum,publish_module_sn);
		for (AppMedpediaVO md : list) {
			if(md.getPublish_date()!=null){
			String da=ft.format(md.getPublish_date());
			md.setPublishDate(da);
			}
		}
		return list;
	}

	@Override
	public AppMedpediaVO getMedpediaById(AppMedpediaVO appMedpediaVO,JsonModel json) {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		appMedpediaVO=dao.getMedpediaById(appMedpediaVO.getPublish_content_id());
		if(appMedpediaVO.getPublish_date()!=null){
		String da=ft.format(appMedpediaVO.getPublish_date());
		appMedpediaVO.setPublishDate(da);
		}
		json.setJsonData("0", appMedpediaVO);
		return appMedpediaVO;
	}


	
}
