package com.sxjr.app.msgmodel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxjr.app.msgmodel.entity.MsgModel;
import com.sxjr.app.msgmodel.entity.SmsTemplate;
import com.sxjr.app.msgmodel.mapper.MsgModelMapper;
import com.sxjr.app.msgmodel.service.MsgModelService;

/**
 * Created by wangrq on 2016/6/2.
 */
@Service
public class MsgModelServiceImpl implements MsgModelService {

    @Autowired
    private MsgModelMapper msgModelMapper;

	@Override
	public void save(SmsTemplate msgmodel) {
		msgModelMapper.save(msgmodel);
		
	}

	@Override
	public List<SmsTemplate> list() {
		return msgModelMapper.list();
	}

	@Override
	public SmsTemplate findOne(String id) {
		return msgModelMapper.findOne(id);
	}

	@Override
	public void update(SmsTemplate msgmodel) {
		msgModelMapper.update(msgmodel);
	}

	@Override
	public void delete(String id) {
		msgModelMapper.delete(id);
		
	}

	@Override
	public void disable(SmsTemplate msgmodel) {
		msgModelMapper.update(msgmodel);
	}

}
