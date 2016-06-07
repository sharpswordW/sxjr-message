package com.sxjr.app.msgmodel.service;

import java.util.List;

import com.sxjr.app.msgmodel.entity.MsgModel;

/**
 * Created by wangrq on 2016/6/2.
 */
public interface MsgModelService{
    void save(MsgModel msgmodel);
    List<MsgModel> list();
    MsgModel findOne(String id);
    void update(MsgModel msgmodel);
    void delete(String id);
    void disable(MsgModel msgmodel);
}
