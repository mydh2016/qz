package com.qazit.hospital.web.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qazit.hospital.web.model.PatientAddress;
import com.qazit.hospital.web.model.PatientAddressExample;

public interface PatientAddressMapper {
    int countByExample(PatientAddressExample example);
    int deleteByExample(PatientAddressExample example);
    int deleteByPrimaryKey(Integer id);
    int insert(PatientAddress record);
    int insertSelective(PatientAddress record);
    List<PatientAddress> selectByExample(PatientAddressExample example);
    PatientAddress selectByPrimaryKey(Integer id);
    int updateByExampleSelective(@Param("record") PatientAddress record, @Param("example") PatientAddressExample example);
    int updateByExample(@Param("record") PatientAddress record, @Param("example") PatientAddressExample example);
    int updateByPrimaryKeySelective(PatientAddress record);
    int updateByPrimaryKey(PatientAddress record);
    List<String> selectCategory(Long hpId);
}