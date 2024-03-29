package com.sxjr.app.conduit.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxjr.app.conduit.mapper.ConduitMapper;
import com.sxjr.app.model.SmsConduit;
import com.sxjr.app.msgmodel.controller.MsgModelController;
import com.sxjr.app.service.ConduitService;

/**
 * Created by wangrq on 2016/6/2.
 */
@Service
@Transactional
public class ConduitServiceImpl implements ConduitService {
	
	private static Logger logger = LoggerFactory.getLogger(ConduitServiceImpl.class);
	
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
	public boolean updateStateById(String id,String state) {
		boolean result = false;
		SmsConduit conduit = new SmsConduit();
		conduit.setId(id);
		conduit.setState(state);
		if(conduitMapper.updateStateById(conduit) > 0){
			result = true;
		}
		return result;
		
	}

	@Override
	public boolean updateConduit(String conduitId, String state) {
		boolean result = false;
		SmsConduit conduit = new SmsConduit();
		conduit.setConduitId(conduitId);
		conduit.setState(state);
		logger.info("禁用通道,conduitId=" + conduitId);
		if(conduitMapper.updateConduit(conduit) > 0){
			result = true;
		}
		return result;
	}

}
