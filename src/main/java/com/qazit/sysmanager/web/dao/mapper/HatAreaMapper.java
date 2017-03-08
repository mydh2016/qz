package com.qazit.sysmanager.web.dao.mapper;

import com.qazit.sysmanager.web.model.HatArea;
import com.qazit.sysmanager.web.model.HatAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HatAreaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hat_area
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    int countByExample(HatAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hat_area
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    int deleteByExample(HatAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hat_area
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hat_area
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    int insert(HatArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hat_area
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    int insertSelective(HatArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hat_area
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    List<HatArea> selectByExample(HatAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hat_area
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    HatArea selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hat_area
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    int updateByExampleSelective(@Param("record") HatArea record, @Param("example") HatAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hat_area
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    int updateByExample(@Param("record") HatArea record, @Param("example") HatAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hat_area
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    int updateByPrimaryKeySelective(HatArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hat_area
     *
     * @mbggenerated Wed Feb 22 13:47:29 GMT+08:00 2017
     */
    int updateByPrimaryKey(HatArea record);
}