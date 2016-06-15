package com.sxjr.message.dao;

import com.sxjr.message.model.LogSmsConduitResult;

public interface LogSmsConduitResultMapper {
    int deleteByPrimaryKey(String smsid);

    int insert(LogSmsConduitResult record);

    int insertSelective(LogSmsConduitResult record);

    LogSmsConduitResult selectByPrimaryKey(String smsid);

    int updateByPrimaryKeySelective(LogSmsConduitResult record);

    int updateByPrimaryKey(LogSmsConduitResult record);
}