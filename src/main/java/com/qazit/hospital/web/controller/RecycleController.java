package com.qazit.hospital.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.RecycleBox;
import com.qazit.hospital.web.service.RecycleBoxService;

@Controller
@RequestMapping("recycle")
public class RecycleController {
	@Autowired
	private RecycleBoxService recycleBoxService;
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
	public JsonModel selectForList(RecycleBox box,String sTime,String eTime,AbstractPage page){
		JsonModel json=new JsonModel();
		return this.recycleBoxService.selectForList(box, sTime, eTime, json, page);
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
	public JsonModel update(String ids){
		JsonModel json=new JsonModel();
		return this.recycleBoxService.update(ids, json);
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
		return this.recycleBoxService.delete(ids, json);
	};
}
