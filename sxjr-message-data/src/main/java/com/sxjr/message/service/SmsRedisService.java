package com.sxjr.message.service;


import java.util.List;

import com.sxjr.message.model.SmsConduit;
import com.sxjr.message.model.RedisSms;
import com.sxjr.message.model.RedisSmsStatistics;
import com.sxjr.message.model.RedisSmsTemplate;
import com.sxjr.message.model.SmsClient;
import com.sxjr.message.model.SysConfig;

/**
 * Created by wangrq on 2016/6/6.
 */
public interface SmsRedisService{
	
	
	//缓存
	public static String SMS_CLIENT = "sms_client";
	public static String SMS_CONDUIT = "sms_conduit";
	public static String SMS_TEMPLATE = "sms_template";
	public static String SMS_SYSCONFIG = "sms_sysconfig";
	
	
	//短信记录
	public static String COLL_CLIENT = "coll_client";
	public static String COLL_CONDUIT = "coll_conduit";
	
	public static String STATISTICS_CLIENT = "statistics_client";
	public static String STATISTICS_CONDUIT = "statistics_conduit";
	
	
	
	
	
	//统计字段
	public static String STATISTICS_STARTDATE = "StartDate";
	public static String STATISTICS_ENDDATE = "EndDate";
	public static String STATISTICS_SMSCOUNT = "SmsCount";
	public static String STATISTICS_SUCCESSCOUNT = "SuccessCount";
	public static String STATISTICS_ERRORCOUNT = "ErrorCount";
	
	
	
	
	
	
	
	
	/**
	 * 根据id获取业务端
	 * @param id 手机号码
	 * @throws 
	 */
	SmsClient getSmsClient(String id);
	
	/**
	 * 保存业务端
	 * @param id 业务端id
	 * @throws 
	 */
	boolean addSmsClient(SmsClient smsClient);
	
	/**
	 * 根据id获取短信通道
	 * @param id 手机号码
	 * @throws 
	 */
	SmsConduit getSmsConduit(String id);
	
	/**
	 * 保存短信通道
	 * @param id 短信通道id
	 * @throws 
	 */
	boolean addSmsConduit(SmsConduit smsConduit);
	
	/**
	 * 根据id获取短信模板
	 * @param id 手机号码
	 * @throws 
	 */
	SysConfig getSmsSysConfig();
	
	/**
	 * 保存短信模板 
	 * @param id 手机号码
	 * @throws 
	 */
	boolean setSmsSysConfig(SysConfig smsConfig);
	
	/**
	 * 根据id获取短信模板
	 * @param id 手机号码
	 * @throws 
	 */
	RedisSmsTemplate getSmsTemplate(String id);
	
	/**
	 * 保存短信模板 
	 * @param id 手机号码
	 * @throws 
	 */
	boolean addSmsTemplate(RedisSmsTemplate smsTemplate);
	
	
	
	
	
	
	
	/**
	 * 获取当天业务端全部短信列表 
	 * @param id 手机号码
	 * @throws 
	 */
	List<RedisSms> getClientSms(String id);
	
	/**
	 * 添加业务端短信记录 
	 * @param id 手机号码
	 * @throws 
	 */
    boolean saveClientSms(String id, RedisSms smsList);  
    
    /**
	 * 清理当天业务端全部短信记录 
	 * @param 
	 * @throws 
	 */
    void clearClientSms();
    
    
    /**
	 * 获取当天通道短信记录 
	 * @param id 手机号码
	 * @throws 
	 */
    List<RedisSms> getConduitSms(String id);
    
    /**
	 * 添加通道短信记录 
	 * @param id 手机号码
	 * @throws 
	 */
    boolean saveConduitSms(String id, RedisSms smsList);    
    
    /**
   	 * 清理当天通道全部短信记录 
   	 * @param 
   	 * @throws 
   	 */
    void clearConduitSms();
    
    
    
    
    
    /**
   	 * 获取业务端统计数据
   	 * @param clientId 业务端id
   	 * @throws 
   	 */
    RedisSmsStatistics getClietnStatistics(String clientId);
    
    /**
   	 * 更新业务端统计数据
   	 * @param clientId 业务端id
   	 * @throws 
   	 */
    void addClietnStatistics(String clientId, int smsCount, int successCount, int errorCount);
    
    /**
   	 * 清理业务端统计数据
   	 * @param clientId 业务端id
   	 * @throws 
   	 */
    void clearClietnStatistics(String clientId, long startDate, long endDate);
    
    /**
   	 * 获取通道统计数据
   	 * @param conduitId 通道端id
   	 * @throws 
   	 */
    RedisSmsStatistics getConduitStatistics(String conduitId);
    
    /**
   	 * 更新通道统计数据
   	 * @param conduitId 通道端id
   	 * @throws 
   	 */
    void addConduitStatistics(String conduitId, int smsCount, int successCount, int errorCount);
    
    /**
   	 * 清理通道统计数据
   	 * @param conduitId 通道端id
   	 * @throws 
   	 */
    void clearConduitStatistics(String conduitId, long startDate, long endDate);
    

    
    
}
