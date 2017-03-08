package com.qazit.hospital.web.dao.mapper;

import com.qazit.hospital.web.model.TMessageTimingTask;
import com.qazit.hospital.web.model.TMessageTimingTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMessageTimingTaskMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MESSAGE_TIMING_TASK
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int countByExample(TMessageTimingTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MESSAGE_TIMING_TASK
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int deleteByExample(TMessageTimingTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MESSAGE_TIMING_TASK
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MESSAGE_TIMING_TASK
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int insert(TMessageTimingTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MESSAGE_TIMING_TASK
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int insertSelective(TMessageTimingTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MESSAGE_TIMING_TASK
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    List<TMessageTimingTask> selectByExample(TMessageTimingTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MESSAGE_TIMING_TASK
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    TMessageTimingTask selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MESSAGE_TIMING_TASK
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int updateByExampleSelective(@Param("record") TMessageTimingTask record, @Param("example") TMessageTimingTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MESSAGE_TIMING_TASK
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int updateByExample(@Param("record") TMessageTimingTask record, @Param("example") TMessageTimingTaskExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MESSAGE_TIMING_TASK
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int updateByPrimaryKeySelective(TMessageTimingTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MESSAGE_TIMING_TASK
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int updateByPrimaryKey(TMessageTimingTask record);
}