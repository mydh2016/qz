package com.qazit.hospital.web.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.util.ImportExcel;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.TNoDisturb;
import com.qazit.hospital.web.service.NoDisturbService;
@Controller
@RequestMapping("noDisturb")
public class NoDisturbController {
	@Autowired
	private NoDisturbService service;
	@RequestMapping("insert")
	@ResponseBody
	public JsonModel insert(TNoDisturb record){
		JsonModel json=new JsonModel();
		return this.service.insertSelective(record, json);
	};
	@RequestMapping("update")
	@ResponseBody
	public JsonModel update(TNoDisturb record){
		JsonModel json=new JsonModel();
		return this.service.updateByPrimaryKeySelective(record, json);
	};
	@RequestMapping("delete")
	@ResponseBody
	public JsonModel delete(Integer id){
		JsonModel json=new JsonModel();
		return this.service.deleteByPrimaryKey(id, json);
	};
	@RequestMapping("selectByPrimaryKey")
	@ResponseBody
	public JsonModel selectByPrimaryKey(Integer id){
		JsonModel json=new JsonModel();
		return this.service.selectByPrimaryKey(id, json);
	};
	@RequestMapping("selectForList")
	@ResponseBody
	public JsonModel selectForList(TNoDisturb record,AbstractPage page){
		JsonModel json=new JsonModel();
		return this.service.selectByExample(record,page,json);
	};
	@RequestMapping("upload")
	@ResponseBody
	public JsonModel upload(HttpServletRequest request,MultipartFile file){ 
		JsonModel json=new JsonModel();
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
	            	TNoDisturb user=new TNoDisturb();
	            	int i=0;
					for (Object object : address) {
						i++;
						user=giveAddress(i,object,user);
					}
					if(user!=null){
						this.service.insertSelective(user, json);
					}
				}
	            json.setJsonData("0", "导入成功");
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("3", "系统发生异常");
			}
			
		}
		return json;
	}
	public TNoDisturb giveAddress(int i,Object obj,TNoDisturb address){
		switch (i) {
		case 1:
			if(obj!=null&&obj!="null"){
				address.setName(obj.toString());
			}else{
				address.setName(null);
			}
			break;
		case 2:
			if(obj!=null&&obj!="null"){
				address.setCategory(obj.toString());
			}else{
				address.setCategory(null);
			}
			break;
		case 3:
			if(obj!=null&&obj!="null"){
				address.setTelphone(obj.toString());
			}else{
				address.setTelphone(null);
			}
			break;

		}
		return address;
	}
}
