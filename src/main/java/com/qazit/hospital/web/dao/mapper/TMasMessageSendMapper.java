package com.qazit.hospital.web.dao.mapper;

import com.qazit.hospital.web.model.TMasMessageSend;
import com.qazit.hospital.web.model.TMasMessageSendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMasMessageSendMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MAS_MESSAGE_SEND
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int countByExample(TMasMessageSendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MAS_MESSAGE_SEND
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int deleteByExample(TMasMessageSendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MAS_MESSAGE_SEND
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MAS_MESSAGE_SEND
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int insert(TMasMessageSend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MAS_MESSAGE_SEND
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int insertSelective(TMasMessageSend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MAS_MESSAGE_SEND
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    List<TMasMessageSend> selectByExample(TMasMessageSendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MAS_MESSAGE_SEND
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    TMasMessageSend selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MAS_MESSAGE_SEND
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int updateByExampleSelective(@Param("record") TMasMessageSend record, @Param("example") TMasMessageSendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MAS_MESSAGE_SEND
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int updateByExample(@Param("record") TMasMessageSend record, @Param("example") TMasMessageSendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MAS_MESSAGE_SEND
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int updateByPrimaryKeySelective(TMasMessageSend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_MAS_MESSAGE_SEND
     *
     * @mbggenerated Fri Dec 30 15:30:38 GMT+08:00 2016
     */
    int updateByPrimaryKey(TMasMessageSend record);
}