package com.qazit.register.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.qazit.register.model.AppUserVO;

public interface AppUserVOMapper {
	// 根据手机号密码登陆
	public AppUserVO getUser(@Param("username") String username,@Param("userpassword") String userpassword);

	// 注册新用户
	public void createUser(AppUserVO user);

	// 用户信息的修改
	public void updateUser(AppUserVO user);

	// 按Id查询用户信息
	public AppUserVO selectByUserId(@Param("userid") Integer userid);

	// 查找手机号是否已经存在
	public AppUserVO selectByUserPhone(String cellphonenumber);
	//查找身份证号
	public AppUserVO selectByUserIdCard(@Param("identifynumber")String identifynumber);
	
	//修改账号安全
	public void updateByUser(AppUserVO user);
	
//	// 根据用户信息修改邮箱
//	public void updateByMail(@Param("userid") Integer userid,@Param("email") String mail);
//
//	// 根据用户信息修改手机号
//	public void updateByCellphone(@Param("userid") Integer userid,@Param("cellphonenumber") String cellphonenumber);
	
	
}
