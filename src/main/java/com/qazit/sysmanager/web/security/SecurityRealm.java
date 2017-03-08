package com.qazit.sysmanager.web.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.qazit.sysmanager.util.StaticValue;
import com.qazit.sysmanager.web.dao.mapper.UserMapper;
import com.qazit.sysmanager.web.model.User;
import com.qazit.sysmanager.web.model.UserExample;

/**
 * 用户身份验证,授权 Realm 组件
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {
	
	private static final Logger logger = Logger.getLogger(SecurityRealm.class);
	
	@Resource
	private UserMapper userMapper;

	/**
	 * 权限检查
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("==========================");
//		 SimpleAuthorizationInfo authorizationInfo = new
//		 SimpleAuthorizationInfo();
//		 String username = String.valueOf(principals.getPrimaryPrincipal());
//		
//		 final User user = userService.selectByUsername(username);
//		 final List<Role> roleInfos =
//		 roleService.selectRolesByUserId(user.getId());
//		 for (Role role : roleInfos) {
//			 // 添加角色
//			 System.err.println(role);
//			 authorizationInfo.addRole(role.getRoleSign());
//			
//			 final List<Permission> permissions =
//			 permissionService.selectPermissionsByRoleId(role.getId());
//			 for (Permission permission : permissions) {
//				 // 添加权限
//				 System.err.println(permission);
//				 authorizationInfo.addStringPermission(permission.getPermissionSign());
//				 List<String> roles =new ArrayList<String>();
//				 authorizationInfo.addRoles(roles);
//			 }
//		 }
//		System.out.println("权限检查");
		return null;
	}

	/**
	 * 登录验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		 UsernamePasswordToken tk = (UsernamePasswordToken	) token;
		String userName = tk.getUsername();
		String password=new String((char[]) tk.getCredentials());
		String hospitalNo = tk.getHost();
		CurrentUser cuser = new CurrentUser();
		List<User> userList = new ArrayList<User>();
		if(hospitalNo!=null&&StaticValue.SUPER_ADMIN_DEFAULT_NO.equals(hospitalNo)){//超级管理登陆 .超级管理员的编号和id都为StaticValue.SUPER_ADMIN
			UserExample example = new UserExample();
			String hospitalId = String.valueOf(StaticValue.SUPER_HOSPITAL_ID);
			example.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password).andHospitalIdEqualTo(hospitalId);
			userList = userMapper.selectByExample(example);
		}else{//医院管理员登陆
			User user = new User();
			user.setUserName(userName);
			user.setHospitalNo(hospitalNo);
			userList = userMapper.selectForLogin(user);
		}
		if (userList != null && userList.size() > 0) {
			cuser.setCurrentUser(userList.get(0));
			logger.info("select from user table for user info ,the username is ::"+cuser.getCurrentUser().getUserName());
		}
		cuser.getCurrentUser().setPassword("");
		return new SimpleAuthenticationInfo(cuser, password, getName());
	}
}
