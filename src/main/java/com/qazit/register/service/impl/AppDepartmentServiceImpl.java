package com.qazit.register.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.web.model.JsonModel;
import com.qazit.register.dao.mapper.AppDepartmentMapper;
import com.qazit.register.dao.mapper.AppDepartmentTypeMapper;
import com.qazit.register.dao.mapper.AppHospitalInfoMapper;
import com.qazit.register.model.AppDepartmentTypeVO;
import com.qazit.register.model.AppDepartmentVO;
import com.qazit.register.model.AppHospitalVO;
import com.qazit.register.service.AppDepartmentService;

@Service("AppDepartmentService")
public class AppDepartmentServiceImpl implements AppDepartmentService
{
	@Autowired
	private AppDepartmentMapper adDao;
	
	@Autowired
	private AppDepartmentTypeMapper adtDAO;
	
	@Autowired
	private AppHospitalInfoMapper hostDAO;
	
		@Override
		public JsonModel selectAllDepartmentType(AppHospitalVO av,AppDepartmentTypeVO ad,JsonModel json)
		{
			HashMap<String, Object> hashMap=new HashMap<String, Object>();
			if (av==null) {
				json.setJsonData("1", "参数异常");
			}else{
			try {
				
				AppHospitalVO selectbyHospital = hostDAO.selectbyHospital(av.getHcode());
				hashMap.put("selectbyHospital", selectbyHospital);
				
				
				List<AppDepartmentVO> Tedepartment = adDao.selectdepartment(av.getHcode());
				
				if(!Tedepartment.isEmpty()){
					AppDepartmentTypeVO app=new AppDepartmentTypeVO();
					app.setDeleteId('0');
					app.setDepartmentTypeSn("1001");
					app.setDepartmentTypeName("特色科室");
					List<AppDepartmentTypeVO> selectByhospitalSn = adtDAO.selectAlldepartmentType(av.getHcode());
					selectByhospitalSn.add(0, app);
					hashMap.put("selectByhospitalSn", selectByhospitalSn);
					List<AppDepartmentVO> selectdepartment = adDao.selectdepartment(av.getHcode());
					hashMap.put("selectdepartment", selectdepartment);
				}else{
					List<AppDepartmentTypeVO> selectByhospitalSn = adtDAO.selectAlldepartmentType(av.getHcode());
					hashMap.put("selectByhospitalSn", selectByhospitalSn);
					List<AppDepartmentVO> selectdepartment = adDao.selectAlldepartment(av.getHcode(), ad.getDepartmentTypeSn());
					hashMap.put("selectdepartment", selectdepartment);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				json.setJsonData("2", "查询异常");
			}
			}
			json.setJsonData("0", hashMap);
			return json;
		}
		
		@Override
		public JsonModel selectAllDepartment(AppHospitalVO av,AppDepartmentTypeVO ad,JsonModel json)
		{
			if (av==null) {
				json.setJsonData("1", "参数异常");
			}else{
			try {
				List<AppDepartmentVO> selectdepartment=null;
				
				AppDepartmentTypeVO app=new AppDepartmentTypeVO();
				app.setDeleteId('0');
				app.setDepartmentTypeSn("1001");
				app.setDepartmentTypeName("特色科室");
				List<AppDepartmentTypeVO> selectByhospitalSn = adtDAO.selectAlldepartmentType(av.getHcode());
				selectByhospitalSn.add(0, app);
				List<AppDepartmentVO> Tedepartment = adDao.selectdepartment(av.getHcode());
				
				if(ad.getDepartmentTypeSn().equals(selectByhospitalSn.get(0).getDepartmentTypeSn())){
					selectdepartment = adDao.selectdepartment(av.getHcode());
				}else{
					
				selectdepartment = adDao.selectAlldepartment(av.getHcode(), ad.getDepartmentTypeSn());
				}
				json.setJsonData("0", selectdepartment);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				json.setJsonData("2", "查询异常");
			}
			}
			return json;
		}

		@Override
		public JsonModel selectTeDepartment(AppHospitalVO av,AppDepartmentTypeVO ad, JsonModel json) 
		{
			HashMap<String, Object> hashMap=new HashMap<String, Object>();
			try 
			{
				AppHospitalVO selectbyHospital = hostDAO.selectbyHospital(av.getHcode());
				hashMap.put("selectbyHospital", selectbyHospital);
				
				List<AppDepartmentVO> Tedepartment = adDao.selectdepartment(av.getHcode());
				if(!Tedepartment.isEmpty()){
					AppDepartmentTypeVO app=new AppDepartmentTypeVO();
					app.setDeleteId('0');
					app.setDepartmentTypeSn("1001");
					app.setDepartmentTypeName("特色科室");
					List<AppDepartmentTypeVO> selectByhospitalSn = adtDAO.selectAlldepartmentType(av.getHcode());
					selectByhospitalSn.add(0, app);
					hashMap.put("selectByhospitalSn", selectByhospitalSn);
					List<AppDepartmentVO> selectdepartment = adDao.selectdepartment(av.getHcode());
					hashMap.put("selectdepartment", selectdepartment);
				}else{
					List<AppDepartmentTypeVO> selectByhospitalSn = adtDAO.selectAlldepartmentType(av.getHcode());
					hashMap.put("selectByhospitalSn", selectByhospitalSn);
					List<AppDepartmentVO> selectdepartment = adDao.selectAlldepartment(av.getHcode(),selectByhospitalSn.get(0).getDepartmentTypeSn());
					hashMap.put("selectdepartment", selectdepartment);
				}
				
			} catch (Exception e) 
			{
				e.printStackTrace();
				json.setJsonData("2", "查询异常");
			}
			json.setJsonData("0", hashMap);
			return json;
		}

		//科室详细介绍
		@Override
		public JsonModel selectdepartmentX(AppDepartmentVO ad, JsonModel json) 
		{
			try {
				AppDepartmentVO departmentx = adDao.selectDepartmentx(ad.getDepartmentId(), ad.getHospitalSn());
				json.setJsonData("0", departmentx);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				json.setJsonData("2", "查询异常");
			}
			return json;
		}
		
		/**
		 * web使用
		 */
		@Override
		public JsonModel selectDepartmentForWeb(AppHospitalVO av,AppDepartmentTypeVO ad, JsonModel json) 
		{
			HashMap<String, Object> hashMap=new HashMap<String, Object>();
			try 
			{
				AppHospitalVO selectbyHospital = hostDAO.selectbyHospital(av.getHcode());
				hashMap.put("hospitalInfo", selectbyHospital);
				
				List<AppDepartmentVO> Tedepartment = adDao.selectdepartment(av.getHcode());
				if(!Tedepartment.isEmpty()){
					AppDepartmentTypeVO app=new AppDepartmentTypeVO();
					app.setDeleteId('0');
					app.setDepartmentTypeSn("1001");
					app.setDepartmentTypeName("特色科室");
					
					//查询特色科室，并自己定义特色科室大类，把所有的特色科室加入特色科室大类中
					List<AppDepartmentVO> tedepartment = adDao.selectdepartment(av.getHcode());
					app.setDeptList(tedepartment);
					//查询所有科室大类，并把特色科室大类加入到列表中
					List<AppDepartmentTypeVO> selectByhospitalSn = adtDAO.selectAlldepartmentType(av.getHcode());
					//List<AppDepartmentTypeVO> deptType_deptList = new ArrayList<AppDepartmentTypeVO>();
					for(AppDepartmentTypeVO dt : selectByhospitalSn){
						List<AppDepartmentVO> alldepartment = adDao.queryAlldepartment(av.getHcode(),dt.getDepartmentTypeSn());
						dt.setDeptList(alldepartment);
						//deptType_deptList.add(dt);
					}
					selectByhospitalSn.add(0, app);
					hashMap.put("deptType_dept", selectByhospitalSn);
				}else{
					List<AppDepartmentTypeVO> selectByhospitalSn = adtDAO.selectAlldepartmentType(av.getHcode());
					//List<AppDepartmentTypeVO> deptType_deptList = new ArrayList<AppDepartmentTypeVO>();
					for(AppDepartmentTypeVO dt : selectByhospitalSn){
						List<AppDepartmentVO> alldepartment = adDao.queryAlldepartment(av.getHcode(),dt.getDepartmentTypeSn());
						dt.setDeptList(alldepartment);
						//deptType_deptList.add(dt);
					}
					hashMap.put("deptType_dept", selectByhospitalSn);
				}
				
			} catch (Exception e) 
			{
				e.printStackTrace();
				json.setJsonData("2", "查询异常");
			}
			json.setJsonData("0", hashMap);
			return json;
		}
}
