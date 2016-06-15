package com.sxjr.message.dao;

import com.sxjr.message.model.LogUserLogin;

public interface LogUserLoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogUserLogin record);

    int insertSelective(LogUserLogin record);

    LogUserLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogUserLogin record);

    int updateByPrimaryKey(LogUserLogin record);
}