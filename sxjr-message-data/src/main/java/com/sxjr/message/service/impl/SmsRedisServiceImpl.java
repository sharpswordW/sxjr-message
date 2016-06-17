package com.sxjr.message.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.sxjr.message.model.RedisSms;
import com.sxjr.message.model.RedisSmsClient;
import com.sxjr.message.model.RedisSmsConduit;
import com.sxjr.message.model.RedisSmsList;
import com.sxjr.message.model.RedisSmsStatistics;
import com.sxjr.message.model.RedisSmsTemplate;
import com.sxjr.message.model.SmsClient;
import com.sxjr.message.model.SmsConduit;
import com.sxjr.message.model.SysConfig;
import com.sxjr.message.service.SmsRedisService;
import com.alibaba.fastjson.JSON;
import com.sxjr.common.util.RedisUtil;

/**
 * Created by wangrq on 2016/6/6.
 */
@Repository("smsRedisServiceImpl")
public class SmsRedisServiceImpl implements SmsRedisService{
	
	
	
	
	@Autowired
	RedisUtil redisUtil;
	 

	
	
	@Override
	public SmsClient getSmsClient(String id) {

		Object obj = redisUtil.HGET(SMS_CLIENT, id);
		
		SmsClient temp = null;
		if(!StringUtils.isEmpty(obj))	
			temp = JSON.parseObject(obj.toString(), SmsClient.class);
		    	
		return temp;	
	}

	@Override
	public boolean addSmsClient(SmsClient smsClient) {
		String result = JSON.toJSON(smsClient).toString();
    	return redisUtil.HSET(SMS_CLIENT, smsClient.getId().toString(), result);        
	}

	@Override
	public SmsConduit getSmsConduit(String id) {

		Object obj = redisUtil.HGET(SMS_CONDUIT, id);
		
		SmsConduit temp = null;
		if(!StringUtils.isEmpty(obj))		
			temp = JSON.parseObject(obj.toString(), SmsConduit.class);
		    	
		return temp;	
	}

	@Override
	public boolean addSmsConduit(SmsConduit smsConduit) {
		String result = JSON.toJSON(smsConduit).toString();
    	return redisUtil.HSET(SMS_CLIENT, smsConduit.getId().toString(), result);        
	}
	
	@Override
	public SysConfig getSmsSysConfig() {

		Object obj = redisUtil.HGET(SMS_SYSCONFIG, "0");
		
		SysConfig temp = null;
		if(!StringUtils.isEmpty(obj))		
			temp = JSON.parseObject(obj.toString(), SysConfig.class);
		    	
		return temp;	
	}

	@Override
	public boolean setSmsSysConfig(SysConfig sysConfig) {
		String result = JSON.toJSON(sysConfig).toString();
    	return redisUtil.HSET(SMS_CLIENT, "0", result);      
	}
	
	@Override
	public RedisSmsTemplate getSmsTemplate(String id) {
		
		Object obj = redisUtil.HGET(SMS_TEMPLATE, id);
		
		RedisSmsTemplate temp = null;
		if(!StringUtils.isEmpty(obj))		
			temp = JSON.parseObject(obj.toString(), RedisSmsTemplate.class);
		    	
		return temp;		
	}

	@Override
	public boolean addSmsTemplate(RedisSmsTemplate smsTemplate) {
				
		String result = JSON.toJSON(smsTemplate).toString();
    	return redisUtil.HSET(SMS_TEMPLATE, smsTemplate.getId().toString(), result);        	
	}
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<RedisSms> getClientSms(String id) {

		Object obj = redisUtil.HGET(COLL_CLIENT, id);
		
		RedisSmsList list = null;
		if(!StringUtils.isEmpty(obj))
		{
			list = JSON.parseObject(obj.toString(), RedisSmsList.class);
		}
    	
		return list == null ? null : list.getSmsList();
	}

	
	@Override
	public boolean saveClientSms(String id, RedisSms smsList) {

		Object obj = redisUtil.HGET(COLL_CLIENT, id);
		
		String result;
		if(!StringUtils.isEmpty(obj))
		{
			RedisSmsList list = JSON.parseObject(obj.toString(), RedisSmsList.class);
	    	list.getSmsList().add(smsList);
	    	list.setCount(list.getSmsList().size());
	    	result = JSON.toJSON(list).toString();
		}
		else
		{
			RedisSmsList list = new RedisSmsList();
	    	list.getSmsList().add(smsList);
	    	list.setCount(1);
	    	result = JSON.toJSON(list).toString();
		}
		
    	return redisUtil.HSET(COLL_CLIENT, id, result);    	
	}

	@Override
	public void clearClientSms() {

		redisUtil.HDEL(COLL_CLIENT);
	}

	@Override
	public List<RedisSms> getConduitSms(String id) {
		
		Object obj = redisUtil.HGET(COLL_CONDUIT, id);
		RedisSmsList list = null;
		if(!StringUtils.isEmpty(obj))
		{
			list = JSON.parseObject(obj.toString(), RedisSmsList.class);
		}
		return list == null ? null : list.getSmsList();
						
	}

	@Override
	public boolean saveConduitSms(String id, RedisSms smsList) {
		
		Object obj = redisUtil.HGET(COLL_CONDUIT, id);
		String result;
		if(!StringUtils.isEmpty(obj))
		{
			RedisSmsList list = JSON.parseObject(obj.toString(), RedisSmsList.class);
	    	list.getSmsList().add(smsList);
	    	list.setCount(list.getSmsList().size());
	    	result = JSON.toJSON(list).toString();	    	
		}
		else
		{
			RedisSmsList list = new RedisSmsList();
	    	list.getSmsList().add(smsList);
	    	list.setCount(1);
	    	result = JSON.toJSON(list).toString();
		}
		
    	return redisUtil.HSET(COLL_CONDUIT, id, result);
	}

	@Override
	public void clearConduitSms() {
		
		redisUtil.HDEL(COLL_CLIENT);				
	}
	
	
	
	

	@Override
	public RedisSmsStatistics getClietnStatistics(String clientId) {
				
		RedisSmsStatistics redisStatistics = new RedisSmsStatistics();
		redisStatistics.setChannelId(0);
		redisStatistics.setStartDate(getRedisDateValue(STATISTICS_CLIENT, clientId, STATISTICS_STARTDATE));
		redisStatistics.setEndDate(getRedisDateValue(STATISTICS_CLIENT, clientId, STATISTICS_ENDDATE));
		redisStatistics.setSmsCount(getRedisIntValue(STATISTICS_CLIENT, clientId, STATISTICS_SMSCOUNT));
		redisStatistics.setSuccessCount(getRedisIntValue(STATISTICS_CLIENT, clientId, STATISTICS_SUCCESSCOUNT));
		redisStatistics.setErrorCount(getRedisIntValue(STATISTICS_CLIENT, clientId, STATISTICS_ERRORCOUNT));
		
		return redisStatistics;
	}

	@Override
	public void addClietnStatistics(String clientId, int smsCount,
			int successCount, int errorCount) {
		
		if(smsCount > 0)
			addRedisValue(STATISTICS_CLIENT, clientId, STATISTICS_SMSCOUNT, 1);
		
		if(successCount > 0)
			addRedisValue(STATISTICS_CLIENT, clientId, STATISTICS_SUCCESSCOUNT, 1);
		
		if(errorCount > 0)
			addRedisValue(STATISTICS_CLIENT, clientId, STATISTICS_ERRORCOUNT, 1);
		
	}

	@Override
	public void clearClietnStatistics(String clientId, long startDate, long endDate) {

		setRedisIntValue(STATISTICS_CLIENT, clientId, STATISTICS_STARTDATE, startDate);
		setRedisIntValue(STATISTICS_CLIENT, clientId, STATISTICS_ENDDATE, endDate);
		setRedisIntValue(STATISTICS_CLIENT, clientId, STATISTICS_SMSCOUNT, 0);
		setRedisIntValue(STATISTICS_CLIENT, clientId, STATISTICS_SUCCESSCOUNT, 0);
		setRedisIntValue(STATISTICS_CLIENT, clientId, STATISTICS_ERRORCOUNT, 0);
		
	}

	
	
	@Override
	public RedisSmsStatistics getConduitStatistics(String conduitId) {
		
		RedisSmsStatistics redisStatistics = new RedisSmsStatistics();
		redisStatistics.setChannelId(0);
		redisStatistics.setStartDate(getRedisDateValue(STATISTICS_CONDUIT, conduitId, STATISTICS_STARTDATE));
		redisStatistics.setEndDate(getRedisDateValue(STATISTICS_CONDUIT, conduitId, STATISTICS_ENDDATE));
		redisStatistics.setSmsCount(getRedisIntValue(STATISTICS_CONDUIT, conduitId, STATISTICS_SMSCOUNT));
		redisStatistics.setSuccessCount(getRedisIntValue(STATISTICS_CONDUIT, conduitId, STATISTICS_SUCCESSCOUNT));
		redisStatistics.setErrorCount(getRedisIntValue(STATISTICS_CONDUIT, conduitId, STATISTICS_ERRORCOUNT));
			
		return redisStatistics;
	}

	@Override
	public void addConduitStatistics(String conduitId, int smsCount,
			int successCount, int errorCount) {
		
		if(smsCount > 0)
			addRedisValue(STATISTICS_CONDUIT, conduitId, STATISTICS_SMSCOUNT, 1);
		
		if(successCount > 0)
			addRedisValue(STATISTICS_CONDUIT, conduitId, STATISTICS_SUCCESSCOUNT, 1);
		
		if(errorCount > 0)
			addRedisValue(STATISTICS_CONDUIT, conduitId, STATISTICS_ERRORCOUNT, 1);
		
	}

	@Override
	public void clearConduitStatistics(String conduitId, long startDate, long endDate) {
		
		setRedisIntValue(STATISTICS_CONDUIT, conduitId, STATISTICS_STARTDATE, startDate);
		setRedisIntValue(STATISTICS_CONDUIT, conduitId, STATISTICS_ENDDATE, endDate);
		setRedisIntValue(STATISTICS_CONDUIT, conduitId, STATISTICS_SMSCOUNT, 0);
		setRedisIntValue(STATISTICS_CONDUIT, conduitId, STATISTICS_SUCCESSCOUNT, 0);
		setRedisIntValue(STATISTICS_CONDUIT, conduitId, STATISTICS_ERRORCOUNT, 0);
		
	}
        
    
	
	
	
	private int getRedisIntValue(String type, String id, String field)
	{
		Object val = redisUtil.GET(getRedisCollName(type, id, field));
		if(!StringUtils.isEmpty(val))
			return Integer.parseInt(val.toString());			
		else
			return 0;
	}
		
	private Long getRedisDateValue(String type, String id, String field)
	{
		Object val = redisUtil.GET(getRedisCollName(type, id, field));
		if(!StringUtils.isEmpty(val))
			return Long.parseLong(val.toString());			
		else
			return (long) 0;
	}
	
	private void setRedisIntValue(String type, String id, String field, long value)
	{
		redisUtil.SET(getRedisCollName(type, id, field), value);
	}
		
	private void addRedisValue(String type, String id, String field, int value)
	{
		Object val = redisUtil.GET(getRedisCollName(type, id, field));
		if(!StringUtils.isEmpty(val))
			redisUtil.SET(getRedisCollName(type, id, field), value);
		else
		    redisUtil.INCRBYFLOAT(getRedisCollName(type, id, field), value);
	}
	
	
	
	private String getRedisCollName(String type, String id, String field)
	{
		return String.format("%s_%s_%s", type, id, field);
	}

	


	


	


	
    
    

}
