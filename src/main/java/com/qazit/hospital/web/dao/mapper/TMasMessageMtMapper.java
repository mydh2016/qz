package com.qazit.hospital.web.dao.mapper;

import com.qazit.hospital.web.model.TMasMessageMt;
import com.qazit.hospital.web.model.TMasMessageMtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMasMessageMtMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mt
     *
     * @mbggenerated Wed Jan 04 16:54:08 GMT+08:00 2017
     */
    int countByExample(TMasMessageMtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mt
     *
     * @mbggenerated Wed Jan 04 16:54:08 GMT+08:00 2017
     */
    int deleteByExample(TMasMessageMtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mt
     *
     * @mbggenerated Wed Jan 04 16:54:08 GMT+08:00 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mt
     *
     * @mbggenerated Wed Jan 04 16:54:08 GMT+08:00 2017
     */
    int insert(TMasMessageMt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mt
     *
     * @mbggenerated Wed Jan 04 16:54:08 GMT+08:00 2017
     */
    int insertSelective(TMasMessageMt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mt
     *
     * @mbggenerated Wed Jan 04 16:54:08 GMT+08:00 2017
     */
    List<TMasMessageMt> selectByExample(TMasMessageMtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mt
     *
     * @mbggenerated Wed Jan 04 16:54:08 GMT+08:00 2017
     */
    TMasMessageMt selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mt
     *
     * @mbggenerated Wed Jan 04 16:54:08 GMT+08:00 2017
     */
    int updateByExampleSelective(@Param("record") TMasMessageMt record, @Param("example") TMasMessageMtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mt
     *
     * @mbggenerated Wed Jan 04 16:54:08 GMT+08:00 2017
     */
    int updateByExample(@Param("record") TMasMessageMt record, @Param("example") TMasMessageMtExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mt
     *
     * @mbggenerated Wed Jan 04 16:54:08 GMT+08:00 2017
     */
    int updateByPrimaryKeySelective(TMasMessageMt record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mt
     *
     * @mbggenerated Wed Jan 04 16:54:08 GMT+08:00 2017
     */
    int updateByPrimaryKey(TMasMessageMt record);
}