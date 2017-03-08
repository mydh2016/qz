package com.qazit.hospital.web.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.dao.mapper.ReciveMessageMapper;
import com.qazit.hospital.web.dao.mapper.RecycleBoxMapper;
import com.qazit.hospital.web.dao.mapper.TSendMessageMapper;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.Model;
import com.qazit.hospital.web.model.ReciveMessage;
import com.qazit.hospital.web.model.ReciveMessageExample;
import com.qazit.hospital.web.model.RecycleBox;
import com.qazit.hospital.web.model.ReciveMessageExample.Criteria;
import com.qazit.hospital.web.model.TSendMessage;
import com.qazit.hospital.web.service.ReceiveMessageService;
import com.qazit.sysmanager.web.security.UserSessionOperator;
@Service("receiveMessageService")
public class ReceiveMessageServiceImpl implements ReceiveMessageService{
	@Autowired
	private ReciveMessageMapper dao;
	@Autowired
	private TSendMessageMapper  sendDAO;
	@Autowired
	private RecycleBoxMapper boxDAO;
	/**
	 * 查询收件列表
	 */
	public JsonModel selectReceiveList(ReciveMessage receive,String look,String startTime,String endTime,AbstractPage page,JsonModel json){
		ReciveMessageExample example=new ReciveMessageExample();
		Criteria cri=example.createCriteria();
		try {
			if(receive==null){
				cri.andSendIdEqualTo((int)UserSessionOperator.getCurrentUserId());
				if(page!=null){
					example.setOrderByClause("id desc limit "+page.getFirstRecord()+","+page.getPageSize());
				}
			}else{
				String anserName=receive.getAnserName();
				if(StringUtils.isBlank(anserName)){
					receive.setAnserName(null);
				}else{
					cri.andAnserNameLike("%"+anserName+"%");
				}
				String sendName=receive.getSendName();
				if(StringUtils.isBlank(sendName)){
					receive.setSendName(null);
				}else{
					cri.andSendNameLike("%"+sendName+"%");
				}
				String telphone=receive.getAnserTelphone();
				if(StringUtils.isBlank(telphone)){
					receive.setAnserTelphone(null);
				}else{
					cri.andAnserTelphoneLike("%"+telphone+"%");
				}
				if(!StringUtils.isBlank(startTime)){
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
					Date dateStart;
					try {
						dateStart = sf.parse(startTime);
						cri.andAnserTimeGreaterThanOrEqualTo(dateStart);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if(!StringUtils.isBlank(endTime)){
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
					Date dateEnd;
					try {
						dateEnd = sf.parse(endTime);
						cri.andAnserTimeLessThanOrEqualTo(dateEnd);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				String smsContent=receive.getSmsContent();
				if(StringUtils.isBlank(smsContent)){
					receive.setSmsContent(null);
				}else{
					cri.andSmsContentLike("%"+smsContent+"%");
				}
				if("1".equals(look)){
					cri.andHpIdEqualTo(UserSessionOperator.getCurrentHospitalId()+"");
				}else{
					cri.andSendIdEqualTo((int)UserSessionOperator.getCurrentUserId());
				}
				cri.andStateEqualTo(0);
				
				if(page!=null){
					example.setOrderByClause("id desc limit "+page.getFirstRecord()+","+page.getPageSize());
				}
			}
		
			List<ReciveMessage> receiveList=dao.selectByExample(example);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("dataList", receiveList);
			map.put("pageCountAll", this.dao.countByExample(example));
			json.setJsonData("0", map);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("-3", "查询异常");
		}
		return json;
	}
	/**
	 * 修改收件
	 * @param receive
	 * @param anserTime
	 * @param json
	 * @return
	 */
	public JsonModel update(ReciveMessage receive,String anserTime,String ids,JsonModel json){
		try {
			if(!StringUtils.isBlank(ids)){
				String []id=ids.split(",");
				for (int i = 0; i < id.length; i++) {
					receive.setSmsStatus(2);
					receive.setId(Integer.parseInt(id[i]));
					this.dao.updateByPrimaryKeySelective(receive);
					
				}
				json.setJsonData("0", "修改完成");
			}else if(!StringUtils.isBlank(anserTime)){
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date time;
					time = sf.parse(anserTime);
					receive.setAnserTime(time);
					this.dao.updateByPrimaryKeySelective(receive);
					json.setJsonData("0", "修改完成");
			}else{
				json.setJsonData("-1", "请选择数据");
			}
		} catch (ParseException e) {
			e.printStackTrace();
			json.setJsonData("0", "异常");
		}
		return json;
	};
	/**
	 * 插入收件箱
	 * @param receive
	 * @param anserTime
	 * @param json
	 * @return
	 */
	public JsonModel insert(ReciveMessage receive,String anserTime,JsonModel json){
		if(!StringUtils.isBlank(anserTime)){
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date time;
			try {
				time = sf.parse(anserTime);
				receive.setAnserTime(time);
				receive.setSmsStatus(1);
				receive.setState(0);
				receive.setSendId((int)UserSessionOperator.getCurrentUserId());
				receive.setHpId(UserSessionOperator.getCurrentHospitalId()+"");
				this.dao.insertSelective(receive);
				json.setJsonData("0", "保存完成");
			} catch (ParseException e) {
				e.printStackTrace();
				json.setJsonData("0", "保存异常");
			}
		}
		return json;
	};
	/**
	 * 删除收件箱多条数据
	 * @param ids
	 * @param json
	 * @return
	 */
	public JsonModel delete(String ids,JsonModel json){
		try {
			String []idArray=ids.split(",");
			for (String id : idArray) {
				Integer newId=Integer.parseInt(id);
				ReciveMessage recive=this.dao.selectByPrimaryKey(newId);
				recive.setState(1);
				this.dao.updateByPrimaryKeySelective(recive);
				RecycleBox box=new RecycleBox();
				box.setRefId(newId);
				box.setStatus(2);
				box.setReceiveName(recive.getSendName());
				box.setRecevieTelphone(null);
				box.setSendName(recive.getAnserName());
				box.setSendTelphone(recive.getAnserTelphone());
				box.setHpId(UserSessionOperator.getCurrentHospitalId()+"");
				box.setDeleteId(UserSessionOperator.getCurrentUserId());
				String getTime=recive.getAnserTime();
				if(StringUtils.isBlank(getTime)){
					box.setSendTime(null);
				}else{
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date time;
					time = sf.parse(recive.getAnserTime());
					box.setSendTime(time);
				}
				box.setSmsContent(recive.getSmsContent());
				box.setRecevieTime(null);
				boxDAO.insertSelective(box);
			}
			json.setJsonData("0", "删除完成");
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("0", "删除异常");
		}
		return json;
	};
	/**
	 * 收件箱回复
	 * @param id
	 * @param model
	 * @param json
	 * @return
	 */
	public JsonModel insertSend(String ids,Model model,JsonModel json){
		try {
			String[]id=ids.split(",");
			for (int i = 0; i < id.length; i++) {
				Integer newId=Integer.parseInt(id[i]);
				ReciveMessage receive=this.dao.selectByPrimaryKey(newId);
				TSendMessage send=new TSendMessage();
				send.setSmsContent(model.getModelContent());
				send.setSendName("测i是");
				send.setTelphone("13123232323");
				send.setSendTime(new Date(System.currentTimeMillis()));
				send.setSmsContent(model.getModelContent());
				send.setReceiveName(receive.getAnserName());
				send.setReceivePhone(receive.getAnserTelphone());
				sendDAO.insert(send);
			}
			json.setJsonData("0", "回复已提交");
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "回复异常");
		}
		return json;
	};
}
