package com.sxjr.message.dao;

import com.sxjr.message.model.msgModel;

public interface msgModelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(msgModel record);

    int insertSelective(msgModel record);

    msgModel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(msgModel record);

    int updateByPrimaryKey(msgModel record);
}