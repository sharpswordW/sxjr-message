package com.sxjrmsg.app.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxjrmsg.app.demo.entity.TbDemo;
import com.sxjrmsg.app.demo.mapper.TbDemoMapper;
import com.sxjrmsg.app.demo.service.IDemoService;

/**
 * Created by shuhg on 2016/5/25.
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    private TbDemoMapper mapper;

	@Override
	public List<TbDemo> list() {
		// TODO Auto-generated method stub
		return mapper.list();
	}
}
