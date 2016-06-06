package com.sxjr.app.conduit.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sxjr.app.conduit.entity.Conduit;
import com.sxjr.app.conduit.mapper.ConduitMapper;
import com.sxjr.app.conduit.service.ConduitService;

/**
 * Created by wangrq on 2016/6/2.
 */
@Service
public class ConduitServiceImpl implements ConduitService {
	
	private ConduitMapper conduitMapper;

	@Override
	public void save(Conduit conduit) {
		conduitMapper.save(conduit);
	}

	@Override
	public List<Conduit> list() {
		return conduitMapper.list();
	}
//
//	@Override
//	public Conduit findOne(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void update(Conduit conduit) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(String id) {
//		// TODO Auto-generated method stub
//		
//	}
	
}
