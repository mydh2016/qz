package com.qazit.hospital.web.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.dao.mapper.DepartmentMapper;
import com.qazit.hospital.web.dao.mapper.ModelMapper;
import com.qazit.hospital.web.dao.mapper.RecycleBoxMapper;
import com.qazit.hospital.web.dao.mapper.TSendMessageMapper;
import com.qazit.hospital.web.model.Department;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.Model;
import com.qazit.hospital.web.model.RecycleBox;
import com.qazit.hospital.web.model.Rule;
import com.qazit.hospital.web.model.TSendMessage;
import com.qazit.hospital.web.model.TSendMessageExample;
import com.qazit.hospital.web.model.TSendMessageExample.Criteria;
import com.qazit.hospital.web.service.MasSendMsgService;
import com.qazit.hospital.web.service.SendMessageService;
import com.qazit.sysmanager.web.model.JsonResultMessage;
import com.qazit.sysmanager.web.security.UserSessionOperator;
import com.qazit.sysmanager.web.service.IPartnerService;
@Service("sendMessageService")
public class SendMessageServiceImpl extends BaseService implements SendMessageService{
	@Autowired
	private TSendMessageMapper dao;
	@Autowired
	private RecycleBoxMapper boxDAO;
	@Resource(name = "masSendServiceImpl")
	private MasSendMsgService masSendMsgService;
	@Autowired
	private ModelMapper modelDAO;
	@Autowired
	private DepartmentMapper departmentDAO;
	@Autowired
	private IPartnerService iPartnerService;
	/**
	 * 根据主键删除
	 * @param id
	 * @return
	 */
	public JsonModel deleteByPrimaryKey(String ids,JsonModel json){
		if(StringUtils.isBlank(ids)){
			json.setJsonData("1", "请选择数据");
			return json;
		}
		try {
			String [] id =ids.split(",");
			for (int i = 0; i < id.length; i++) {
				Integer newId=Integer.parseInt(id[i]);
				TSendMessage record=dao.selectByPrimaryKey(newId);
				record.setDelStatus(1);
				dao.updateByPrimaryKeySelective(record);
				RecycleBox box=new RecycleBox();
				box.setRefId(newId);
				box.setStatus(1);
				box.setReceiveName(record.getReceiveName());
				box.setRecevieTelphone(record.getReceivePhone());
				box.setSendName(record.getSendName());
				box.setSendTelphone(record.getTelphone());
				String time=record.getSendTime();
				SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date stime=sf.parse(time);
				box.setSendTime(stime);
				box.setSmsContent(record.getSmsContent());
				box.setRecevieTime(null);
				box.setDeleteId(UserSessionOperator.getCurrentUserId());
				box.setHpId(UserSessionOperator.getCurrentHospitalId().longValue()+"");
				boxDAO.insertSelective(box);
			}
			
			json.setJsonData("0", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "删除异常");
		}
		return json;
	};
	/**
	 * 保存
	 * @param record
	 * @return
	 */
	public JsonModel insertSelective(TSendMessage record,JsonModel json){
			try {
					Department dp=departmentDAO.selectByPrimaryKey(UserSessionOperator.getCurrentUser().getDepartmentId());
					if(dp!=null){
						record.setDepartmentId(dp.getDepartmentId());
					}
					record.setDelStatus(0);
					record.setCreateTime(new Date());
					record.setCreaterId(UserSessionOperator.getCurrentUserId());
					record.setHpId(UserSessionOperator.getCurrentHospitalId().longValue()+"");
					dao.insertSelective(record);
					json.setJsonData("0", "保存成功");
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("3", "系统异常");
			}
		return json;
	};
	/**
	 * 根据主键查询患者通讯录
	 * @param id
	 * @return
	 */
	public JsonModel selectByPrimaryKey(Integer id,JsonModel json){
		try {
			TSendMessage TSendMessage=dao.selectByPrimaryKey(id);
			json.setJsonData("0", TSendMessage);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("1", "查询异常");
		}
		return json;
	};
	/**
	 * 查询患者通讯录
	 * @param example
	 * @return
	 */
	public JsonModel selectByExample(TSendMessage record,String look,String startTime,String endTime,AbstractPage page,JsonModel json){
		try {
			TSendMessageExample example=null;
			example=new TSendMessageExample();
			Criteria cri=example.createCriteria();
			if(record!=null){
				String sendName=record.getSendName();
				Integer state=record.getState();
				String telphone=record.getTelphone();
				Integer departmentId=record.getDepartmentId();
				String duties=record.getDuties();
				String title=record.getTitle();
				String unit=record.getUnit();
				String address=record.getAddress();
				String receiveName=record.getReceiveName();
				String smsContent=record.getSmsContent();
				if(departmentId!=null){
					cri.andDepartmentIdEqualTo(departmentId);
				}
				if(!StringUtils.isBlank(sendName)){
					cri.andSendNameLike('%'+sendName+'%');
				}
				if(state!=null){
					cri.andStateEqualTo(state);
				}
				if(!StringUtils.isBlank(telphone)){
					cri.andTelphoneLike('%'+telphone+'%');
				}
				if(!StringUtils.isBlank(startTime)){
					cri.andSendTimeGreaterThanOrEqualTo(startTime);
				}
				if(!StringUtils.isBlank(endTime)){
					cri.andSendTimeLessThan(endTime);
				}
				if(!StringUtils.isBlank(duties)){
					cri.andDutiesLike('%'+duties+'%');
				}
				if(!StringUtils.isBlank(title)){
					cri.andTitleLike('%'+title+'%');
				}
				if(!StringUtils.isBlank(unit)){
					cri.andUnitLike('%'+unit+'%');
				}
				if(!StringUtils.isBlank(address)){
					cri.andAddressLike('%'+address+'%');
				}
				if(!StringUtils.isBlank(receiveName)){
					cri.andReceiveNameLike('%'+receiveName+'%');
				}
				if(!StringUtils.isBlank(smsContent)){
					cri.andSmsContentLike('%'+smsContent+'%');
				}
				if("1".equals(look)){
					cri.andHpIdEqualTo(UserSessionOperator.getCurrentHospitalId().longValue()+"");
				}else{
					cri.andCreaterIdEqualTo(UserSessionOperator.getCurrentUserId());
				}
				cri.andDelStatusEqualTo(0);
				if(page!=null){
					example.setOrderByClause("create_time desc limit "+page.getFirstRecord()+","+page.getPageSize());
				}
			}else{
				cri.andCreaterIdEqualTo(UserSessionOperator.getCurrentUserId());
				cri.andDelStatusEqualTo(0);
				if(page!=null){
					example.setOrderByClause("create_time desc limit "+page.getFirstRecord()+","+page.getPageSize());
				}
			}
			List<TSendMessage> patientList=dao.selectByExample(example);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("dataList", patientList);
			map.put("pageCountAll", this.dao.countByExample(example));
			/*map.put("type", type);*/
			json.setJsonData("0", map);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "查询异常");
		}
		return json;
	};
	/**
	 * 根据主键修改患者信息
	 * @param record
	 * @return
	 */
	public JsonModel updateByPrimaryKeySelective(TSendMessage record,JsonModel json){
			try {
					dao.updateByPrimaryKey(record);
					json.setJsonData("0", "保存成功");
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("3", "保存异常");
			}
		return json;
	};
	/**
	 * 发送短信
	 * @throws ParseException 
	 */
	public JsonModel send(Model model,Rule rule,JSONObject jsonObj,TSendMessage record,JsonModel json){
		String [] telphones={jsonObj.getString("telphone")};
		Integer id=record.getId();
		Model selectModel=modelDAO.selectByPrimaryKey(model.getId());
		boolean isMo=false;
		if(selectModel.getIsOn()==1){
			isMo=true;
		}
		JsonResultMessage jsrm=iPartnerService.getPartnerNoById(UserSessionOperator.getCurrentHospitalId());
		String code=jsrm.getResultCode();
		
		String hpNo="";
		if("0".equals(code)){
			hpNo=jsrm.getData().toString();
		}else{
			json.setJsonData("-1", "发送失败，该医院编码错误");
			return json;
		}
		try {
			if(1==rule.getSendType()){
				JsonModel newjson=masSendMsgService.sendMessage(telphones, model.getModelContent(), hpNo, 1, isMo, id, model.getId());
				if("0".equals(newjson.getResultCode())){
					record.setState(1);
				}else {
					record.setState(4);
				}
				this.updateByPrimaryKeySelective(record, newjson);
			}else if(2==rule.getSendType()){
				if(1==rule.getType()){
					String [] times=rule.getcTimes().split(",");
					List<Date>dateList=new ArrayList<Date>();
					for (int i = 0; i < times.length; i++) {
						SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
						dateList.add(sf.parse(times[i]));
					}

					JsonModel newjson=masSendMsgService.sendTimedTaskMsg(telphones, model.getModelContent(), hpNo, model.getId(), 1, isMo, id, 5, null, dateList, null, null);
					if("0".equals(newjson.getResultCode())){
						record.setState(1);
					}else {
						record.setState(4);
					}
					this.updateByPrimaryKeySelective(record, newjson);
				}else if(2==rule.getType()){
					if(StringUtils.isBlank(rule.getStartTime())){
						json.setJsonData("-1", "请选择开始时间");
						return json;
					}
					if(StringUtils.isBlank(rule.getEndTime())){
						json.setJsonData("-1", "请选择结束时间");
						return json;
					}
					long nowTime=System.currentTimeMillis();
					SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
					String stringNowTime=format.format(new Date(nowTime));
					String stringStartTime=rule.getStartTime().replaceAll("-", "");
					String stringEndTime=rule.getEndTime().replaceAll("-", "");
					long longNowTime=Long.parseLong(stringNowTime);
					long longStartTime=Long.parseLong(stringStartTime);
					long longEndTime=Long.parseLong(stringEndTime);
					if(longStartTime<longNowTime){
						json.setJsonData("-1", "开始时间不得小于当前时间");
						return json;
					}
					if(longNowTime>longEndTime){
						json.setJsonData("-1", "当前时间不得大于结束时间");
						return json;
					}
					SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
					Date startTime=simple.parse(rule.getStartTime());
					Date endTime=simple.parse(rule.getEndTime());
					String time=rule.getTime().replaceAll(":00", "");
					if(time.startsWith("0")){
						time=time.replaceFirst("0", "");
					}
					JsonModel newjson=masSendMsgService.sendTimedTaskMsg(telphones, model.getModelContent(),hpNo,model.getId(), 1, isMo, id, 2, time, null, startTime, endTime);
					if("0".equals(newjson.getResultCode())){
						record.setState(1);
					}else{
						record.setState(4);
					}
					this.updateByPrimaryKeySelective(record, newjson);
				}else if(3==rule.getType()){
					if(StringUtils.isBlank(rule.getStartTime())){
						json.setJsonData("-1", "请选择开始时间");
						return json;
					}
					if(StringUtils.isBlank(rule.getEndTime())){
						json.setJsonData("-1", "请选择结束时间");
						return json;
					}
					if(StringUtils.isBlank(rule.getPoint())){
						json.setJsonData("-1", "请选择时间");
						return json;
					}
					long nowTime=System.currentTimeMillis();
					SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
					String stringNowTime=format.format(new Date(nowTime));
					String stringStartTime=rule.getStartTime().replaceAll("-", "");
					String stringEndTime=rule.getEndTime().replaceAll("-", "");
					long longNowTime=Long.parseLong(stringNowTime);
					long longStartTime=Long.parseLong(stringStartTime);
					long longEndTime=Long.parseLong(stringEndTime);
					if(longStartTime<longNowTime){
						json.setJsonData("-1", "开始时间不得小于当前时间");
						return json;
					}
					if(longNowTime>longEndTime){
						json.setJsonData("-1", "当前时间不得大于结束时间");
						return json;
					}
					SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
					Date startTime=simple.parse(rule.getStartTime());
					Date endTime=simple.parse(rule.getEndTime());
					String point="#"+rule.getPoint().replaceAll(":00", "");
					if(point.startsWith("0")){
						point=point.replaceFirst("0", "");
					}
					JsonModel newjson=masSendMsgService.sendTimedTaskMsg(telphones, model.getModelContent(),hpNo,model.getId(), 1, isMo, id, 2, rule.getWeak()+point, null, startTime, endTime);
					if("0".equals(newjson.getResultCode())){
						record.setState(1);
					}else{
						record.setState(4);
					}
					this.updateByPrimaryKeySelective(record, newjson);
				}else if(4==rule.getType()){
					if(StringUtils.isBlank(rule.getStartTime())){
						json.setJsonData("-1", "请选择开始时间");
						return json;
					}
					if(StringUtils.isBlank(rule.getEndTime())){
						json.setJsonData("-1", "请选择结束时间");
						return json;
					}
					long nowTime=System.currentTimeMillis();
					SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
					String stringNowTime=format.format(new Date(nowTime));
					String stringStartTime=rule.getStartTime().replaceAll("-", "");
					String stringEndTime=rule.getEndTime().replaceAll("-", "");
					long longNowTime=Long.parseLong(stringNowTime);
					long longStartTime=Long.parseLong(stringStartTime);
					long longEndTime=Long.parseLong(stringEndTime);
					if(longStartTime<longNowTime){
						json.setJsonData("-1", "开始时间不得小于当前时间");
						return json;
					}
					if(longNowTime>longEndTime){
						json.setJsonData("-1", "当前时间不得大于结束时间");
						return json;
					}
					SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
					Date startTime=simple.parse(rule.getStartTime());
					Date endTime=simple.parse(rule.getEndTime());
					String [] time=rule.getTime().split("-");
					String fTime=time[time.length-1].replace(" ", "#").replace(":00", "");
					if(fTime.startsWith("0")){
						fTime=fTime.replaceFirst("0", "");
					}
					JsonModel newjson=masSendMsgService.sendTimedTaskMsg(telphones, model.getModelContent(),hpNo,model.getId(), 1, isMo, id, 2, fTime, null, startTime, endTime);
					if("0".equals(newjson.getResultCode())){
						record.setState(1);
					}else{
						record.setState(4);
					}
					this.updateByPrimaryKeySelective(record, newjson);
				}
				
			}else if(3==rule.getSendType()){
				String [] times=rule.getcTimes().split(",");
				List<Date>dateList=new ArrayList<Date>();
				for (int i = 0; i < times.length; i++) {
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
					dateList.add(sf.parse(times[i]));
				}
				JsonModel newjson=masSendMsgService.sendTimedTaskMsg(telphones, model.getModelContent(),hpNo,model.getId(), 1,isMo, id, 5, null, dateList, null, null);
				if("0".equals(newjson.getResultCode())){
					record.setState(1);
				}else{
					record.setState(4);
				}
				this.updateByPrimaryKeySelective(record, newjson);
			}
			json.setJsonData("0", "已提交");
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("0", "提交异常");
		}
		return json;
	}
}
