package com.qazit.sysmanager.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import com.qazit.sysmanager.util.CommonSqlSeacher;
import com.qazit.sysmanager.util.DateUtil;
import com.qazit.sysmanager.util.MD5Utils;
import com.qazit.sysmanager.util.StaticValue;
import com.qazit.sysmanager.web.dao.mapper.HatAreaMapper;
import com.qazit.sysmanager.web.dao.mapper.HatCityMapper;
import com.qazit.sysmanager.web.dao.mapper.HatProvinceMapper;
import com.qazit.sysmanager.web.dao.mapper.PartnerMapper;
import com.qazit.sysmanager.web.dao.mapper.TMemDicnParaMapper;
import com.qazit.sysmanager.web.dao.mapper.UserMapper;
import com.qazit.sysmanager.web.model.HatArea;
import com.qazit.sysmanager.web.model.HatAreaExample;
import com.qazit.sysmanager.web.model.HatCity;
import com.qazit.sysmanager.web.model.HatCityExample;
import com.qazit.sysmanager.web.model.HatProvince;
import com.qazit.sysmanager.web.model.HatProvinceExample;
import com.qazit.sysmanager.web.model.JsonResultMessage;
import com.qazit.sysmanager.web.model.Partner;
import com.qazit.sysmanager.web.model.PartnerExample;
import com.qazit.sysmanager.web.model.TMemDicnPara;
import com.qazit.sysmanager.web.model.TMemDicnParaExample;
import com.qazit.sysmanager.web.model.User;
import com.qazit.sysmanager.web.security.UserSessionOperator;
import com.qazit.sysmanager.web.service.IPartnerService;

@Service
public class PartnerServiceImpl implements IPartnerService {

	private static String SUCCESS = "ok!";
	private static String USER_REP = "医院名重复！";
	@Resource
	private PartnerMapper partnerMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private HatAreaMapper hatAreaMapper;
	@Resource
	private HatCityMapper hatCityMapper;
	@Resource
	private HatProvinceMapper hatProvinceMapper;
	@Resource
	private TMemDicnParaMapper tMemDicnParaMapper;
	

	public JsonResultMessage saveOrUpdatePartner(Partner partner, User user) {
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		try {
			// 参数校验
			check(partner, this.partnerMapper,user, jsonResultMessage);

			if ("0".equals(jsonResultMessage.getResultCode())) {
				Long currentUserId = UserSessionOperator.getCurrentUserId();
				if (UserSessionOperator.isSupper()) {// 医院管理员创建的医院。医院管理员不能维护医院编号。
					partner.setHospitalNo(UserSessionOperator.getCurrentHospitalNo());
				}
				partner.setStatus(1);
				partner.setCreaterUser(currentUserId);
				partner.setCreateTime(new Date());
				
				if ( partner.getId() == null||partner.getId()==0) {// 新增医院
					this.partnerMapper.insert(partner);
					
					// 如果当前用户是运营超级管理员，才可以建立医院管理员账号
					if (UserSessionOperator.isSupperAdmin()) {
						// 创建用户信息
						user.setPassword(MD5Utils.hash(user.getPassword()));
						user.setIsAdmin(StaticValue.IS_ADMIN);
						long curentUserId = UserSessionOperator
								.getCurrentUserId();
						//保存医院ID
						user.setHospitalId(String.valueOf(partner.getId()));
						user.setDepartmentId(StaticValue.departmentId);
						user.setCreateTime(new Date());
						user.setCreateUserId(curentUserId);
						user.setIsDeleted(0);
						this.userMapper.insert(user);
					}
					
				} else {
					this.partnerMapper.updateByPrimaryKeySelective(partner);
				}
				
				
				jsonResultMessage.setJsonData("0", SUCCESS);
			}

		} catch (Exception e) {
			e.printStackTrace();
			jsonResultMessage.setJsonData("1", "保存医院信息出错");
			return jsonResultMessage;
		}
		return jsonResultMessage;
	}

	/**
	 * 字段信息是否符合条件校验
	 * 
	 * @param partner
	 * @param partnerMapperForCheck
	 * @param jsonResultMessage
	 * @return
	 */
	private JsonResultMessage check(Partner partner,
			PartnerMapper partnerMapperForCheck,User user,
			JsonResultMessage jsonResultMessage) {
		// 进行参数判断
		if (partner.getCompanyName() == null
				|| "".equals(partner.getCompanyName())) {
			// username 唯一性约束
			jsonResultMessage.setJsonData("1", "医院名称不能为空");
			return jsonResultMessage;
		}
		
		//只有超级管理员才能维护医院编号
		if (partner.getHospitalNo() == null || "".equals(partner.getHospitalNo())) {
			// username 唯一性约束
			jsonResultMessage.setJsonData("1", "医院编号不能为空");
			return jsonResultMessage;
		}
		// 新增医院
		if (partner.getId() == null || partner.getId() == 0) {
			// 用户名唯一性校验
			if (!isUnique(partner, 0, "companyName", partnerMapperForCheck)) {
				jsonResultMessage.setJsonData("1", "医院名称重复");
				return jsonResultMessage;
			}
			if(UserSessionOperator.isSupperAdmin()){//超级管理员需要判断医院编号是否重复
				// 医院编号唯一性校验
				if (!isUnique(partner, 0, "hospitalNo", partnerMapperForCheck)) {
					jsonResultMessage.setJsonData("1", "医院编号重复");
					return jsonResultMessage;
				}
			}
			
			
			//如果是超级管理员用户，账号和密码不能为空
			if (UserSessionOperator.isSupperAdmin()) {
				if (StringUtils.isBlank(user.getUserName())){
					jsonResultMessage.setJsonData("1", "用户名不能为空");
					return jsonResultMessage;
				}
				if(StringUtils.isBlank(user.getPassword())) {
					jsonResultMessage.setJsonData("1", "密码不能为空");
					return jsonResultMessage;
				}
			}
			
			// 更新医院信息
		} else {
			// 如果用户名和医院编号，没有改变
			if (partner.getCompanyName().equals(partner.getOldCompanyName())) {
				// 用户名唯一性校验
				if (!isUnique(partner, 1, "companyName", partnerMapperForCheck)) {
					jsonResultMessage.setJsonData("1", "医院名称重复");
					return jsonResultMessage;
				}
			} else {
				// 用户名唯一性校验
				if (!isUnique(partner, 0, "companyName", partnerMapperForCheck)) {
					jsonResultMessage.setJsonData("1", "医院名称重复");
					return jsonResultMessage;
				}
			}

			if (partner.getHospitalNo().equals(partner.getOldHospitalNo())) {
				// 医院编号唯一性校验
				if (!isUnique(partner, 1, "hospitalNo", partnerMapperForCheck)) {
					jsonResultMessage.setJsonData("1", "医院编号重复");
					return jsonResultMessage;
				}
			} else {
				// 医院编号唯一性校验
				if (!isUnique(partner, 0, "hospitalNo", partnerMapperForCheck)) {
					jsonResultMessage.setJsonData("1", "医院编号重复");
					return jsonResultMessage;
				}
			}
		}
		
		jsonResultMessage.setResultCode("0");
		return jsonResultMessage;
	}

	/**
	 * 字段唯一性校验
	 * 
	 * @param partner
	 * @param count
	 * @param type
	 * @param partnerMapperForCheck
	 * @return
	 */
	private boolean isUnique(Partner partner, int count, String type,
			PartnerMapper partnerMapperForCheck) {
		boolean flag = false;
		PartnerExample example = new PartnerExample();

		com.qazit.sysmanager.web.model.PartnerExample.Criteria criteria = example.createCriteria();
		if("companyName".equals(type)){
			if(partner.getCompanyName() !=null && !partner.getCompanyName().trim().isEmpty()){
				criteria.andCompanyNameEqualTo(partner.getCompanyName());
			}
		}else if("hospitalNo".equals(type)){
			if(partner.getHospitalNo() !=null && !partner.getHospitalNo().trim().isEmpty()){
				criteria.andHospitalNoEqualTo(partner.getHospitalNo());
			}
		}
		// StaticValue.IS_DELETED_NO

		int thisCount = partnerMapperForCheck.countByExample(example);
		if (count == thisCount) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 查询用户
	 * 
	 * @param user
	 * @param curentUserId
	 * @return
	 */
	public Map<String, Object> getPartners(Partner partner) {
		long curentUserId = UserSessionOperator.getCurrentUserId();
		Map<String, Object> map = new HashMap<String, Object>();
		int totalCount = 0;
		PartnerExample example = new PartnerExample();
		com.qazit.sysmanager.web.model.PartnerExample.Criteria criteria = example
				.createCriteria();
		criteria.andIsDeletedEqualTo(StaticValue.AVAILABLE);
		if (partner.getCompanyName() != null
				&& !partner.getCompanyName().trim().isEmpty()) {
			criteria.andCompanyNameLike(CommonSqlSeacher
					.getLikePreAndAfterStr(partner.getCompanyName()));
		}
		// if(partner.getEmail() !=null &&
		// !partner.getEmail().trim().isEmpty()){
		// criteria.andEmailLike(CommonSqlSeacher.getLikePreAndAfterStr(partner.getEmail()));
		// }
		// if(partner.getMobilephone() !=null &&
		// !partner.getMobilephone().trim().isEmpty()){
		// criteria.andMobilephoneLike(CommonSqlSeacher.getLikePreAndAfterStr(partner.getMobilephone()));
		// }
		// if(partner.getStatus() != null ){
		// criteria.andStatusEqualTo(partner.getStatus());
		// }
		//		
		if (partner.getDateStart() != null
				&& !"".equals(partner.getDateStart())) {
			Date startDate = DateUtil.parseDate(partner.getDateStart());
			criteria.andCreateTimeGreaterThanOrEqualTo(startDate);
		}
		if (partner.getDateEnd() != null && !"".equals(partner.getDateEnd())) {
			Date endDate = DateUtil.parseDate(partner.getDateEnd());
			criteria.andCreateTimeLessThan(DateUtils.addDays(endDate, 1));
		}
		// 超级运营管理员 只能看到他自己创建的医院信息
		// 管理员能看到自己医院的所有信息，普通用户只能看到自己创建的信息
		if (UserSessionOperator.isSupperAdmin()) {
			criteria.andCreaterUserEqualTo(curentUserId);
		} else {
			criteria.andHospitalNoEqualTo(UserSessionOperator.getCurrentHospitalNo());
			if (!UserSessionOperator.isAdmin()) {// 普通用户只能看自己创建的信息
				criteria.andCreaterUserEqualTo(curentUserId);
			}
		}

		if (partner.isPage()) {
			totalCount = this.partnerMapper.countByExample(example);
			partner.setTotalCount(totalCount);
			example.setOrderByClause("create_time desc limit "
					+ partner.getFirst() + "," + partner.getPageSize());
			map.put("dataList", this.partnerMapper.selectByExample(example));
		} else {
			example.setOrderByClause("createdtime desc");
			map.put("dataList", this.partnerMapper.selectByExample(example));
		}
		map.put("pageCountAll", totalCount);
		return map;

	}

//	@Override
//	public int getIsExpiry(String userName) {
//		// TODO Auto-generated method stub
//		// 获得该用户的ssid
//		if (userName != null) {
//			int test = userName.indexOf("@");
//			String tempStr = userName.substring(test + 1);
//			System.out.println(tempStr);
//			if (tempStr != null) {
//				int test1 = tempStr.indexOf(".");
//				String tempStr1 = tempStr.substring(0, test1);
//				System.out.println(tempStr1);
//			}
//			// 从缓存或者数据库中查看该用户所在的渠道是否已经过期
//
//		}
//		return 0;
//	}

//	public static void main(String args[]) {
//		System.out.println(new PartnerServiceImpl()
//				.getIsExpiry("lvw@asiain.com"));
//	}
	@Override
	public JsonResultMessage deletePartner(Long partnerId) {
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		try{
			//如果当前用户属于该医院，则该用户不能删除该医院
			if(partnerId!=null&&partnerId.toString().equals(UserSessionOperator.getCurrentUser().getHospitalId())){
				jsonResultMessage.setJsonData("1", "该用户权限不足，不能删除自己所属于的医院");
			}else{
//				this.partnerMapper.deleteByPrimaryKey(partnerId);
				Partner partner  = new Partner();
				partner.setId(partnerId);
				partner.setIsDeleted(StaticValue.UN_AVAILABLE);
				this.partnerMapper.updateByPrimaryKeySelective(partner);
				jsonResultMessage.setJsonData("0", "ok");
			}
		}catch(Exception e){
			e.printStackTrace();
			jsonResultMessage.setJsonData("1", "删除数据出错，请重试");
		}
		return jsonResultMessage;
	}

	@Override
	public Partner getPartnerIdById(Long partnerId) {
		return this.partnerMapper.selectByPrimaryKey(partnerId);
	}

	@Override
	public List<Map<String, Object>> provincialInfo() {
		try {
			List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
			// 查询出所有的县
			List<HatProvince> provinces = hatProvinceMapper
					.selectByExample(new HatProvinceExample());
			for (HatProvince province : provinces) {
				Map<String, Object> provinceMap = new HashMap<String, Object>();
				provinceMap.put("province", province.getProvince());
				provinceMap.put("provinceId", province.getProvinceid());
				HatCityExample ce = new HatCityExample();
				ce.createCriteria().andFatherEqualTo(province.getProvinceid());
				List<HatCity> citys = hatCityMapper.selectByExample(ce);
				List<Map<String, Object>> cityList = new ArrayList<Map<String, Object>>();
				if (!citys.isEmpty()) {
					for (HatCity city : citys) {
						Map<String, Object> cityMap = new HashMap<String, Object>();
						cityMap.put("city", city.getCity());
						cityMap.put("cityId", city.getCityid());
						HatAreaExample hae = new HatAreaExample();
						hae.createCriteria().andFatherEqualTo(city.getCityid());
						List<HatArea> areas = hatAreaMapper
								.selectByExample(hae);
						cityMap.put("areas", areas);
						cityList.add(cityMap);
					}
				}
				provinceMap.put("citys", cityList);
				resList.add(provinceMap);
			}
			return resList;

		} catch (Exception e) {
			return null;
		}

	}
	@Override
	public JsonResultMessage getPartnerNoById(Long partnerId) {
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		try{
			Partner partner = this.partnerMapper.selectByPrimaryKey(partnerId);
			String hospitalNo =partner.getHospitalNo();
			jsonResultMessage.setJsonData("0", hospitalNo);
		}catch(Exception e){
			e.printStackTrace();
			jsonResultMessage.setJsonData("50", "查询失败");
		}
		return jsonResultMessage;
	}
	@Override
	public List<TMemDicnPara> getHospLevel() {
		try {
			TMemDicnParaExample tpe = new TMemDicnParaExample();
			tpe.createCriteria().andDicnTypeCodeEqualTo("hosp_level");
			List<TMemDicnPara> list = tMemDicnParaMapper.selectByExample(tpe);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
