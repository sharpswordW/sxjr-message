package com.sxjr.message.dao;

import com.sxjr.message.model.SysConfig;

public interface SysConfigMapper {
    int deleteByPrimaryKey(Integer clientphonecount);

    int insert(SysConfig record);

    int insertSelective(SysConfig record);

    SysConfig selectByPrimaryKey(Integer clientphonecount);

    int updateByPrimaryKeySelective(SysConfig record);

    int updateByPrimaryKey(SysConfig record);
}