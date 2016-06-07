package com.sxjr.app.msgmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.sxjr.app.msgmanage.entity.SmClientInfo;
import com.sxjr.app.msgmanage.mapper.TbSmsManageMapper;
import com.sxjr.app.msgmanage.service.SmsManageService;
import com.sxjr.app.until.RedisUtil;

@Service
public class SmsManageServiceImpl implements SmsManageService {

	@Autowired
	private TbSmsManageMapper tbSmsManageMapper;
	@Autowired
	private RedisUtil redisUtil;
	private long tiemOut = 60 * 60 * 6;// 单位：s

	private static final String EMPLOYEE_KEY = "smClient.info.";

	@Override
	public int addClient(SmClientInfo smClientInfo) {
		
		redisUtil.set(EMPLOYEE_KEY + smClientInfo.getAssessToken(),
				JSONObject.toJSONString(smClientInfo), tiemOut);
		return tbSmsManageMapper.save(smClientInfo);
	}

	@Override
	public List<SmClientInfo> list() {

		return tbSmsManageMapper.list();
	}

	@Override
	public SmClientInfo findOne(String id) {

		return tbSmsManageMapper.selectbyid(id);
	}

	@Override
	public void delete(String id) {
		tbSmsManageMapper.delete(id);

	}

	@Override
	public void update(SmClientInfo smClientInfo) {
		tbSmsManageMapper.update(smClientInfo);

	}

	public RedisUtil getRedisUtil() {
		return redisUtil;
	}

	public void setRedisUtil(RedisUtil redisUtil) {
		this.redisUtil = redisUtil;
	}

}