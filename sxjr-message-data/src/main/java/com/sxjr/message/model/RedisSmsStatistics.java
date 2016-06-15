package com.sxjr.message.model;



public class RedisSmsStatistics extends RedisBaseEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = 654482496054926598L;
	
	
	
	
	
//	private int Id;
	private int channelId;
	private long startDate;
	private long endDate;
	private int smsCount;
	private int successCount;
	private int errorCount;

				
	
//	public int getSmsContent() {
//		return Id;
//	}
//
//	public void setSmsContent(int Id) {		
//		this.Id = Id;
//	}
//	
	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {		
		this.channelId = channelId;
	}
	
	public long  getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}
	
	public long  getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}
	
	
	public int getSmsCount() {
		return smsCount;
	}

	public void setSmsCount(int smsCount) {		
		this.smsCount = smsCount;
	}
	
	public int getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(int successCount) {		
		this.successCount = successCount;
	}
	
	public int getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(int errorCount) {		
		this.errorCount = errorCount;
	}
}
