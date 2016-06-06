package com.sxjr.app.msgmodel.mapper;

import java.util.List;

import com.sxjr.app.msgmodel.entity.MsgModel;

public interface MsgModelMapper{
    void save(MsgModel msgModel);
    List<MsgModel> list();
    MsgModel findOne(String id);
    void update(MsgModel msgModel);
    void delete(String id);
}