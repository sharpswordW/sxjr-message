package org.sxjr.message.inerface.service;

import java.util.List;

import org.sxjr.message.inerface.model.Conduit;

/**
 * Created by wangrq on 2016/6/6.
 */
public interface ConduitService{
    void save(Conduit conduit);
    List<Conduit> list();
    Conduit findOne(String id);
    void update(Conduit conduit);
    void delete(String id);
    Conduit findByConduitId(String conduitId);
    void updateStatusById(String id,String status);
}
