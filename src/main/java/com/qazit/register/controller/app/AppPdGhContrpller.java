package com.qazit.register.controller.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppGhOrderVO;
import com.qazit.register.model.AppLinkmanVO;
import com.qazit.register.model.AppPdGhVO;
import com.qazit.register.model.AppUserVO;
import com.qazit.register.service.AppGhOrderService;
import com.qazit.register.service.AppLinkmanService;
import com.qazit.register.service.AppPdGhService;
import com.qazit.register.service.AppUserVOService;

@Controller
@RequestMapping("app/pdGh")
public class AppPdGhContrpller {
	@Autowired
	private AppPdGhService pgService;
	@Autowired
	private AppLinkmanService linkmanService;
	@Autowired
	private AppUserVOService userService;
	@Autowired
	private AppGhOrderService gdService;
	@RequestMapping("/query")
	public @ResponseBody JsonModel queryAllByDate(JsonModel json,AppPdGhVO ap,HttpSession session,String data,Integer departmentId,Integer hospitalId ) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Date ddd;
		if(data==null){
			Date d =new Date();
			
			String dd =format.format(d);
			ddd = format.parse(dd);
		}else{
			ddd = format.parse(data);
		}
		ap.setConsDate(ddd);
		ap.setDepartId(departmentId);
		ap.setHospitalId(hospitalId);
		String str=(String)session.getAttribute("status");
		json.setResultCode(str);
		json=pgService.queryAllByDate(ap, json);
		return json;
	}
	@RequestMapping("/yuyue")
	public @ResponseBody JsonModel queryById(Integer productId,JsonModel json,AppUserVO uv,AppPdGhVO ap,HttpSession session){
		uv=(AppUserVO)session.getAttribute("appUser");
		if(uv==null){
			json.setJsonData("1", "请先登陆");
		}else{
		//查询
		ap.setProductId(productId);
		pgService.selectById(uv, ap, json);
		}
		return json;
	}
	@RequestMapping("/add")
	public @ResponseBody JsonModel test(AppLinkmanVO lo,JsonModel json,String IDcard,String phone,String userName,HttpSession session){
		lo.setLinkmanname(userName);
		lo.setIdentifynumber(IDcard);
		lo.setCellphonenumber(phone);
		AppUserVO av=(AppUserVO)session.getAttribute("appUser");
		lo.setUserid(av.getUserid());
		lo=(AppLinkmanVO)linkmanService.createLink(lo, json).getData();
		json.setJsonData("0", lo);
		return json;
	}
	@RequestMapping("/selectById")
	public @ResponseBody JsonModel selectById(String status,Integer id,HttpSession session,AppLinkmanVO lo,JsonModel json){
		if(status.equals("0")){
			AppUserVO uv=(AppUserVO)session.getAttribute("appUser");
			json.setJsonData("0", uv);
		}
		else{
			lo.setLinkmanid(id);
			json=linkmanService.selectLid(lo, json);
			if(json.getResultCode().equals("0")){
				lo=(AppLinkmanVO)json.getData();
				json.setJsonData("1", lo);
			}
			}
		return json;
	}
	@RequestMapping("/queding")
	public @ResponseBody JsonModel queding(HttpSession session,JsonModel json,String IDcard,String userName,Integer productId,AppGhOrderVO gd){
		AppUserVO av=(AppUserVO)session.getAttribute("appUser");
		if(av==null){
			json.setJsonData("1", "用户状态异常");
		}else{
			
			gd.setUserId(av.getUserid());
			gd.setIdentityNumber(IDcard);
			gd.setProductId(productId);
			gd.setRealName(userName);
			gd.setOrderDate(new Date());
			json=gdService.createGhOrder(gd, json);
		}
		return json;
	} 
}
