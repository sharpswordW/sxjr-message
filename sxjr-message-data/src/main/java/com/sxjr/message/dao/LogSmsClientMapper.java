package com.sxjr.message.dao;

import com.sxjr.message.model.LogSmsClient;

public interface LogSmsClientMapper {
    int deleteByPrimaryKey(String smsid);

    int insert(LogSmsClient record);

    int insertSelective(LogSmsClient record);

    LogSmsClient selectByPrimaryKey(String smsid);

    int updateByPrimaryKeySelective(LogSmsClient record);

    int updateByPrimaryKey(LogSmsClient record);
}