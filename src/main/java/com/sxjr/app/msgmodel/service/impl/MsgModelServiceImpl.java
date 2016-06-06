package com.sxjr.app.msgmodel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxjr.app.msgmodel.entity.MsgModel;
import com.sxjr.app.msgmodel.mapper.MsgModelMapper;
import com.sxjr.app.msgmodel.service.MsgModelService;

/**
 * Created by shuhg on 2016/5/25.
 */
@Service
public class MsgModelServiceImpl implements MsgModelService {

    @Autowired
    private MsgModelMapper msgModelMapper;

	@Override
	public void save(MsgModel msgmodel) {
		msgModelMapper.save(msgmodel);
		
	}

	@Override
	public List<MsgModel> list() {
		return msgModelMapper.list();
	}

	@Override
	public MsgModel findOne(String id) {
		return msgModelMapper.findOne(id);
	}

	@Override
	public void update(MsgModel msgmodel) {
		msgModelMapper.update(msgmodel);
	}

	@Override
	public void delete(String id) {
		msgModelMapper.delete(id);
		
	}

}