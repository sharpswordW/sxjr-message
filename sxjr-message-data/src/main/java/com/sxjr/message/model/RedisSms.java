package com.sxjr.message.model;



public class RedisSms extends RedisBaseEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = 654482496054926598L;
	
	
	
	//渠道id      业务端id/路由通道id
	private int channelId;		
		
	//短信内容
	private String smsContent;
	
	//模板id
	private int TempId;
	
	//发送时间
	private long createTime;
	
		
	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		
		this.channelId = channelId;
	}
	
	public int getTempId() {
		return TempId;
	}

	public void setTempId(int TempId) {		
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
