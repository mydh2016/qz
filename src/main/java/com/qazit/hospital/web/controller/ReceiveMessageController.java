package com.qazit.hospital.web.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.Model;
import com.qazit.hospital.web.model.ReciveMessage;
import com.qazit.hospital.web.service.ModelService;
import com.qazit.hospital.web.service.ReceiveMessageService;

@Controller
@RequestMapping("receive")
public class ReceiveMessageController {
	@Autowired
	private ReceiveMessageService receiveService;
	@Autowired
	private ModelService modelService;
	/**
	 * 查询发件列表
	 * @param receive
	 * @param startTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	@RequestMapping("selectForList")
	@ResponseBody
	public JsonModel selectForList(ReciveMessage receive,String look,String startTime,String endTime,AbstractPage page){
		JsonModel json=new JsonModel();
		return this.receiveService.selectReceiveList(receive,look,startTime, endTime, page, json);
	};
	/**
	 * 修改收件
	 * @param receive
	 * @param anserTime
	 * @param json
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public JsonModel update(ReciveMessage receive,String anserTime,String ids){
		JsonModel json=new JsonModel();
		return this.receiveService.update(receive, anserTime,ids,json);
	};
	/**
	 * 删除收件箱多条数据
	 * @param ids
	 * @param json
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public JsonModel delete(String ids){
		JsonModel json=new JsonModel();
		return this.receiveService.delete(ids, json);
	};
	/**
	 * 收件箱回复
	 * @param id
	 * @param model
	 * @param json
	 * @return
	 */
	@RequestMapping("insertSend")
	@ResponseBody
	public JsonModel insertSend(String ids,Integer modelId,JsonModel json){
		Model model=new Model();
		model.setId(modelId);
		JSONObject jsonobj=JSONObject.fromObject(modelService.selectByPrimaryKey(modelId, json).getData());
		model.setModelContent(jsonobj.getString("modelContent"));
		return this.receiveService.insertSend(ids, model, json);
	}
}
