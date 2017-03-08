package com.qazit.hospital.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.util.ImportExcel;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.PatientAddress;
import com.qazit.hospital.web.service.PatientAddressService;


@Controller
@RequestMapping("patientAddress")
public class PatientAddressController {
	@Autowired
	private PatientAddressService service;
	@RequestMapping("insert")
	@ResponseBody
	public JsonModel insert(PatientAddress record,String birth){
		JsonModel json=new JsonModel();
		return this.service.insertSelective(record,birth,json);
	};
	@RequestMapping("update")
	@ResponseBody
	public JsonModel update(PatientAddress record,String birth){
		JsonModel json=new JsonModel();
		return this.service.updateByPrimaryKeySelective(record,birth, json);
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
	public JsonModel selectForList(PatientAddress record,String look,String birth,String beginTime,String endTime,AbstractPage page){
		JsonModel json=new JsonModel();
		return this.service.selectByExample(record,look,beginTime,endTime,page,json);
	};
	@RequestMapping("selectCategory")
	@ResponseBody
	public JsonModel selectCategory(){
		JsonModel json=new JsonModel();
		return this.service.selectCategory(json);
	}
	@RequestMapping("exportExcel")
	public void exportExcel(String ids, String allSelect,HttpServletRequest request,HttpServletResponse response ,Integer status) throws IOException{
		if(ids==null&&(StringUtils.isBlank(ids))){
			response.getWriter().write("<div>请选择数据<a href='javascript:void(0)' onclick='history.back()'>返回</a></div></script>");  
		    return ;
		    
		}
		List<Integer>methodList=new ArrayList<Integer>();//属性序号
		methodList.add(1);
		methodList.add(2);
		methodList.add(3);
		methodList.add(4);
		methodList.add(5);
		methodList.add(6);
		methodList.add(7);
		HSSFWorkbook wb=this.service.exportExcel(ids, allSelect, status,methodList);
		String fileName=String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
        String headStr = "attachment; filename=\"" + fileName + "\""; 
		response.setContentType("APPLICATION/OCTET-STREAM");  
        response.setHeader("Content-Disposition", headStr);  
        OutputStream out;
		try {
			out = response.getOutputStream();
			wb.write(out);  
		} catch (IOException e) {
			e.printStackTrace();
		}  
        
	}
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
	            	PatientAddress user=new PatientAddress();
	            	int i=0;
					for (Object object : address) {
						i++;
						user=giveAddress(i,object,user);
					}
					if(user!=null){
						this.service.insertSelective(user, null,json);
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
