package com.qazit.register.service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppGhOrderVO;

public interface AppGhOrderService {
	public JsonModel createGhOrder(AppGhOrderVO gd,JsonModel json);
	public JsonModel queryAllOrderBuUserId(AppGhOrderVO gd,JsonModel json);
	public JsonModel queryById(AppGhOrderVO gd,JsonModel json);
}
