package com.qazit.register.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.dao.mapper.AppLinkmanMapper;
import com.qazit.register.dao.mapper.AppPdGhMapper;
import com.qazit.register.model.AppLinkmanVO;
import com.qazit.register.model.AppPdGhVO;
import com.qazit.register.model.AppUserVO;
import com.qazit.register.service.AppPdGhService;
@Service("AppPdGhService")
public class AppPdGhServiceImpl implements AppPdGhService{
	@Autowired
	private AppPdGhMapper pgDAO;
	@Autowired
	private AppLinkmanMapper lkDAO;
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
	@Override
	public JsonModel queryAllByDate(AppPdGhVO ap, JsonModel json) {
		String status=json.getResultCode();
		try {
			List<AppPdGhVO> list =pgDAO.queryAllByDate(ap.getHospitalId(),ap.getDepartId(), ap.getConsDate());
		//List<BaseForm> base=new ArrayList<BaseForm>();
		for (AppPdGhVO ls : list) {
			float a=ls.getOrderCount();
			float b=ls.getOrderNumber();
			ls.setSurplus(b-a);
			String dd =format.format(ls.getConsDate());
			ls.setStrDate(dd);
			ls.setStatus(status);
		}
		json.setJsonData("0", list);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("2", "查询异常");
		}
		
		return json;
	}
	@Override
	public JsonModel selectById(AppUserVO uv,AppPdGhVO ap, JsonModel json) {
		Map<String,Object> map=new HashMap<String,Object>();
		if(uv==null){
			json.setJsonData("1", "参数错误");
		}else{
		try {
			ap=pgDAO.selectById(ap.getProductId());
			String dd =format.format(ap.getConsDate());
			ap.setStrDate(dd);
			List<AppLinkmanVO> list=lkDAO.selectByLId(uv.getUserid());
			//AppLinkmanVO mo=new AppLinkmanVO();
			//mo.setLinkmanname(uv.getRealname());
			//list.add(0, mo);
			map.put("Appuser", uv);
			map.put("lsit", list);
			map.put("AppPdGh", ap);
			json.setJsonData("0", map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.setJsonData("2", "数据异常");
		}
		}
		return json;
	}

	@Override
	public JsonModel queryWebPDByDate(AppPdGhVO ap, JsonModel json) {
		String status=json.getResultCode();
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			List<AppPdGhVO> amlist =pgDAO.queryWebPDByDate(ap.getHospitalId(),ap.getDepartId(), ap.getConsDate(),"1");
			List<AppPdGhVO> pmlist =pgDAO.queryWebPDByDate(ap.getHospitalId(),ap.getDepartId(), ap.getConsDate(),"2");
		//List<BaseForm> base=new ArrayList<BaseForm>();
//		for (AppPdGhVO ls : list) {
//			float a=ls.getOrderCount();
//			float b=ls.getOrderNumber();
//			ls.setSurplus(b-a);
//			String dd =format.format(ls.getConsDate());
//			ls.setStrDate(dd);
//			ls.setStatus(status);
//		}
			map.put("amlist", amlist);
			map.put("pmlist", pmlist);
		json.setJsonData("0", map);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("2", "查询异常");
		}
		
		return json;
	}
	@Override
	public JsonModel queryPDList(AppPdGhVO ap, JsonModel json) {
		String status=json.getResultCode();
		try {
			List<AppPdGhVO> list =pgDAO.queryPDList(ap.getHospitalId(),ap.getDepartId(), ap.getConsDate(), ap.getTimeSolt());
		//List<BaseForm> base=new ArrayList<BaseForm>();
		for (AppPdGhVO ls : list) {
			float a=ls.getOrderCount();
			float b=ls.getOrderNumber();
			ls.setSurplus(b-a);
			String dd =format.format(ls.getConsDate());
			ls.setStrDate(dd);
			ls.setStatus(status);
		}
		json.setJsonData("0", list);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("2", "查询异常");
		}
		
		return json;
	}
	
}
