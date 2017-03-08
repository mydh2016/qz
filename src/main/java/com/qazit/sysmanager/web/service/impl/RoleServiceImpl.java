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
import org.springframework.transaction.annotation.Transactional;

import com.qazit.sysmanager.util.CommonSqlSeacher;
import com.qazit.sysmanager.util.DateUtil;
import com.qazit.sysmanager.util.StaticValue;
import com.qazit.sysmanager.web.dao.mapper.RoleMapper;
import com.qazit.sysmanager.web.dao.mapper.RolePermissionMapper;
import com.qazit.sysmanager.web.dao.mapper.UserRoleMapper;
import com.qazit.sysmanager.web.model.JsonResultMessage;
import com.qazit.sysmanager.web.model.Role;
import com.qazit.sysmanager.web.model.RoleExample;
import com.qazit.sysmanager.web.model.RolePermission;
import com.qazit.sysmanager.web.model.RolePermissionExample;
import com.qazit.sysmanager.web.model.RolePermissionKey;
import com.qazit.sysmanager.web.model.User;
import com.qazit.sysmanager.web.model.UserRole;
import com.qazit.sysmanager.web.model.UserRoleExample;
import com.qazit.sysmanager.web.model.UserRoleKey;
import com.qazit.sysmanager.web.security.UserSessionOperator;
import com.qazit.sysmanager.web.service.IRoleService;

@Service("roleServiceImpl")
public class RoleServiceImpl implements IRoleService {
	@Resource
	private RoleMapper roleDAOImpl;
	@Resource
	private UserRoleMapper userRoleDAOImpl;
	@Resource
	private RolePermissionMapper rRolePermissionMapper;

	
	/**
	 * @method roleId
	 * @description 获取角色id所关联的所有用户的id
	 * @return List<Long>
	 */
	public List<Long> selectUserIdsByRoleId(int roleId) {
		UserRoleExample rUserRoleExample = new UserRoleExample();
		rUserRoleExample.createCriteria().andRoleIdEqualTo(roleId);
		List<UserRole> userRoleList = userRoleDAOImpl
				.selectByExample(rUserRoleExample);
		List<Long> roleUserIds = new ArrayList<Long>();
		if (userRoleList != null && userRoleList.size() > 0) {
			for (UserRoleKey rUserRoleKey : userRoleList) {
				roleUserIds.add(rUserRoleKey.getUserId());
			}
		}
		return roleUserIds;

	}

	/**
	 *根据角色id和资源类型id获取资源id
	 */
	public List<Integer> selectPermissionIdsByRoleIdAndResType(int roleId,
			int resourcetypeid) {
		RolePermissionExample rolePermissionExample = new RolePermissionExample();
		rolePermissionExample.createCriteria().andRoleIdEqualTo(roleId)
				.andResourceTypeIdEqualTo(resourcetypeid);
		List<Integer> rolePermissionIds = new ArrayList<Integer>();
		List<RolePermission> rolePermissionKeyList = rRolePermissionMapper
				.selectByExample(rolePermissionExample);
		if (rolePermissionKeyList != null && rolePermissionKeyList.size() > 0) {
			for (RolePermissionKey rp : rolePermissionKeyList) {
				rolePermissionIds.add(rp.getResourceId());
			}
		}
		return rolePermissionIds;
	}

	/**
	 * @method addRole
	 * @description 保存角色菜单权限
	 * @param operator
	 * @param role
	 */
	public int saveRoleMenuPerm(Integer roleId, String permissionIds) {
		int flag = 0;
		if (roleId != null && roleId != 0) {
			// 删除角色菜单权限关联关系
			RolePermissionExample rolePermissionExample = new RolePermissionExample();
			rolePermissionExample.createCriteria().andRoleIdEqualTo(roleId);
			rRolePermissionMapper.deleteByExample(rolePermissionExample);

			// 角色菜单权限表关系插入
			if (permissionIds != null && permissionIds.length() > 0) {
				List<RolePermissionKey> rolePermList = new ArrayList<RolePermissionKey>();
				String[] permissionIdsArray = permissionIds.split(",");
				RolePermissionKey rolePermissionKey = null;
				if (permissionIdsArray != null && permissionIdsArray.length > 0) {
					for (String str : permissionIdsArray) {
						// String[] strArray = str.split("_"); //
						// 数据下标0是资源类型,下标1是资源id
						rolePermissionKey = new RolePermissionKey();
						rolePermissionKey.setRoleId(roleId);
						rolePermissionKey.setResourceId(Integer.valueOf(str));
						rolePermissionKey.setResourceTypeId(1);
						rolePermList.add(rolePermissionKey);
					}
//					flag = rRolePermissionMapper
//							.insertRolePermissionList(rolePermList);
				}

			}
		}
		return flag;
	}

	@Override
	@Transactional
	public void deleteRole(Role role) {
		// if(!this.deleteRoleCheck(role.getRoleId())){
		// throw new AuthException("有用户属于该角色，不能删除。");
		// }
		// 删除角色时暂时不删除关联表
		UserRoleExample rUserRoleExample = new UserRoleExample();
		rUserRoleExample.createCriteria().andRoleIdEqualTo(role.getRoleId());
		userRoleDAOImpl.deleteByExample(rUserRoleExample);
		RolePermissionExample exam = new RolePermissionExample();
		exam.createCriteria().andRoleIdEqualTo(role.getRoleId());
		this.rRolePermissionMapper.deleteByExample(exam);
		this.roleDAOImpl.updateByPrimaryKeySelective(role);
	}

	@Override
	public Role getRole(int roleId) {
		return roleDAOImpl.selectByPrimaryKey(roleId);
	}
	
	
	/**
	 * 获得当前(HospitalId)渠道下的所有角色信息
	 * @param HospitalId
	 * @return
	 * @author leon.lv
	 */
	@Override
	public List<Role> getAllRoleList(String hospitalId){
		RoleExample example = new RoleExample();
		com.qazit.sysmanager.web.model.RoleExample.Criteria criteria = example
		.createCriteria();
		criteria.andHospitalIdEqualTo(hospitalId);
		criteria.andIsDeletedEqualTo(StaticValue.AVAILABLE);
		example.setOrderByClause("role_id");
		return this.roleDAOImpl.selectByExample(example);
	}
	
//	@Override
//	public List<Role> getRoles(long currentUserId) {
//		if (currentUserId == StaticValue.SUPPER_USER_ID) {
//			return getAllRoles();
//		}
////		return roleDAOImpl.getRolesByUserId(currentUserId,
////				StaticValue.AVAILABLE);
//		return null;
//	}

	@Override
	public List<Role> getAllRoles() {
		RoleExample example = new RoleExample();
		example.setOrderByClause("role_id");
		example.createCriteria().andIsDeletedEqualTo(StaticValue.AVAILABLE);
		return this.roleDAOImpl.selectByExample(example);
	}

	@Override
	public Map<String, Object> getRoles(Role role,User currUser) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		RoleExample example = new RoleExample();
		int totalCount = 0;
		com.qazit.sysmanager.web.model.RoleExample.Criteria criteria = example
				.createCriteria();
		criteria.andIsDeletedEqualTo(StaticValue.AVAILABLE);
		if (role.getRoleName() != null && !"".equals(role.getRoleName())) {
			criteria.andRoleNameLike(CommonSqlSeacher
					.getLikePreAndAfterStr(role.getRoleName()));
		}
		
		String hospitalId = currUser.getHospitalId();
		if (hospitalId !=null && !hospitalId.trim().isEmpty()) {
			//普通用户只能查看自己的用户
			criteria.andHospitalIdEqualTo(hospitalId);
		}
		
		if (!UserSessionOperator.isSupper()) {
			criteria
					.andCreateUserIdEqualTo(UserSessionOperator.getCurrentUserId());
		}
		if (role.getDateStart() != null
				&& !"".equals(role.getDateStart().toString())) {
			Date startDate = DateUtil.parseDate(role.getDateStart());
			criteria.andCreateTimeGreaterThanOrEqualTo(startDate);
		}
		if (role.getDateEnd() != null
				&& !"".equals(role.getDateEnd().toString())) {
			Date endDate = DateUtil.parseDate(role.getDateEnd());
			criteria.andCreateTimeLessThan(DateUtils.addDays(endDate, 1));
		}
		if (role.isPage()) {
			totalCount = this.roleDAOImpl.countByExample(example);
			role.setTotalCount(totalCount);
			example.setOrderByClause("create_time desc limit "
					+ role.getFirst() + "," + role.getPageSize());
			map.put("dataList", this.roleDAOImpl.selectByExample(example));
		} else {
			example.setOrderByClause("create_time desc");
			map.put("dataList", this.roleDAOImpl.selectByExample(example));
		}
		map.put("pageCountAll", totalCount);
		return map;
	}

	@Override
	public JsonResultMessage saveOrUpdateRoleInfo(Role role,
			String checkedUserIds,String permissionIds,User currUser) {
		JsonResultMessage jsonResultMessage = new JsonResultMessage();
		long userId = currUser.getUserId();
		int roleId = 0;
		String hospitalId = currUser.getHospitalId();
		role.setCreateUserId(userId);
		try {
			if (role.getRoleId() == null || role.getRoleId() == 0) {
				role.setCreateTime(new Date());
				role.setHospitalId(hospitalId);
				role.setIsDeleted(0);
				this.roleDAOImpl.insert(role);
			} else {
				role.setHospitalId(hospitalId);
				role.setIsDeleted(0);
				this.roleDAOImpl.updateByPrimaryKeySelective(role);
				// 删除角色用户关联关系
				UserRoleExample ruserRoleExample = new UserRoleExample();
				ruserRoleExample.createCriteria().andRoleIdEqualTo(
						role.getRoleId());
				userRoleDAOImpl.deleteByExample(ruserRoleExample);
			}
			roleId = role.getRoleId();
			// 用户角色表关系插入
			if (checkedUserIds != null && checkedUserIds.length() > 0) {
				String[] userIds = checkedUserIds.split(",");
				List<UserRole> userRoleList = new ArrayList<UserRole>();
				if (userIds != null && userIds.length > 0) {
					for (String uId : userIds) {
						UserRole rUserRole = new UserRole();
						rUserRole.setUserId(Long.valueOf(uId));
						rUserRole.setRoleId(roleId);
						rUserRole.setHospitalId(hospitalId);
						userRoleList.add(rUserRole);
					}
					this.userRoleDAOImpl.insertUserRoleList(userRoleList);
				}

			}
		} catch (DuplicateKeyException e) {
			// rolename 唯一性约束
			jsonResultMessage.setJsonData("1", "角色名字重复！");
		}
		
		//菜单关系资源保存
		int flag = 0;
		if (roleId != 0) {
			// 删除角色菜单权限关联关系
			RolePermissionExample rolePermissionExample = new RolePermissionExample();
			rolePermissionExample.createCriteria().andRoleIdEqualTo(roleId);
			rRolePermissionMapper.deleteByExample(rolePermissionExample);

			// 角色菜单权限表关系插入
			if (permissionIds != null && permissionIds.length() > 0) {
				List<RolePermission> rolePermList = new ArrayList<RolePermission>();
				String[] permissionIdsArray = permissionIds.split(",");
				RolePermission rolePermission = null;
				if (permissionIdsArray != null && permissionIdsArray.length > 0) {
					for (String str : permissionIdsArray) {
						// String[] strArray = str.split("_"); //
						// 数据下标0是资源类型,下标1是资源id
						rolePermission = new RolePermission();
						rolePermission.setRoleId(roleId);
						rolePermission.setResourceId(Integer.valueOf(str));
						rolePermission.setResourceTypeId(1);
						rolePermission.setHospitalId(hospitalId);
						rolePermList.add(rolePermission);
					}
					flag = rRolePermissionMapper.insertRolePermissionList(rolePermList);
				}

			}
		}
		
		jsonResultMessage.setJsonData("0", roleId);
		return jsonResultMessage;
	}
}