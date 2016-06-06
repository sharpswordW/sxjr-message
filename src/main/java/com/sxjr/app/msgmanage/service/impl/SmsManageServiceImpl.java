package com.sxjr.app.msgmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxjr.app.msgmanage.entity.SmClientInfo;
import com.sxjr.app.msgmanage.mapper.TbSmsManageMapper;
import com.sxjr.app.msgmanage.service.SmsManageService;
import com.sxjr.app.msgmodel.entity.MsgModel;

@Service
public class SmsManageServiceImpl implements SmsManageService {

	@Autowired
	private TbSmsManageMapper tbSmsManageMapper;
	@Override
	public int addClient(SmClientInfo smClientInfo) {
		
		return tbSmsManageMapper.save(smClientInfo);
	}
	@Override
	public List<SmClientInfo> list() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SmClientInfo findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(SmClientInfo smClientInfo) {
		// TODO Auto-generated method stub
		
	}

}