package com.qazit.hospital.web.dao.mapper;

import com.qazit.hospital.web.model.TMasTaskQueue;
import com.qazit.hospital.web.model.TMasTaskQueueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMasTaskQueueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    int countByExample(TMasTaskQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    int deleteByExample(TMasTaskQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    int insert(TMasTaskQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    int insertSelective(TMasTaskQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    List<TMasTaskQueue> selectByExample(TMasTaskQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    TMasTaskQueue selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    int updateByExampleSelective(@Param("record") TMasTaskQueue record, @Param("example") TMasTaskQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    int updateByExample(@Param("record") TMasTaskQueue record, @Param("example") TMasTaskQueueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    int updateByPrimaryKeySelective(TMasTaskQueue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mas_task_queue
     *
     * @mbggenerated Thu Jan 05 11:14:25 GMT+08:00 2017
     */
    int updateByPrimaryKey(TMasTaskQueue record);
}