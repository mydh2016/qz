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
import com.qazit.hospital.web.model.Address;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.service.AddressService;
import com.qazit.hospital.web.service.DepartmentService;
import com.qazit.sysmanager.web.security.UserSessionOperator;
@Controller
@RequestMapping("address")
public class AddressController {
	@Autowired
	private AddressService service;
	@Autowired
	private DepartmentService departmentService;
	/**
	 * 添加模板
	 * @param address Address 实体
	 * @return JsonModel
	 */
	@RequestMapping("insert")
	@ResponseBody
	public JsonModel insert(Address address,String birth,JsonModel json){
		return service.insert(address,birth,json);
	};
	/**
	 * 修改模板
	 * @param address
	 * @return JsonModel
	 */
	@RequestMapping("updateByPrimaryKey")
	@ResponseBody
	public JsonModel updateByPrimaryKey(Address address,String birth,JsonModel json){
		
		return this.service.updateByPrimaryKey(address,birth,json);
	};
	/**
	 * 删除模板
	 * @param id
	 * @return JsonModel
	 */
	@RequestMapping("deleteByPrimaryKey")
	@ResponseBody
	public JsonModel deleteByPrimaryKey(Integer id,JsonModel json){
		return this.service.deleteByPrimaryKey(id, json);
	};
	/**
	 * 根据主键查询模板
	 * @param id
	 * @return JsonModel
	 */
	@RequestMapping("selectByPrimaryKey")
	@ResponseBody
	public JsonModel selectByPrimaryKey(Integer id,JsonModel json){
		return this.service.selectByPrimaryKey(id, json);
	};
	/**
	 * 根据条件查询模板列表
	 * @param Address[
		 			name;//姓名
					sex;//性别
					telphone;//电话
					dateBirth;//出生日期 yyyyMMdd
					departments;//科室
					duties;//职务
					title;//职称
					unit;//单元
					address;//地址
					status;//内外院区别标识 1-院内 2-院外
					state;//逻辑删除 0-正常 1-删除
					createTime;//创建时间 yyyyMMddHHmm
					beginTime;//查询条件  出生日期区间-开始时间 yyyyMMdd
					endTime;//查询条件  出生日期区间-结束时间 yyyyMMdd
				]
	 * @return JsonModel
	 */
	@RequestMapping("selectForList")
	@ResponseBody
	public JsonModel selectForList(Address address,String bTime,String eTime,String birth,AbstractPage page){
		JsonModel json=new JsonModel();
		if(address.getName()==null||"".equals(address.getName())){
			address.setName(null);
		}
		if(address.getSex()==null||"".equals(address.getSex())){
			address.setSex(null);
		}
		if(address.getDepartmentId()==null){
			address.setDepartmentId(null);
		}
		if(StringUtils.isBlank(address.getDuties())){
			address.setDuties(null);
		}
		if(StringUtils.isBlank(address.getUnit())){
			address.setUnit(null);
		}
		if(StringUtils.isBlank(address.getTitle())){
			address.setTitle(null);;
		}
		if(StringUtils.isBlank(bTime)){
			address.setBeginTime(null);
		}else{
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
			try {
				address.setBeginTime(sf.parse(bTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(StringUtils.isBlank(eTime)){
			address.setBeginTime(null);
		}else{
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
			try {
				address.setEndTime(sf.parse(eTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return this.service.selectForList(address,json,page);
	};
	@RequestMapping("selectDepartments")
	@ResponseBody
	public JsonModel selectDepartments(JsonModel json){
		return this.service.selectDepartments(json);
	};
	@RequestMapping("selectDuties")
	@ResponseBody
	public JsonModel selectDuties(String departments,JsonModel json){
		return this.service.selectDuties(departments,json);
		
	};
	@RequestMapping("selectTitle")
	@ResponseBody
	public JsonModel selectTitle(JsonModel json){
		return this.service.selectTitle(json);
	};
	@RequestMapping("selectUnit")
	@ResponseBody
	public JsonModel selectUnit(JsonModel json){
		return this.service.selectUnit(json);
	};
	@RequestMapping("exportExcel")
	public void exportExcel(String ids, String allSelect,HttpServletRequest request,HttpServletResponse response ,Integer status) throws IOException{
		List<Integer>methodList=new ArrayList<Integer>();//属性序号
		methodList.add(2);
		methodList.add(3);
		methodList.add(4);
		methodList.add(5);
		methodList.add(6);
		methodList.add(7);
		methodList.add(8);
		methodList.add(9);
		methodList.add(10);
		methodList.add(11);
		HSSFWorkbook wb=this.service.exportExcel(ids, allSelect, status,methodList);
		if(wb==null){
			response.getWriter().write("<div>请选择数据<a href='javascript:void(0)' onclick='history.back()'>返回</a></div></script>");  
			return;
		}
		String fileName="";
		try {
			if(1==status){
				fileName = new String(("院内通讯录_" + System.currentTimeMillis()).getBytes("utf-8"),"ISO8859-1");
			}else{
				fileName = new String(("院外通讯录_" + System.currentTimeMillis()).getBytes("utf-8"),"ISO8859-1");
			}  
	        String headStr = "attachment; filename=\"" + fileName + "\""; 
	        response.setContentType("application/binary;charset=utf-8"); 
	        response.setHeader("Content-Disposition", headStr+".xls");  
	        OutputStream out = response.getOutputStream();
			wb.write(out);  
		} catch (IOException e) {
			e.printStackTrace();
			response.getWriter().write("<div>导出发生异常<a href='javascript:void(0)' onclick='history.back()'>返回</a></div></script>");  
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
	            StringBuffer stb=new StringBuffer();
	            for (List<Object> address : list) {
	            	Address user=new Address();
	            	int i=0;
					for (Object object : address) {
						i++;
						user=giveAddress(i,object,user);
					}
					if(user!=null){
						user.setCreaterId(UserSessionOperator.getCurrentUserId());
						user.setHpId(UserSessionOperator.getCurrentHospitalId().longValue()+"");
						json=this.service.insert(user, null,json);
						if(!"0".equals(json.getResultCode())){
							stb.append("保存提示:"+user.getName()+json.getData()+" ");
						}
					}
				}
	            if(stb.length()>0){
	            	json.setJsonData("-4", stb.toString());
	            }else{
	            	json.setJsonData("0", "导入成功");
	            }
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("3", "系统发生异常");
			}
			
		}
		return json;
	}
	public Address giveAddress(int i,Object obj,Address address){
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
				address.setTelphone(obj.toString());
			}else{
				address.setTelphone(null);
			}
			break;
		case 4:
			if(obj!=null&&obj!="null"){
				SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date date=sf.parse(obj.toString());
					address.setDateBirth(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else{
				address.setDateBirth(null);}
			break;
		case 5:
			if(obj!=null&&obj!="null"&&obj.toString().endsWith("内")){
				address.setStatus(1);
			}else if(obj!=null&&obj!="null"&&obj.toString().endsWith("外")) {
				address.setStatus(2);
			}else{
				address.setStatus(null);
			}
			break;
		case 6:
			if(obj!=null&&obj!="null"){
				List<Integer> listId=this.departmentService.selectNameToId(obj.toString(), UserSessionOperator.getCurrentHospitalId().longValue()+"");
				if(listId!=null&&!listId.isEmpty()&&listId.size()>0){
					address.setDepartmentId(listId.get(0));
				}else{
					address.setDepartmentId(null);
				}
				
				//departmentService.selectIdToName((int)obj, json);
				//address.setDepartments(obj.toString());
			}else{
				address.setDepartmentId(null);
				//address.setDepartments(null);
			}
			break;
		case 7:
			if(obj!=null&&obj!="null"){
				address.setDuties(obj.toString());
			}
			else{
				address.setDuties(null);
			}
			break;
		case 8:
			if(obj!=null&&obj!="null")
				address.setTitle(obj.toString());
			else
				address.setTitle(null);
			break;
		case 9:
			if(obj!=null&&obj!="null")
				address.setUnit(obj.toString());
			else
				address.setUnit(null);
			break;
		case 10:
			if(obj!=null&&obj!="null")
				address.setAddress(obj.toString());
			else
				address.setAddress(null);
			break;

		}
		return address;
	}
}
