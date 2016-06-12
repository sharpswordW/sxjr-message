package com.sxjr.app.msgmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sxjr.message.inerface.service.IQrySmsClient;

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
	/**
     * 超时时间
     */
	private long tiemOut = 60 * 60 * 6;// 单位：s
	/**
     * 存放redis中客户端信息KEY的前缀
     */
	private static final String CLIENT_KEY = "smClient.info.";

	@Override
	public int addClient(SmClientInfo smClientInfo) {
		//存放客户端信息到redis
		redisUtil.set(CLIENT_KEY + smClientInfo.getAssessToken(),
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
	public void delete(SmClientInfo smClientInfo) {
		//删除redis中保存的信息
		redisUtil.remove(CLIENT_KEY+smClientInfo.getAssessToken());
		tbSmsManageMapper.delete(smClientInfo.getId());

	}

	@Override
	public void update(SmClientInfo smClientInfo) {
		
		SmClientInfo oldSmClientInfo=tbSmsManageMapper.selectbyid(smClientInfo.getId());
		if (oldSmClientInfo != null) {
			smClientInfo.setAssessSecret(oldSmClientInfo.getAssessSecret());
			smClientInfo.setAssessToken(oldSmClientInfo.getAssessToken());
		}
		//更新redis中客户端信息
		redisUtil.remove(CLIENT_KEY+smClientInfo.getAssessToken());
		redisUtil.set(CLIENT_KEY + smClientInfo.getAssessToken(),
				JSONObject.toJSONString(smClientInfo), tiemOut);
		tbSmsManageMapper.update(smClientInfo);

	}

	public RedisUtil getRedisUtil() {
		return redisUtil;
	}

	public void setRedisUtil(RedisUtil redisUtil) {
		this.redisUtil = redisUtil;
	}

}