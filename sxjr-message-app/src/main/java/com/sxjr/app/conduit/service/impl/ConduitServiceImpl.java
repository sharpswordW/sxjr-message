package com.sxjr.app.conduit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxjr.app.conduit.entity.Conduit;
import com.sxjr.app.conduit.mapper.ConduitMapper;
import com.sxjr.app.conduit.service.ConduitService;

/**
 * Created by wangrq on 2016/6/2.
 */
@Service
public class ConduitServiceImpl implements ConduitService {
	@Autowired
	private ConduitMapper conduitMapper;

	@Override
	public void save(Conduit conduit) {
		conduitMapper.save(conduit);
	}

	@Override
	public List<Conduit> list() {
		return conduitMapper.list();
	}

	@Override
	public Conduit findOne(String id) {
		return conduitMapper.findOne(id);
	}

	@Override
	public void update(Conduit conduit) {
		conduitMapper.update(conduit);
		
	}

	@Override
	public void delete(String id) {
		conduitMapper.delete(id);
	}

	@Override
	public Conduit findByConduitId(String conduitId) {
		return conduitMapper.findByConduitId(conduitId);
	}

	@Override
	public void updateStatusById(String id,String status) {
		Conduit conduit = new Conduit();
		conduit.setId(id);
		conduit.setStatus(status);
		conduitMapper.updateStatusById(conduit);
	}
	
}
