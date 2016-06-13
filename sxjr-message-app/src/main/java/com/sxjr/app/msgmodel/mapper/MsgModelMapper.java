package com.sxjr.app.msgmodel.mapper;

import java.util.List;

import org.sxjr.message.inerface.model.SmsTemplate;

public interface MsgModelMapper{
    int save(SmsTemplate msgmodel);
    List<SmsTemplate> list();
    SmsTemplate findOne(String id);
    void update(SmsTemplate msgModel);
    void delete(String id);
}