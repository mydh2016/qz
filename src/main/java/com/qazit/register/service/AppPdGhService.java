package com.qazit.register.service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.model.AppPdGhVO;
import com.qazit.register.model.AppUserVO;

public interface AppPdGhService {
	public JsonModel queryAllByDate(AppPdGhVO ap,JsonModel json);
	public JsonModel selectById(AppUserVO uv,AppPdGhVO ap,JsonModel json);
	public JsonModel queryWebPDByDate(AppPdGhVO ap, JsonModel json);
	public JsonModel queryPDList(AppPdGhVO ap, JsonModel json);
}
