package com.sxjr.app.processor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.sxjr.app.processor.entity.SysConfig;
import com.sxjr.app.processor.mapper.SysConfigMapper;
import com.sxjr.common.util.RedisUtil;

public class ConfigInitProcessor implements ApplicationListener<ContextRefreshedEvent> {
	private SysConfigMapper sysConfigMapper;
	@Autowired
	private RedisUtil redisUtil;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		SysConfig sysConfig = sysConfigMapper.list().get(0);
		redisUtil.set("clientPhoneCount", sysConfig.getClientPhoneCount());
		redisUtil.set("clientPhoneTemplet", sysConfig.getClientPhoneTemplet());
		redisUtil.set("clientPhoneTimeSpan", sysConfig.getClientPhoneTimeSpan());
		redisUtil.set("clientBulk", sysConfig.getClientBulk());
		redisUtil.set("conduitPhoneSecond", sysConfig.getConduitPhoneSecond());
		redisUtil.set("conduitBulkSecond", sysConfig.getConduitBulkSecond());
		redisUtil.set("conduitPhoneCount", sysConfig.getConduitPhoneCount());
		redisUtil.set("conduitPhoneRepeat", sysConfig.getConduitPhoneRepeat());
	}

}
