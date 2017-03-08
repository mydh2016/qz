package com.qazit.hospital.web.service.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.util.ExportExcel;
import com.qazit.hospital.web.dao.mapper.AddressMapper;
import com.qazit.hospital.web.model.Address;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.service.AddressService;
import com.qazit.sysmanager.web.security.UserSessionOperator;

@Service("addressService")
public class AddressServiceImpl extends BaseService implements AddressService{
	@Autowired
	private AddressMapper addressDAO;
	/**
	 * 添加通讯录联系人
	 * @param Address address 实体
	 * @return JsonModel
	 */
	public JsonModel insert(Address address,String dateBirth,JsonModel json){
		if(address==null){
			json.setJsonData("1", "参数错误");
		}else  if(StringUtils.isBlank(address.getTelphone())){
			json.setJsonData("2", "信息填写不完整");
		}else{
			try {
				Address validateAddress=new Address();
				validateAddress.setTelphone(address.getTelphone());
				validateAddress.setStatus(address.getStatus());
				validateAddress.setHpId(UserSessionOperator.getCurrentHospitalId()+"");
				boolean flag=this.selectIsEXITS(validateAddress);
				if(flag){
					if(StringUtils.isBlank(dateBirth)&&StringUtils.isBlank(address.getDateBirth())){
						address.setDateBirth(null);
					}else if(!StringUtils.isBlank(dateBirth)&&StringUtils.isBlank(address.getDateBirth())){
						SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
						address.setDateBirth(sf.parse(dateBirth));
					}
					address.setCreateTime(new Date(System.currentTimeMillis()));
					address.setState(0);
					address.setCreaterId(UserSessionOperator.getCurrentUserId());
					address.setHpId(UserSessionOperator.getCurrentHospitalId()+"");
					addressDAO.insert(address);
					json.setJsonData("0", address.getId());
				}else{
					json.setJsonData("4", "该联系人已存在");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("3", "保存异常");
			}
			
			
			
		}
		return json;
	};
	/**
	 * 修改通讯录联系人信息
	 * @param address
	 * @return JsonModel
	 */
	public JsonModel updateByPrimaryKey(Address address,String dateBirth,JsonModel json){
		try {
			Address validataAddress=new Address();
			validataAddress.setId(address.getId());
			validataAddress.setTelphone(address.getTelphone());
			boolean flag=this.selectIsEXITS(validataAddress);
			if(flag){
				if(StringUtils.isBlank(dateBirth)){
					address.setDateBirth(null);
				}else{
					SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
					address.setDateBirth(sf.parse(dateBirth));
				}
				addressDAO.updateByPrimaryKey(address);
				json.setJsonData("0", "修改成功");
			}else{
				json.setJsonData("4", "该模板已存在");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "修改数据异常");
		}
		return json;
	};
	/**
	 * 删除
	 * @param id
	 * @return JsonModel
	 */
	public JsonModel deleteByPrimaryKey(Integer id,JsonModel json){
		try {
			addressDAO.deleteByPrimaryKey(id);
			json.setJsonData("0", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "删除数据异常");
		}
		return json;
	};
	/**
	 * 根据主键查询
	 * @param id
	 * @return JsonModel
	 */
	public JsonModel selectByPrimaryKey(Integer id,JsonModel json){
		if(id==null){
			json.setJsonData("1", "参数错误");
		}else{
			try {
				Address address=addressDAO.selectByPrimaryKey(id);
				json.setJsonData("0", address);
			} catch (Exception e) {
				e.printStackTrace();
				json.setJsonData("3", "查询数据异常");
			}
		}
		return json;
	};
	/**
	 * 根据条件查询列表
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
	public JsonModel selectForList(Address address,JsonModel json,AbstractPage page){
		try {
			address.setFirstRecord(page.getFirstRecord());
			address.setPageSize(page.getPageSize());
			address.setHpId(UserSessionOperator.getCurrentHospitalId()+"");
			List<Address> addressList=addressDAO.selectForList(address);
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("dataList", addressList);
			map.put("pageCountAll", this.addressDAO.selectCount(address).longValue());
//			map.put("type", type);
			json.setJsonData("0", map);
			System.out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "查询数据异常");
		}
		return json;
	};
	public JsonModel selectDepartments(JsonModel json){
		try {
			List<String>departments=this.addressDAO.selectDepartments();
			json.setJsonData("0", departments);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "查询异常");
		}
		return json;
	}; 
	public JsonModel selectDuties(String departments,JsonModel json){
		try {
			List<String>duties=this.addressDAO.selectDuties(departments);
			json.setJsonData("0", duties);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "查询异常");
		}
		
		return json;
		
	}; 
	public JsonModel selectTitle(JsonModel json){
		try {
			List<String>titles=this.addressDAO.selectTitle();
			json.setJsonData("0", titles);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "查询异常");
		}
		return json;
	};
	public JsonModel selectUnit(JsonModel json){
		try {
			List<String>units=this.addressDAO.selectUnit();
			json.setJsonData("0", units);
		} catch (Exception e) {
			e.printStackTrace();
			json.setJsonData("3", "查询异常");
		}
		return json;
	};
	public HSSFWorkbook exportExcel(String ids, String allSelect,Integer status,List<Integer>methodList){
		try {
			if(ids==null&&(StringUtils.isBlank(ids))){
			    return null;
			    
			}
			if("0".equals(allSelect)){
					String [] idArray=ids.split(",");
					List<Address>list=new ArrayList<Address>();
					for (int i = 0; i < idArray.length; i++) {
						Address address=this.addressDAO.selectByPrimaryKey(Integer.parseInt(idArray[i]));
						list.add(address);
					}
					return export(status, list,methodList);
			}else{
					Address address=new Address();
					address.setStatus(status);
					List<Address>list=this.addressDAO.selectForList(address);
					return export(status, list,methodList);
			}
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | IOException e) {
			e.printStackTrace();
			return null;
		}
	};
	public HSSFWorkbook export(Integer status,List<Address>list,List<Integer>methodList) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException{
		ExportExcel export=new ExportExcel();
		List<String>headList=new ArrayList<String>();
		headList.add("姓名");
		headList.add("性别");
		headList.add("手机号码");
		headList.add("出生日期");
		headList.add("科室");
		headList.add("职务");
		headList.add("职称");	
		headList.add("单位");
		headList.add("地址");
		headList.add("内外院");
		return export.export(headList, list,methodList);
	}
	/**
	 * 验重
	 * @param address
	 * @return boolean
	 */
	public boolean selectIsEXITS(Address address){
		List<Address> AddressList=this.addressDAO.selectForList(address);
		if(AddressList==null || AddressList.isEmpty()){
			return true;
		}
		return false;
	}
	/**
	 * 日期格式化
	 * @return String
	 */
//	public String formateTime(){
//		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmm");
//		Date date=new Date(System.currentTimeMillis());
//		return sf.format(date);
//	}
//	public static void main(String[] args) {
//		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmm");
//		Date date=new Date(System.currentTimeMillis());
//		System.out.println(sf.format(date));
//	}
}
