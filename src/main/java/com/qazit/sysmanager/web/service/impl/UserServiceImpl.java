package com.qazit.sysmanager.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.qazit.hospital.web.dao.mapper.DepartmentMapper;
import com.qazit.hospital.web.model.DepartmentWithBLOBs;
import com.qazit.sysmanager.util.CommonSqlSeacher;
import com.qazit.sysmanager.util.DateUtil;
import com.qazit.sysmanager.util.MD5Utils;
import com.qazit.sysmanager.util.StaticValue;
import com.qazit.sysmanager.web.dao.mapper.UserMapper;
import com.qazit.sysmanager.web.dao.mapper.UserRoleMapper;
import com.qazit.sysmanager.web.model.JsonResultMessage;
import com.qazit.sysmanager.web.model.User;
import com.qazit.sysmanager.web.model.UserExample;
import com.qazit.sysmanager.web.model.UserRole;
import com.qazit.sysmanager.web.model.UserRoleExample;
import com.qazit.sysmanager.web.model.UserRoleKey;
import com.qazit.sysmanager.web.security.UserSessionOperator;
import com.qazit.sysmanager.web.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	private static String SUCCESS = "ok!";
	private static String USER_REP = "用户名重复！";
	@Resource
	private UserMapper userMapper;
	@Resource
	private UserRoleMapper userRoleMapper;
	@Resource
	private DepartmentMapper  departmentMapper;
	
	/**
	 * 验证用户名唯一性
	 * @param thisUserMapper
	 * @param userName
	 * @return
	 */
	public boolean checkUserUniq(UserMapper thisUserMapper,String userName){
		boolean flag = false;
		String HospitalId=UserSessionOperator.getCurrentUser().getHospitalId();
		try{
			UserExample example = new UserExample();
			com.qazit.sysmanager.web.model.UserExample.Criteria criteria = example.createCriteria();
			criteria.andUserNameEqualTo(userName);
			criteria.andHospitalIdEqualTo(HospitalId);
			criteria.andIsDeletedEqualTo(StaticValue.IS_DELETED_NO);
			int count = thisUserMapper.countForUser(example);
			if(count==0){
				flag=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 
	 * @param user
	 * @param jsonResultMessage
	 * @param thisUserMapper
	 * @return
	 */
	private JsonResultMessage check(User user,JsonResultMessage jsonResultMessage,UserMapper thisUserMapper){
		if(user.getUserName()==null||"".equals(user.getUserName())){
			jsonResultMessage.setJsonData("1", "用户名不能为空");
			return jsonResultMessage;
		}
		if(user.getUserId()==null||user.getUserId()==0){
			if(user.getPassword()==null||"".equals(user.getPassword())){
				jsonResultMessage.setJsonData("1", "密码不能为空");
				return jsonResultMessage;
			}
		}
		if(UserSessionOperator.isSupperAdmin()){
			user.setDepartmentId(StaticValue.departmentId);
		}else{
			if(user.getDepartmentId()==null||"".equals(user.getDepartmentId())){
				jsonResultMessage.setJsonData("1", "科室不能为空");
				return jsonResultMessage;
			}
		}
		
		
		if(jsonResultMessage.getResultCode()==null){
			//如果是修改用户信息的时候对用户名进行了修改，则需要进行用户名唯一性检验
			if(!user.getUserName().equals(user.getOldUserName())){
				//判断用户名是否唯一
				boolean flag = checkUserUniq(this.userMapper,user.getUserName());
				if(!flag){
					jsonResultMessage.setJsonData("1", "该用户名已经被使用，请重新输入");
					return jsonResultMessage;
				}
			}
		}
		jsonResultMessage.setJsonData("0", "check ok");
		return jsonResultMessage;
	}
	
	public JsonResultMessage saveOrUpdateUser(User user, String checkedRoleIds) {
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		long userId = 0;
		try {
			check(user,jsonResultMessage,this.userMapper);
			long curentUserId =  UserSessionOperator.getCurrentUserId();
			String hospitalId = String.valueOf(UserSessionOperator.getCurrentHospitalId());
			user.setHospitalId(hospitalId);
			user.setCreateTime(new Date());
			user.setCreateUserId(curentUserId);
			user.setCreateTime(new Date());
			if (user.getUserId() == null || user.getUserId() == 0) {
				user.setIsAdmin(0);
				user.setPassword(MD5Utils.hash(user.getPassword()));
				this.userMapper.insert(user);
			} else {
				this.userMapper.updateByPrimaryKeySelective(user);
				this.deleteUserRoles(user.getUserId());// 删除用户角色关联关系
				user.getUserId();
			}
			userId = user.getUserId();
			if (checkedRoleIds != null && checkedRoleIds.length() > 0) {
//				userId = user.getUserId();
				List<UserRole> userRoleList = new ArrayList<UserRole>();
				String[] checkValue = checkedRoleIds.split(",");
				if (checkValue != null && checkValue.length > 0) {
					for (String roleId : checkValue) {
						UserRole rUserRole = new UserRole();
						rUserRole.setUserId(userId);
						rUserRole.setRoleId(Integer.valueOf(roleId));
						rUserRole.setHospitalId(user.getHospitalId());
						userRoleList.add(rUserRole);
						this.userRoleMapper.insert(rUserRole);
					}
				}
//				this.userRoleMapper.insertUserRoleList(userRoleList);
			}
		} catch (DuplicateKeyException e) {
			// username 唯一性约束
			jsonResultMessage.setJsonData("1", USER_REP);
			return jsonResultMessage;
		}
		jsonResultMessage.setJsonData("0", SUCCESS);
		return jsonResultMessage;
	}


	@Override
	public void deleteUserRoles(long userId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUserIdEqualTo(userId);
		this.userRoleMapper.deleteByExample(example);
	}
	
	@Override
	public JsonResultMessage deleteUser(User user){
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		try{
			long delId = UserSessionOperator.getCurrentUserId();
			if(user.getUserId()==delId){
				jsonResultMessage.setJsonData("1", "当前用户不能删除自己的信息");
				return jsonResultMessage;
			}else{
//				//删除角色信息
//				this.deleteUserRoles(user.getUserId());
//				//删除用户信息(这里删除应该改为假删除)
//				this.userMapper.deleteByPrimaryKey(user.getUserId());
				user.setIsDeleted(StaticValue.UN_AVAILABLE);
				user.setDeleteTime(new Date());
				user.setDeleteUserId(Integer.valueOf(String.valueOf(delId)));//删除者ID
				this.userMapper.updateByPrimaryKeySelective(user);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			jsonResultMessage.setJsonData("1", "删除失败");
		}
		jsonResultMessage.setJsonData("0", "ok");
		return jsonResultMessage;
	}
	
	
	/**
	 * 查询用户
	 * @param user
	 * @param curentUserId
	 * @return
	 */
	public Map<String,Object> getUsers(User user){
		User currUser = UserSessionOperator.getCurrentUser();
		long currUserId = currUser.getUserId();
		
		Map<String,Object> map = new HashMap<String,Object>();
		int totalCount = 0;
		UserExample example = new UserExample();
		com.qazit.sysmanager.web.model.UserExample.Criteria criteria = example.createCriteria();
		if(user.getUserName() !=null && !user.getUserName().trim().isEmpty()){
			criteria.andUserNameLike(CommonSqlSeacher.getLikePreAndAfterStr(user.getUserName()));
		}
		if(user.getEmail() !=null && !user.getEmail().trim().isEmpty()){
			criteria.andEmailLike(CommonSqlSeacher.getLikePreAndAfterStr(user.getEmail()));
		}
		if(user.getMobilePhone() !=null && !user.getMobilePhone().trim().isEmpty()){
			criteria.andMobilePhoneLike(CommonSqlSeacher.getLikePreAndAfterStr(user.getMobilePhone()));
		}
		
		//查询未删除的数据
		criteria.andIsDeletedEqualTo(0);
		
		if(user.getDateStart() != null && !"".equals(user.getDateStart())){
			Date startDate = DateUtil.parseDate(user.getDateStart());
			criteria.andCreateTimeGreaterThanOrEqualTo(startDate);
		}
		if(user.getDateEnd() != null && !"".equals(user.getDateEnd())){
			Date endDate = DateUtil.parseDate(user.getDateEnd());
			criteria.andCreateTimeLessThan(DateUtils.addDays(endDate, 1));
		}
		//超级运营管理员 只能看到他自己创建的医院信息
		//管理员能看到自己医院的所有信息，普通用户只能看到自己创建的信息
		if(UserSessionOperator.isSupperAdmin()){
			criteria.andCreateUserIdEqualTo(currUserId);
		}else{
			criteria.andHospitalIdEqualTo(String.valueOf(UserSessionOperator.getCurrentHospitalId()));
			if(!UserSessionOperator.isAdmin()){//普通用户只能看自己创建的信息
				criteria.andCreateUserIdEqualTo(currUserId);
			}
		}
		
		//管理的部门信息如何显示
		if( user.isPage()){
			totalCount = this.userMapper.countByExample(example);
			user.setTotalCount(totalCount);
			example.setOrderByClause("create_time desc limit "+user.getFirst()+","+user.getPageSize());
			map.put("dataList", this.userMapper.selectByExample(example));
		}else{
			example.setOrderByClause("create_time desc");
			map.put("dataList", this.userMapper.selectByExample(example));
		}
		map.put("pageCountAll", totalCount);
		return map;
		
	}
	
	/**
	 * 修改密码
	 * @param userid
	 * @param oldPassword
	 * @param newPassword
	 */
	public JsonResultMessage updatePassword(long userid, String oldPassword, String newPassword ){
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		User user = this.getUserById(userid);
		if (user == null) {
			jsonResultMessage.setJsonData("1", "用户不存在");
			return jsonResultMessage;
		}
		
		String oldPwd = MD5Utils.hash(oldPassword);
		if( !user.getPassword().equals(oldPwd)){
			jsonResultMessage.setJsonData("2", "原密码输入不对！");
			return jsonResultMessage;
		}
		String password = MD5Utils.hash(newPassword);
		user.setPassword(password);
		userMapper.updateByPrimaryKey(user);
		jsonResultMessage.setJsonData("0", SUCCESS);
		return jsonResultMessage;
	}
	
	@Override
	public User getUserById(long userid) {
		User user = userMapper.selectByPrimaryKey(userid);
		if(!(user.getIsAdmin()==1)&&!StaticValue.SUPER_HOSPITAL_ID.equals(user.getHospitalId())){//管理员用户没有科室名称。HospitalId为asiainfo的超级运营人员也没有科室名称
			//根据departmentId查询当前用户科室名称
			DepartmentWithBLOBs DepartmentWithBLOBs = departmentMapper.selectByPrimaryKey(user.getDepartmentId());
			user.setDepartmentName(DepartmentWithBLOBs.getDepartmentName());
		}
		return user;
	}
	
	public int updateByPrimaryKeySelective(User record){
		return userMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * @method	selectByUserId
	 * @description 获取用户id所关联的所有角色id   
	 * @return	List
	 */
	public  List<Integer> selectRoleIdsByUserId(long userId){
		UserRoleExample rUserRoleExample = new UserRoleExample();
		rUserRoleExample.createCriteria().andUserIdEqualTo(userId);
		List<UserRole> userRoleList = userRoleMapper.selectByExample(rUserRoleExample);
		List<Integer> userRoleIds = new ArrayList<Integer>();
		for(UserRoleKey rUserRoleKey : userRoleList){
			userRoleIds.add(rUserRoleKey.getRoleId());
		}
		return userRoleIds;
		
	}
	
	@Override
	public List<User> getAllUsers(User user){
		UserExample example = new UserExample();
		com.qazit.sysmanager.web.model.UserExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(StaticValue.AVAILABLE);
		criteria.andHospitalIdEqualTo(user.getHospitalId());
		int isAdmin = user.getIsAdmin();
		//如果是非超级管理员用户，只能查询该渠道下，该用户创建的子用户信息
		if(isAdmin!=1){
			criteria.andCreateUserIdEqualTo(user.getUserId());
		}
		return userMapper.selectByExample(example);
	}
	
	
	@Override
	public List<User> getAllUsers() {
		UserExample example = new UserExample();
		example.createCriteria().andIsDeletedEqualTo(StaticValue.AVAILABLE);
		return userMapper.selectByExample(example);
	}
}
