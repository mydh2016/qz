package com.qazit.hospital.web.dao.mapper;

import com.qazit.hospital.web.model.TSendMessage;
import com.qazit.hospital.web.model.TSendMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSendMessageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEND_MESSAGE
     *
     * @mbggenerated Tue Feb 21 11:47:17 CST 2017
     */
    int countByExample(TSendMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEND_MESSAGE
     *
     * @mbggenerated Tue Feb 21 11:47:17 CST 2017
     */
    int deleteByExample(TSendMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEND_MESSAGE
     *
     * @mbggenerated Tue Feb 21 11:47:17 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEND_MESSAGE
     *
     * @mbggenerated Tue Feb 21 11:47:17 CST 2017
     */
    int insert(TSendMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEND_MESSAGE
     *
     * @mbggenerated Tue Feb 21 11:47:17 CST 2017
     */
    int insertSelective(TSendMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEND_MESSAGE
     *
     * @mbggenerated Tue Feb 21 11:47:17 CST 2017
     */
    List<TSendMessage> selectByExample(TSendMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEND_MESSAGE
     *
     * @mbggenerated Tue Feb 21 11:47:17 CST 2017
     */
    TSendMessage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEND_MESSAGE
     *
     * @mbggenerated Tue Feb 21 11:47:17 CST 2017
     */
    int updateByExampleSelective(@Param("record") TSendMessage record, @Param("example") TSendMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEND_MESSAGE
     *
     * @mbggenerated Tue Feb 21 11:47:17 CST 2017
     */
    int updateByExample(@Param("record") TSendMessage record, @Param("example") TSendMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEND_MESSAGE
     *
     * @mbggenerated Tue Feb 21 11:47:17 CST 2017
     */
    int updateByPrimaryKeySelective(TSendMessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEND_MESSAGE
     *
     * @mbggenerated Tue Feb 21 11:47:17 CST 2017
     */
    int updateByPrimaryKey(TSendMessage record);
}