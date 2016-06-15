package com.sxjr.message.dao;

import com.sxjr.message.model.SysNotify;

public interface SysNotifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysNotify record);

    int insertSelective(SysNotify record);

    SysNotify selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysNotify record);

    int updateByPrimaryKey(SysNotify record);
}