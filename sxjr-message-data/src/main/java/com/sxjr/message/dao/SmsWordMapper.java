package com.sxjr.message.dao;

import com.sxjr.message.model.SmsWord;

public interface SmsWordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SmsWord record);

    int insertSelective(SmsWord record);

    SmsWord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SmsWord record);

    int updateByPrimaryKey(SmsWord record);
}