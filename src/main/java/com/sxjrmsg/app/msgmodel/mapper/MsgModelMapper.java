package com.sxjrmsg.app.msgmodel.mapper;

import java.util.List;

import com.sxjrmsg.app.msgmodel.entity.MsgModel;

public interface MsgModelMapper{
    void save(MsgModel msgModel);
    List<MsgModel> list();
}