package com.sxjrmsg.app.msgmodel.service;

import java.util.List;

import com.sxjrmsg.app.msgmodel.entity.MsgModel;

/**
 * Created by wangrq on 2016/6/2.
 */
public interface MsgModelService{
    void save(MsgModel msgmodel);
    List<MsgModel> list();
}
