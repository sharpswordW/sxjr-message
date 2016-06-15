package com.sxjr.message.dao;

import com.sxjr.message.model.SmsConduit;

public interface SmsConduitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmsConduit record);

    int insertSelective(SmsConduit record);

    SmsConduit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmsConduit record);

    int updateByPrimaryKey(SmsConduit record);
}