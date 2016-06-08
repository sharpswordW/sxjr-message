package com.sxjr.app.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.sxjr.common.util.RedisUtil;

public class ConfigInitProcessor implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private RedisUtil redisUtil;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
//		SysConfig sysConfig = new SysConfig();
//		sysConfig.setClientPhoneCount(40);
//		sysConfig.setClientPhoneTemplet(10);
//		sysConfig.setClientPhoneTimeSpan(60);
//		sysConfig.setClientBulk(0);
//		sysConfig.setConduitPhoneSecond(20);
//		sysConfig.setConduitBulkSecond(5);
//		sysConfig.setConduitPhoneCount(200);
//		sysConfig.setConduitPhoneRepeat(40);
//		SsysConfigMapper.save(sysConfig);
		redisUtil.set("clientPhoneCount", 40);
		redisUtil.set("clientPhoneTemplet", 10);
		redisUtil.set("clientPhoneTimeSpan", 60);
		redisUtil.set("clientBulk", 0);
		redisUtil.set("conduitPhoneSecond", 20);
		redisUtil.set("conduitBulkSecond", 5);
		redisUtil.set("conduitPhoneCount", 200);
		redisUtil.set("conduitPhoneRepeat", 40);
	}

}
