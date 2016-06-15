package com.sxjr.message.dao;

import com.sxjr.message.model.tb_sequence;

public interface tb_sequenceMapper {
    int deleteByPrimaryKey(String seqName);

    int insert(tb_sequence record);

    int insertSelective(tb_sequence record);

    tb_sequence selectByPrimaryKey(String seqName);

    int updateByPrimaryKeySelective(tb_sequence record);

    int updateByPrimaryKey(tb_sequence record);
}