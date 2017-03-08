package com.qazit.hospital.web.service;

import com.qazit.hospital.util.AbstractPage;
import com.qazit.hospital.web.model.JsonModel;
import com.qazit.hospital.web.model.TNoDisturb;

public interface NoDisturbService {
	/**
	 * 根据主键删除
	 * @param id
	 * @return
	 */
	public JsonModel deleteByPrimaryKey(Integer id,JsonModel json);
	/**
	 * 保存免打扰
	 * @param noDisturb
	 * @return
	 */
	public JsonModel insertSelective(TNoDisturb noDisturb,JsonModel json);
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	public JsonModel selectByPrimaryKey(Integer id,JsonModel json);
	/**
	 * 查询免打扰
	 * @param example
	 * @return
	 */
	public JsonModel selectByExample(TNoDisturb record,AbstractPage page,JsonModel json);
	/**
	 * 根据主键修改
	 * @param record
	 * @return
	 */
	public JsonModel updateByPrimaryKeySelective(TNoDisturb record,JsonModel json);
}
