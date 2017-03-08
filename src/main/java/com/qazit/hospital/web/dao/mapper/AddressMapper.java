package com.qazit.hospital.web.dao.mapper;

import java.util.List;

import com.qazit.hospital.web.model.Address;

public interface AddressMapper {
	/**
	 * 添加联系人
	 * @param address Address 实体
	 * @return
	 */
	public Integer insert(Address address);
	/**
	 * 修改联系人
	 * @param address
	 */
	public void updateByPrimaryKey(Address address);
	/**
	 * 删除模板
	 * @param id
	 */
	public void deleteByPrimaryKey(Integer id);
	/**
	 * 根据主键查询模板
	 * @param id
	 * @return Address
	 */
	public Address selectByPrimaryKey(Integer id);
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
	 * @return List<Address>
	 */
	public List<Address> selectForList(Address address);
	public Long selectCount(Address address);
	public List<String> selectDepartments(); 
	public List<String> selectDuties(String departments); 
	public List<String> selectTitle();
	public List<String> selectUnit(); 
}
