package com.sxjr.message.dao;

import com.sxjr.message.model.LogConduitStatistics;

public interface LogConduitStatisticsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogConduitStatistics record);

    int insertSelective(LogConduitStatistics record);

    LogConduitStatistics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogConduitStatistics record);

    int updateByPrimaryKey(LogConduitStatistics record);
}