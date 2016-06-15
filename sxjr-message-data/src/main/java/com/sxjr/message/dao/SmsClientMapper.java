package com.sxjr.message.dao;

import com.sxjr.message.model.SmsClient;

public interface SmsClientMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmsClient record);

    int insertSelective(SmsClient record);

    SmsClient selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmsClient record);

    int updateByPrimaryKey(SmsClient record);
}