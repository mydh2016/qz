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
import com.qazit.hospital.web.model.ReciveMessage;
import com.qazit.hospital.web.model.RecycleBox;
import com.qazit.hospital.web.model.RecycleBoxExample;
import com.qazit.hospital.web.model.RecycleBoxExample.Criteria;
import com.qazit.hospital.web.model.TSendMessage;
import com.qazit.hospital.web.service.RecycleBoxService;
import com.qazit.sysmanager.web.security.UserSessionOperator;
@Service("recycleBoxService")
public class RecycleBoxServiceImpl implements RecycleBoxService{
	@Autowired
	private RecycleBoxMapper dao;
	@Autowired
	private TSendMessageMapper sendDAO;
	@Autowired
	private ReciveMessageMapper receiveDAO;
	@Override
	public JsonModel delete(String ids,JsonModel json) {
		if(StringUtils.isBlank(ids)){
			json.setJsonData("1", "请选择数据");
			return json;
		}
		try {
			String []id=ids.split(",");
			for (int i = 0; i < id.length; i++) {
				String []all=id[i].split("#");
				String StringId=all[0];
				Integer newId=Integer.parseInt(StringId);
				this.dao.deleteByPrimaryKey(newId);
			}
			json.setJsonData("0", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("-3", "删除异常");
		}
		
		return json;
	}

	@Override
	public JsonModel update(String ids,JsonModel json) {
		if(StringUtils.isBlank(ids)){
			json.setJsonData("1", "请选择数据");
			return json;
		}
		try {
			String []id=ids.split(",");
			for (int i = 0; i < id.length; i++) {
				String []all=id[i].split("#");
				String statu=all[2];
				if("1".equals(statu)){
					Integer newId=Integer.parseInt(all[1]);
					TSendMessage send=new TSendMessage();
					send.setDelStatus(0);
					send.setId(newId);
					this.sendDAO.updateByPrimaryKeySelective(send);
					this.dao.deleteByPrimaryKey(Integer.parseInt(all[0]));
				}
				if("2".equals(statu)){
					Integer newId=Integer.parseInt(all[1]);
					ReciveMessage receive=new ReciveMessage();
					receive.setId(newId);
					receive.setState(0);
					this.receiveDAO.updateByPrimaryKeySelective(receive);
					this.dao.deleteByPrimaryKey(Integer.parseInt(all[0]));
				}
				
			}
			json.setJsonData("0", "恢复成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("-3", "恢复异常");
		}
		
		return json;
	}

	@Override
	public JsonModel selectForList(RecycleBox box,String sTime,String eTime,JsonModel json,AbstractPage page) {
		RecycleBoxExample example=new RecycleBoxExample();
		Criteria cri=example.createCriteria();
		try {
			if(box==null){
				return null;
			}else{
				String sendName=box.getSendName();
				if(StringUtils.isBlank(sendName)){
					box.setSendName(null);
				}else{
					cri.andSendNameLike("%"+sendName+"%");
				}
				String sendTelphone=box.getSendTelphone();
				if(StringUtils.isBlank(sendTelphone)){
					box.setSendTelphone(null);
				}else{
					cri.andSendTelphoneLike("%"+sendTelphone+"%");
				}
				String receiveName=box.getReceiveName();
				if(StringUtils.isBlank(receiveName)){
					box.setReceiveName(null);
				}else{
					cri.andReceiveNameLike("%"+receiveName+"%");
				}
				if(!StringUtils.isBlank(sTime)){
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
					Date dateStart;
					try {
						dateStart = sf.parse(sTime);
						cri.andSendTimeGreaterThan(dateStart);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				if(!StringUtils.isBlank(eTime)){
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
					Date dateEnd;
					try {
						dateEnd = sf.parse(eTime);
						cri.andSendTimeLessThan(dateEnd);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				cri.andDeleteIdEqualTo(UserSessionOperator.getCurrentUserId());
				if(page!=null){
					example.setOrderByClause("id desc limit "+page.getFirstRecord()+","+page.getPageSize());
				}
			}
		
			List<RecycleBox> recycleBoxList=dao.selectByExampleWithBLOBs(example);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("dataList", recycleBoxList);
			map.put("pageCountAll", this.dao.countByExample(example));
			json.setJsonData("0", map);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("-3", "查询异常");
		}
		return json;
	}

}
