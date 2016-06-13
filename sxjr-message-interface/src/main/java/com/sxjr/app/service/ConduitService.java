package com.sxjr.app.service;

import java.util.List;

import com.sxjr.app.model.SmsConduit;

/**
 * Created by wangrq on 2016/6/6.
 */
public interface ConduitService{
    void save(SmsConduit conduit);
    List<SmsConduit> list();
    SmsConduit findOne(String id);
    void update(SmsConduit conduit);
    void delete(String id);
    SmsConduit findByConduitId(String conduitId);
    void updateStateById(String id,String state);
}
