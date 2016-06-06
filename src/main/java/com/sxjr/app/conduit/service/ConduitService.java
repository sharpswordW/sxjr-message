package com.sxjr.app.conduit.service;

import java.util.List;

import com.sxjr.app.conduit.entity.Conduit;

/**
 * Created by wangrq on 2016/6/6.
 */
public interface ConduitService{
    void save(Conduit conduit);
    List<Conduit> list();
    Conduit findOne(String id);
    void update(Conduit conduit);
    void delete(String id);
}
