package com.sxjr.app.msgmodel.mapper;

import java.util.List;

import com.sxjr.app.msgmodel.entity.SmsTemplate;

public interface MsgModelMapper{
    void save(SmsTemplate msgModel);
    List<SmsTemplate> list();
    SmsTemplate findOne(String id);
    void update(SmsTemplate msgModel);
    void delete(String id);
}