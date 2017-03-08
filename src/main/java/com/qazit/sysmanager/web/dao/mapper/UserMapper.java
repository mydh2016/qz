package com.qazit.sysmanager.web.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.qazit.sysmanager.web.model.User;
import com.qazit.sysmanager.web.model.UserExample;
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    int countByExample(UserExample example);
    
    /**
     * 查询当前用户数量
     * @param example
     * @return
     */
    int countForUser(UserExample example);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    List<User> selectByExample(UserExample example);

    List<User> selectForLogin(User user);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    User selectByPrimaryKey(Long userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Dec 28 11:11:59 CST 2016
     */
    int updateByPrimaryKey(User record);
}