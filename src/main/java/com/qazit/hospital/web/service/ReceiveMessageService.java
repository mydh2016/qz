package com.qazit.hospital.web.service;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.Model;
import com.qazit.hospital.web.model.ReciveMessage;

public interface ReceiveMessageService {
	/**
	 * 查询收件列表
	 */
	public JsonModel selectReceiveList(ReciveMessage receive,String look,String startTime,String endTime,AbstractPage page,JsonModel json);
	/**
	 * 修改收件
	 * @param receive
	 * @param anserTime
	 * @param json
	 * @return
	 */
	public JsonModel update(ReciveMessage receive,String anserTime,String ids,JsonModel json);
	/**
	 * 插入收件箱
	 * @param receive
	 * @param anserTime
	 * @param json
	 * @return
	 */
	public JsonModel insert(ReciveMessage receive,String anserTime,JsonModel json);
	/**
	 * 删除收件箱多条数据
	 * @param ids
	 * @param json
	 * @return
	 */
	public JsonModel delete(String ids,JsonModel json);
	/**
	 * 收件箱回复
	 * @param id
	 * @param model
	 * @param json
	 * @return
	 */
	public JsonModel insertSend(String ids,Model model,JsonModel json);
}
