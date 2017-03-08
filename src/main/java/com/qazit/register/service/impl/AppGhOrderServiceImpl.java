package com.qazit.register.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.dao.mapper.AppGhOrderMapper;
import com.qazit.register.dao.mapper.AppPdGhMapper;
import com.qazit.register.model.AppGhOrderVO;
import com.qazit.register.model.AppPdGhVO;
import com.qazit.register.service.AppGhOrderService;
@Service("AppGhOrderService")
public class AppGhOrderServiceImpl implements AppGhOrderService {
	@Autowired
	private AppGhOrderMapper gdDAO;
	@Autowired
	private AppPdGhMapper psDAO;
	@Override
	public JsonModel createGhOrder(AppGhOrderVO gd,JsonModel json) {
		if(gd==null){
			json.setJsonData("1", "参数异常");
		}else{
		try {
			AppGhOrderVO sud=gdDAO.queryByCardAndPId(gd.getProductId(), gd.getIdentityNumber());
			if(sud!=null){
				json.setJsonData("3", "您好!您已经预过此医生");
			}else{
				AppPdGhVO ao=psDAO.selectById(gd.getProductId());
				if(ao!=null){
					int a=ao.getOrderNumber();
					int o=ao.getOrderCount();
					int b=o+1;
					int c =a-b;
					if(c<0){
						json.setJsonData("4", "此医生已经约满，请选择其他医生");
					}else{
						ao.setOrderCount(b);
						psDAO.updateCount(ao);
						gdDAO.createGhOrder(gd);
						json.setJsonData("0", "预约成功");
					}
				}else{
					json.setJsonData("1", "参数异常");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.setJsonData("2", "预约异常");
		}
		}
		return json;
	}
	@Override
	public JsonModel queryAllOrderBuUserId(AppGhOrderVO gd, JsonModel json) {
		if(gd==null){
			json.setJsonData("1", "参数异常");
		}
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			List<AppGhOrderVO> list=gdDAO.queryAllOrderByUserId(gd.getUserId());
			if(list!=null){
			for (AppGhOrderVO ag : list) {
				AppPdGhVO ap=psDAO.selectById(ag.getProductId());
				if(ap != null){
				ag.setDepartName(ap.getDepartName());
				ag.setDoctorName(ap.getUserName());
				ag.setSurplus(ap.getPlantPrice());
				ag.setTime(ft.format(ap.getConsDate()));
				if(ap.getTimeSolt().equals("1")){
					ag.setTimeSolt("上午");
				}else{
					ag.setTimeSolt("下午");
				}
					ag.setHospitalName(ap.getHospitalName());
				}else{
					System.out.println("该条记录中的产品未找到，请管理员查看数据");
				}
			}
		}
			json.setJsonData("0", list);
		} catch (Exception e) {
			json.setJsonData("2", "查询异常");
			e.printStackTrace();
		}
		return json;
	}
	@Override
	public JsonModel queryById(AppGhOrderVO ag, JsonModel json) {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		ag=gdDAO.queryById(ag.getOrderId());
		AppPdGhVO ap=psDAO.selectById(ag.getProductId());
		ag.setDepartName(ap.getDepartName());
		ag.setDoctorName(ap.getUserName());
		ag.setSurplus(ap.getPlantPrice());
		ag.setTime(ft.format(ap.getConsDate()));
		if(ap.getTimeSolt().equals("1")){
			ag.setTimeSolt("上午");
		}else{
			ag.setTimeSolt("下午");
		}
		ag.setHospitalName(ap.getHospitalName());
		json.setJsonData("0", ag);
		return json;
	}

}
