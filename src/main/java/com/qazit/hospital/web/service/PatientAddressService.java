package com.qazit.hospital.web.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.PatientAddress;


public interface PatientAddressService {
	/**
	 * 根据主键删除
	 * @param id
	 * @return
	 */
	public JsonModel deleteByPrimaryKey(Integer id,JsonModel json);
	/**
	 * 插入患者通讯录
	 * @param record
	 * @return
	 */
	public JsonModel insertSelective(PatientAddress record,String dateBirth,JsonModel json);
	/**
	 * 根据主键查询患者通讯录
	 * @param id
	 * @return
	 */
	public JsonModel selectByPrimaryKey(Integer id,JsonModel json);
	/**
	 * 查询患者疾病类型
	 * @return
	 */
	public JsonModel selectCategory(JsonModel json);
	/**
	 * 查询患者通讯录
	 * @param example
	 * @return
	 */
	public JsonModel selectByExample(PatientAddress record,String look,String beginTime,String endTime,AbstractPage page,JsonModel json);
	/**
	 * 根据主键修改患者信息
	 * @param record
	 * @return
	 */
	public JsonModel updateByPrimaryKeySelective(PatientAddress record,String dateBirth,JsonModel json);
	public HSSFWorkbook exportExcel(String ids, String allSelect,Integer status,List<Integer>methodList);
}
