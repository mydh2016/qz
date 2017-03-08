package com.qazit.hospital.web.service;

import java.text.ParseException;

import net.sf.json.JSONObject;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.Model;
import com.qazit.hospital.web.model.Rule;
import com.qazit.hospital.web.model.TSendMessage;

public interface SendMessageService {
	/**
	 * 根据主键删除
	 * @param id
	 * @return
	 */
	public JsonModel deleteByPrimaryKey(String ids,JsonModel json);
	/**
	 * 保存免打扰
	 * @param sendMessage
	 * @return
	 */
	public JsonModel insertSelective(TSendMessage sendMessage,JsonModel json);
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	public JsonModel selectByPrimaryKey(Integer id,JsonModel json);
	/**
	 * 查询
	 * @param example
	 * @return
	 */
	public JsonModel selectByExample(TSendMessage record,String look,String startTime,String endTime,AbstractPage page,JsonModel json);
	/**
	 * 根据主键修改
	 * @param record
	 * @return
	 */
	public JsonModel updateByPrimaryKeySelective(TSendMessage record,JsonModel json);
	/**
	 * 发送短信
	 * @param model
	 * @param rule
	 * @param json
	 * @return
	 * @throws ParseException 
	 */
	public JsonModel send(Model model,Rule rule,JSONObject jsonObj,TSendMessage record,JsonModel json);
}
