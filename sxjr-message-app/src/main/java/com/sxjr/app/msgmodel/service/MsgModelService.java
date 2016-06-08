package com.sxjr.app.msgmodel.service;

import java.util.List;

import com.sxjr.app.msgmodel.entity.SmsTemplate;

/**
 * Created by wangrq on 2016/6/2.
 */
public interface MsgModelService{
    void save(SmsTemplate msgmodel);
    List<SmsTemplate> list();
    SmsTemplate findOne(String id);
    void update(SmsTemplate msgmodel);
    void delete(String id);
    void disable(SmsTemplate msgmodel);
}
