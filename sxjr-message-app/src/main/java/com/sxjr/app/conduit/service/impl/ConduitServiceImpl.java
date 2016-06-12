package com.sxjr.app.conduit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sxjr.message.inerface.model.SmsConduit;
import org.sxjr.message.inerface.service.ConduitService;

import com.sxjr.app.conduit.mapper.ConduitMapper;

/**
 * Created by wangrq on 2016/6/2.
 */
@Service
public class ConduitServiceImpl implements ConduitService {
	@Autowired
	private ConduitMapper conduitMapper;

	@Override
	public void save(SmsConduit conduit) {
		conduitMapper.save(conduit);
	}

	@Override
	public List<SmsConduit> list() {
		return conduitMapper.list();
	}

	@Override
	public SmsConduit findOne(String id) {
		return conduitMapper.findOne(id);
	}

	@Override
	public void update(SmsConduit conduit) {
		conduitMapper.update(conduit);
		
	}

	@Override
	public void delete(String id) {
		conduitMapper.delete(id);
	}

	@Override
	public SmsConduit findByConduitId(String conduitId) {
		return conduitMapper.findByConduitId(conduitId);
	}

	@Override
	public void updateStateById(String id,String state) {
		SmsConduit conduit = new SmsConduit();
		conduit.setId(id);
		conduit.setState(state);
		conduitMapper.updateStateById(conduit);
	}
	
}
