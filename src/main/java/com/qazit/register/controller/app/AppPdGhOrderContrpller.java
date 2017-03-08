package com.qazit.register.controller.app;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppGhOrderVO;
import com.qazit.register.model.AppPdGhVO;
import com.qazit.register.model.AppUserVO;
import com.qazit.register.service.AppGhOrderService;

@Controller
@RequestMapping("app/pdGhOrder")
public class AppPdGhOrderContrpller {
	@Autowired
	private AppGhOrderService gdService;
	@RequestMapping("/query")
	public String  queryAllByDate(JsonModel json,AppGhOrderVO gd,AppPdGhVO ap,HttpSession session ,HttpServletRequest request){
		
		AppUserVO user=(AppUserVO)session.getAttribute("appUser");
		if(user==null){
			return "/view/register/login.jsp";
		}else{
			gd.setUserId(user.getUserid());
			json=gdService.queryAllOrderBuUserId(gd, json);
			if(json.getResultCode().equals("0")){
				
				List<AppGhOrderVO> list=(List<AppGhOrderVO>)json.getData();
				request.setAttribute("ghOrder", list);
				return "/view/register/recordQuery.jsp";
			}else{
				return "/view/register/index.jsp";
			}
		}
		
	}
	@RequestMapping("/queryById")
	public @ResponseBody JsonModel  queryAllById(JsonModel json,AppGhOrderVO gd,HttpServletRequest request,Integer id){
			gd.setOrderId(id);
			json=gdService.queryById(gd, json);
			if(json.getResultCode().equals("0")){
				
				AppGhOrderVO ao=(AppGhOrderVO)json.getData();
				request.setAttribute("order", ao);
		}
			return json;
	}
	
	
}
