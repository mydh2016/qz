package com.qazit.hospital.web.service;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.RecycleBox;

public interface RecycleBoxService {
	public JsonModel delete(String ids,JsonModel json);
	public JsonModel update(String resIds,JsonModel json);
	public JsonModel selectForList(RecycleBox box,String sendTime,String eTime,JsonModel json,AbstractPage page);
}
