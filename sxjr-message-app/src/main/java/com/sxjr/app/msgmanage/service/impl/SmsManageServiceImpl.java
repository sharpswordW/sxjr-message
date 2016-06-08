package com.sxjr.app.msgmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sxjr.app.msgmanage.entity.SmClientInfo;
import com.sxjr.app.msgmanage.mapper.TbSmsManageMapper;
import com.sxjr.app.msgmanage.service.SmsManageService;
import com.sxjr.common.util.RedisUtil;

@Service
public class SmsManageServiceImpl implements SmsManageService {

	@Autowired
	private TbSmsManageMapper tbSmsManageMapper;
	@Autowired
	private RedisUtil redisUtil;
	private long tiemOut = 60 * 60 * 6;// 单位：s

	private static final String CLIENT_KEY = "smClient.info.";

	@Override
	public int addClient(SmClientInfo smClientInfo) {
		
		redisUtil.set(CLIENT_KEY + smClientInfo.getAssessToken(),
				JSONObject.toJSONString(smClientInfo), tiemOut);
		boolean flag=isExists(smClientInfo.getAssessToken(),smClientInfo.getAssessSecret());
		System.out.println(flag);
		return tbSmsManageMapper.save(smClientInfo);
	}
	public boolean isExists(String key,String screteID) {
		 Object result = redisUtil.get(CLIENT_KEY+key);
		 if(result != null ){
	            SmClientInfo smClientInfo= JSON.parseObject(result.toString(),SmClientInfo.class);
	            if (screteID.equals(smClientInfo.getAssessSecret()) && "0".equals(smClientInfo.getStatus())) {
					return true;
				}
	        }
		
		return false;
		
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