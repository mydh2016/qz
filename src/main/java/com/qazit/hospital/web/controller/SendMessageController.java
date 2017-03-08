package com.qazit.hospital.web.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.util.ImportExcel;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.Model;
import com.qazit.hospital.web.model.PatientAddress;
import com.qazit.hospital.web.model.Rule;
import com.qazit.hospital.web.model.TSendMessage;
import com.qazit.hospital.web.service.AddressService;
import com.qazit.hospital.web.service.MasSendMsgService;
import com.qazit.hospital.web.service.NoDisturbService;
import com.qazit.hospital.web.service.PatientAddressService;
import com.qazit.hospital.web.service.SendMessageService;
import com.qazit.sysmanager.web.security.UserSessionOperator;
@Controller
@RequestMapping("sendMessage")
public class SendMessageController{
	@Autowired
	private SendMessageService service;
	@Autowired
	private PatientAddressService patientAddressService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private NoDisturbService noDisturbService;
	@Resource(name = "masSendServiceImpl")
	private MasSendMsgService masSendMsgService;
	
	/**
	 * 添加发件箱数据
	 * @param record
	 * @param sendType
	 * @return
	 */
	@RequestMapping("insert")
	@ResponseBody
	public JsonModel insert(TSendMessage record,Rule rule,Model model,String addressjson,String noDisturbojson,Integer modelId ){
		JsonModel json=new JsonModel();
		JSONArray addresses=null;
		if(addressjson!=null&&!"undefined".equals(addressjson)){
			addresses=JSONArray.fromObject(addressjson);
		}else{
			json.setJsonData("1", "请选择联系人");
			return json;
		}
		if(model==null){
			json.setJsonData("1", "请选择模板");
			return json;
		}
		if(modelId==null){
			json.setJsonData("1", "系统异常，请联系管理员");
			return json;
		}
		model.setId(modelId);
		JSONArray noDisturbes=null;
		if(noDisturbojson!=null&&!"undefined".equals(noDisturbojson)){
			noDisturbes=JSONArray.fromObject(noDisturbojson);
			for (Object add : addresses) {
				JSONObject jsonadd=JSONObject.fromObject(add);
				for (Object nod : noDisturbes) {
					JSONObject jsonnod=JSONObject.fromObject(nod);
					if(jsonadd.get("telphone").equals(jsonnod.get("telphone"))){
						addresses.remove(add);
					}
				}
			}
		}
		
		if(model!=null&&!StringUtils.isBlank(model.getModelContent())&&!model.getModelContent().contains("#")){
			if(model!=null&&!StringUtils.isBlank(model.getModelContent())&&!model.getModelContent().contains("#")){
				for (Object object : addresses) {
					TSendMessage sendMessage=new TSendMessage();
					sendMessage.setModelId(record.getModelId());
					sendMessage.setSendName(UserSessionOperator.getCurrentUserName());
					Date date=new Date(System.currentTimeMillis());
					sendMessage.setSendTime(date);
					sendMessage.setState(1);
					JSONObject jsonObj=JSONObject.fromObject(object);
					sendMessage.setReceiveName(jsonObj.getString("name"));
					sendMessage.setReceivePhone(jsonObj.getString("telphone"));
					sendMessage.setSmsContent(model.getModelContent());
					json=this.service.insertSelective(sendMessage, json);
					if ("0".equals(json.getResultCode())) {
							this.service.send(model, rule, jsonObj,sendMessage,json);
						continue;
					}else{
						return json;
					}
				}
			}
		}else if(model!=null&&!StringUtils.isBlank(model.getModelContent())&&model.getModelContent().contains("#")){
			for (Object object : addresses) {
				TSendMessage sendMessage=new TSendMessage();
				sendMessage.setModelId(record.getModelId());
				sendMessage.setSendName(UserSessionOperator.getCurrentUserName());
				Date date=new Date(System.currentTimeMillis());
				sendMessage.setSendTime(date);
				sendMessage.setState(1);
				JSONObject jsonObj=JSONObject.fromObject(object);
				sendMessage.setReceiveName(jsonObj.getString("name"));
				sendMessage.setReceivePhone(jsonObj.getString("telphone"));
				String content=model.getModelContent();
				content=content.replaceAll("#telphone#", jsonObj.getString("telphone"));
				content=content.replaceAll("#name#", jsonObj.getString("name"));
				if(object.toString().contains("category")){
					content=content.replaceAll("#disease#", jsonObj.getString("category"));
				}else{
					content=content.replaceAll("#disease#", "");
				}
				model.setModelContent(content);
				sendMessage.setSmsContent(content);
				json=this.service.insertSelective(sendMessage, json);
				if ("0".equals(json.getResultCode())) {
					this.service.send(model, rule, jsonObj,sendMessage,json);
					continue;
				}else{
					return json;
				}
			}
		}
		return json;
	};
	/**
	 * 修改发件箱数据
	 * @param record
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public JsonModel update(TSendMessage record){
		JsonModel json=new JsonModel();
		return this.service.updateByPrimaryKeySelective(record, json);
	};
	/**
	 * 删除发件箱数据
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public JsonModel delete(String ids){
		JsonModel json=new JsonModel();
		return this.service.deleteByPrimaryKey(ids, json);
	};
	/**
	 * 根据id查询单个发件信息
	 * @param id
	 * @return
	 */
	@RequestMapping("selectByPrimaryKey")
	@ResponseBody
	public JsonModel selectByPrimaryKey(Integer id){
		JsonModel json=new JsonModel();
		return this.service.selectByPrimaryKey(id, json);
	};
	/**
	 * 查询发件箱列表
	 * @param record
	 * @param startTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	@RequestMapping("selectForList")
	@ResponseBody
	public JsonModel selectForList(TSendMessage record,String look,String startTime,String endTime,AbstractPage page){
		JsonModel json=new JsonModel();
		return this.service.selectByExample(record,look,startTime,endTime,page,json);
	};
	@RequestMapping("selectNoDisturb")
	@ResponseBody
	public JsonModel selectNoDisturb(String ids){
		JsonModel json=new JsonModel();
		if(!StringUtils.isBlank(ids)){
			List<Object>list=new ArrayList<Object>();
			String []id=ids.split(",");
			for (int i = 0; i < id.length; i++) {
				json=this.noDisturbService.selectByPrimaryKey(Integer.parseInt(id[i]), json);
				if("0".equals(json.getResultCode())){
					list.add(json.getData());
				}
			}
			Map<String,Object>map=new HashMap<String, Object>();
	         map.put("dataList", list);
	         map.put("pageCountAll",6);
			json.setJsonData("0", map);
		}else{
			json.setJsonData("1", "参数错误");
		}
		return json;
	};
	@RequestMapping("selectAddress")
	@ResponseBody
	public JsonModel selectAddress(String ids){
		JsonModel json=new JsonModel();
		if(!StringUtils.isBlank(ids)){
			List<Object>list=new ArrayList<Object>();
			String []id=ids.split(",");
			for (int i = 0; i < id.length; i++) {
				json=this.addressService.selectByPrimaryKey(Integer.parseInt(id[i]), json);
				if("0".equals(json.getResultCode())){
					list.add(json.getData());
				}
			}
			 Map<String,Object>map=new HashMap<String, Object>();
	         map.put("dataList", list);
	         map.put("pageCountAll",6);
			json.setJsonData("0", map);
		}else{
			json.setJsonData("1", "参数错误");
		}
		return json;
	};
	@RequestMapping("selectPatientAddress")
	@ResponseBody
	public JsonModel selectPatientAddress(String ids){
		JsonModel json=new JsonModel();
		if(!StringUtils.isBlank(ids)){
			List<Object>list=new ArrayList<Object>();
			String []id=ids.split(",");
			for (int i = 0; i < id.length; i++) {
				json=this.patientAddressService.selectByPrimaryKey(Integer.parseInt(id[i]), json);
				if("0".equals(json.getResultCode())){
					list.add(json.getData());
				}
			}
			 Map<String,Object>map=new HashMap<String, Object>();
	         map.put("dataList", list);
	         map.put("pageCountAll",6);
			json.setJsonData("0", map);
		}else{
			json.setJsonData("1", "参数错误");
		}
		return json;
	};
	@RequestMapping("upload")
	@ResponseBody
	public JsonModel upload(HttpServletRequest request,MultipartFile file){ 
		JsonModel json=new JsonModel();
		List<PatientAddress>patientList=new ArrayList<PatientAddress>();
		if(file==null||file.isEmpty()){
			json.setJsonData("1", "请选择上传文件");
		}else{
			try {
				String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");   
	            //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉  
	            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, file.getOriginalFilename()));
	            ImportExcel importExcel=new ImportExcel();
	            List<List<Object>> list=importExcel.readExcel(realPath+"/"+file.getOriginalFilename());
	            for (List<Object> address : list) {
	            	PatientAddress user=new PatientAddress();
	            	int i=0;
					for (Object object : address) {
						i++;
						user=giveAddress(i,object,user);
					}
					if(user!=null){
						patientList.add(user);
					}
				}
	            Map<String,Object>map=new HashMap<String, Object>();
	            map.put("dataList", patientList);
	            map.put("pageCountAll",6);
	            json.setJsonData("0", map);
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("3", "系统发生异常");
			}
			
		}
		return json;
	}
	public PatientAddress giveAddress(int i,Object obj,PatientAddress address){
		switch (i) {
		case 1:
			if(obj!=null&&obj!="null"){
				address.setName(obj.toString());
			}else{
				address.setName(null);
			}
			break;
		case 2:
			if(obj!=null&&obj!="null"&&"男".equals(obj)){
				address.setSex(1);
			}else if(obj!=null&&obj!="null"&&"女".equals(obj)){
				address.setSex(2);
			}else{
				address.setSex(null);
			}
			break;
		case 3:
			if(obj!=null&&obj!="null"){
				address.setCategory(obj.toString());
			}else{
				address.setCategory(null);
			}
			break;
		case 4:
			if(obj!=null&&obj!="null"){
				address.setTelphone(obj.toString());
			}else{
				address.setTelphone(null);
			}
			break;
		case 5:
			if(obj!=null&&obj!="null"){
				SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date date=sf.parse(obj.toString());
					address.setDateBirth(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else{
				address.setDateBirth(null);
			}
			break;
		case 6:
			if(obj!=null&&obj!="null")
				address.setUnit(obj.toString());
			else
				address.setUnit(null);
			break;
		case 7:
			if(obj!=null&&obj!="null")
				address.setAddress(obj.toString());
			else
				address.setAddress(null);
			break;

		}
		return address;
	}
}
