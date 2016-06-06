package com.sxjr.app.msgmanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxjr.app.msgmanage.entity.SmClientInfo;
import com.sxjr.app.msgmanage.mapper.TbSmsManageMapper;
import com.sxjr.app.msgmanage.service.SmsManageService;

@Service
public class SmsManageServiceImpl implements SmsManageService {

	@Autowired
	private TbSmsManageMapper tbSmsManageMapper;
	@Override
	public int addClient(SmClientInfo smClientInfo) {
		
		return tbSmsManageMapper.save(smClientInfo);
	}

}