package com.sxjrmsg.app.msgmodel.mapper;

import java.util.List;

import com.sxjrmsg.app.msgmodel.entity.MsgModel;

public interface MsgModelMapper{
    List<MsgModel> save(MsgModel msgModel);
}