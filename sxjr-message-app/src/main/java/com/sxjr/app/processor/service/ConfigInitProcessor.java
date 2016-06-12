package com.sxjr.app.processor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.sxjr.message.inerface.model.SmsConduit;

import com.alibaba.fastjson.JSON;
import com.sxjr.app.conduit.mapper.ConduitMapper;
import com.sxjr.app.msgmodel.entity.SmsTemplate;
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
			redisUtil.set("clientPhoneCount", sysConfig.getClientPhoneCount());
			redisUtil.set("clientPhoneTemplet", sysConfig.getClientPhoneTemplet());
			redisUtil.set("clientPhoneTimeSpan", sysConfig.getClientPhoneTimeSpan());
			redisUtil.set("clientBulk", sysConfig.getClientBulk());
			redisUtil.set("conduitPhoneSecond", sysConfig.getConduitPhoneSecond());
			redisUtil.set("conduitBulkSecond", sysConfig.getConduitBulkSecond());
			redisUtil.set("conduitPhoneCount", sysConfig.getConduitPhoneCount());
			redisUtil.set("conduitPhoneRepeat", sysConfig.getConduitPhoneRepeat());
		}
		//加载短信模板
		List<SmsTemplate> smsTemplateList = msgModelMapper.list();
		if(smsTemplateList != null){
			redisUtil.remove("SmsTemplate");
			for(SmsTemplate template : smsTemplateList){
				redisUtil.setHash("SmsTemplate", template.getId(), JSON.toJSON(template).toString());
			}
		}
		//加载通道信息
		List<SmsConduit> smsConduitList = conduitMapper.list();
		if(smsConduitList != null){
			redisUtil.remove("conduit");
			for(SmsConduit conduit : smsConduitList){
				redisUtil.setHash("conduit", conduit.getConduitId(), JSON.toJSON(conduit).toString());
			}
		}
	}

}
