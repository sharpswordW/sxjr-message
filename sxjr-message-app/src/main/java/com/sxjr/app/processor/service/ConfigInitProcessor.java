package com.sxjr.app.processor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.sxjr.app.processor.entity.SysConfig;
import com.sxjr.app.processor.mapper.SysConfigMapper;
import com.sxjr.common.util.RedisUtil;

public class ConfigInitProcessor implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private SysConfigMapper sysConfigMapper;
	@Autowired
	private RedisUtil redisUtil;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<SysConfig> configList = sysConfigMapper.list();
		if(configList != null){
			SysConfig sysConfig = sysConfigMapper.list().get(0);
			redisUtil.SET("clientPhoneCount", sysConfig.getClientPhoneCount());
			redisUtil.SET("clientPhoneTemplet", sysConfig.getClientPhoneTemplet());
			redisUtil.SET("clientPhoneTimeSpan", sysConfig.getClientPhoneTimeSpan());
			redisUtil.SET("clientBulk", sysConfig.getClientBulk());
			redisUtil.SET("conduitPhoneSecond", sysConfig.getConduitPhoneSecond());
			redisUtil.SET("conduitBulkSecond", sysConfig.getConduitBulkSecond());
			redisUtil.SET("conduitPhoneCount", sysConfig.getConduitPhoneCount());
			redisUtil.SET("conduitPhoneRepeat", sysConfig.getConduitPhoneRepeat());
		}
	}

}
