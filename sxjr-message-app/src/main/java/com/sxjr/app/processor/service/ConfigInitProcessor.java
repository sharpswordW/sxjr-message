package com.sxjr.app.processor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.alibaba.fastjson.JSON;
import com.sxjr.app.conduit.mapper.ConduitMapper;
import com.sxjr.app.model.SmsConduit;
import com.sxjr.app.model.SmsTemplate;
import com.sxjr.app.msgmodel.mapper.MsgModelMapper;
import com.sxjr.app.processor.entity.SysConfig;
import com.sxjr.app.processor.mapper.SysConfigMapper;
import com.sxjr.common.util.RedisUtil;

public class ConfigInitProcessor implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private SysConfigMapper sysConfigMapper;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private MsgModelMapper msgModelMapper;
	@Autowired
	private ConduitMapper conduitMapper;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//加载系统配置信息
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
		//加载短信模板
		List<SmsTemplate> smsTemplateList = msgModelMapper.list();
		if(smsTemplateList != null){
			redisUtil.remove("SmsTemplate");
			for(SmsTemplate template : smsTemplateList){
				redisUtil.HSET("SmsTemplate", template.getId(), JSON.toJSON(template).toString());
			}
		}
		//加载通道信息
		List<SmsConduit> smsConduitList = conduitMapper.list();
		if(smsConduitList != null){
			redisUtil.remove("conduit");
			for(SmsConduit conduit : smsConduitList){
				redisUtil.HSET("conduit", conduit.getConduitId(), JSON.toJSON(conduit).toString());
			}
		}
	}

}
