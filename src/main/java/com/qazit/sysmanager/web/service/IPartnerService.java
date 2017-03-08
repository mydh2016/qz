package com.qazit.sysmanager.web.service;

import java.util.List;
import java.util.Map;

import com.qazit.sysmanager.web.model.JsonResultMessage;
import com.qazit.sysmanager.web.model.Partner;
import com.qazit.sysmanager.web.model.TMemDicnPara;
import com.qazit.sysmanager.web.model.User;


public interface IPartnerService {

	/**
	 * 增加或者修改渠道商信息
	 * @param partner 
	 * @param checkedRoleIds
	 * @param curentUserId
	 * @return
	 */
	JsonResultMessage saveOrUpdatePartner(Partner partner,User user);
	
	/**
	 * 
	 * @param partner
	 * @return
	 */
	public JsonResultMessage deletePartner(Long partnerId);
	
	public Partner getPartnerIdById(Long partnerId);
	
	/**
	 * 通过医院ID获得医院编码
	 * @param partnerId 医院ID
	 * @return JsonResultMessage (resultCode表示查询是否成功的状态 0表示成功 非0表示失败  data表示具体返回的查询结果
	 */
	public JsonResultMessage getPartnerNoById(Long partnerId);
	
	/**
	 * 
	 * @param partner
	 * @param curentUserId
	 * @return
	 */
	public Map<String,Object> getPartners(Partner partner);
	
	/**
	 * 判断某个用户所在的渠道有效期是否已经过期
	 * @param userName (userName的规则是 ****@邮箱后缀.com   例如：lvwh@asiainfo-sec.com)
	 * @return
	 */
//	public int getIsExpiry(String userName);
	/**
	 * 获取省市信息
	 * @return
	 */
	public List<Map<String, Object>> provincialInfo();
	/**
	 * 获取医院级别
	 * @return
	 */
	public List<TMemDicnPara> getHospLevel();
}
