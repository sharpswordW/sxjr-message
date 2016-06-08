package com.sxjr.app.sequence.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxjr.app.sequence.mapper.SequenceMapper;
import com.sxjr.app.sequence.service.SequenceService;

@Service
public class SequenceServiceImpl implements SequenceService{
	@Autowired
	private SequenceMapper sequenceMapper;

	@Override
	public String getSequence(String name) {
		return sequenceMapper.getSequence(name);
	}

}
