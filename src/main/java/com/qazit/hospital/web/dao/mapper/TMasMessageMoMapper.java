package com.qazit.hospital.web.dao.mapper;

import com.qazit.hospital.web.model.TMasMessageMo;
import com.qazit.hospital.web.model.TMasMessageMoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMasMessageMoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mo
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    int countByExample(TMasMessageMoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mo
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    int deleteByExample(TMasMessageMoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mo
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mo
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    int insert(TMasMessageMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mo
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    int insertSelective(TMasMessageMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mo
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    List<TMasMessageMo> selectByExample(TMasMessageMoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mo
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    TMasMessageMo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mo
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    int updateByExampleSelective(@Param("record") TMasMessageMo record, @Param("example") TMasMessageMoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mo
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    int updateByExample(@Param("record") TMasMessageMo record, @Param("example") TMasMessageMoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mo
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    int updateByPrimaryKeySelective(TMasMessageMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_message_mo
     *
     * @mbggenerated Wed Jan 04 11:15:11 GMT+08:00 2017
     */
    int updateByPrimaryKey(TMasMessageMo record);
}