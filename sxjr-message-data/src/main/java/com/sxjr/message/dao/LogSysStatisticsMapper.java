package com.sxjr.message.dao;

import com.sxjr.message.model.LogSysStatistics;

public interface LogSysStatisticsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogSysStatistics record);

    int insertSelective(LogSysStatistics record);

    LogSysStatistics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogSysStatistics record);

    int updateByPrimaryKey(LogSysStatistics record);
}