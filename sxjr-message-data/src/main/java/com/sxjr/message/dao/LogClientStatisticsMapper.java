package com.sxjr.message.dao;

import com.sxjr.message.model.LogClientStatistics;

public interface LogClientStatisticsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogClientStatistics record);

    int insertSelective(LogClientStatistics record);

    LogClientStatistics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogClientStatistics record);

    int updateByPrimaryKey(LogClientStatistics record);
}