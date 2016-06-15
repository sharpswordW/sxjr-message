package com.sxjr.message.model;



public class RedisSms extends RedisBaseEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = 654482496054926598L;
	
	
	
	//渠道id      业务端id/路由通道id
	private String channelId;		
		
	//短信内容
	private String smsContent;
	
	//模板id
	private String TempId;
	
	//发送时间
	private long createTime;
	
		
	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		
		this.channelId = channelId;
	}
	
	public String getTempId() {
		return TempId;
	}

	public void setTempId(String TempId) {		
		this.TempId = TempId;
	}
	
	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		
		this.smsContent = smsContent;
	}
	
	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	
	
}
