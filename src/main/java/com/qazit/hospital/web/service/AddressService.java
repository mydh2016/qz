package com.qazit.hospital.web.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.model.Address;
import com.qazit.hospital.web.model.JsonModel;


public interface AddressService {
	/**
	 * 添加通讯录
	 * @param address Address 实体
	 * @return JsonModel
	 */
	public JsonModel insert(Address address,String dateBirth,JsonModel json);
	/**
	 * 修改模板
	 * @param address
	 * @return JsonModel
	 */
	public JsonModel updateByPrimaryKey(Address address,String dateBirth,JsonModel json);
	/**
	 * 删除模板
	 * @param id
	 * @return JsonModel
	 */
	public JsonModel deleteByPrimaryKey(Integer id,JsonModel json);
	/**
	 * 根据主键查询模板
	 * @param id
	 * @return JsonModel
	 */
	public JsonModel selectByPrimaryKey(Integer id,JsonModel json);
	/**
	 * 根据条件查询模板列表
	 * @param 	Address[
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
	public JsonModel selectForList(Address address,JsonModel json,AbstractPage page);
	public JsonModel selectDepartments(JsonModel json); 
	public JsonModel selectDuties(String departments,JsonModel json); 
	public JsonModel selectTitle(JsonModel json);
	public JsonModel selectUnit(JsonModel json); 
	public HSSFWorkbook exportExcel(String ids, String allSelect,Integer status,List<Integer>methodList);
}
