package com.sxjr.message.dao;

import com.sxjr.message.model.LogSmsConduit;

public interface LogSmsConduitMapper {
    int insert(LogSmsConduit record);

    int insertSelective(LogSmsConduit record);
}