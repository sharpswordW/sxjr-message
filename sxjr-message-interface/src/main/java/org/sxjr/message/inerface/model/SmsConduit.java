package org.sxjr.message.inerface.model;

public class SmsConduit extends BaseEntity {
	
	private String id;
	//通道名称
	private String name;
	//通道ID
	private String conduitId;
	//账户
	private String account;
	//密码
	private String password;
	//支付长短信
	private String isLong;
	//批量发送
	private String isBulk;
	//发送间隔
	private String phoneTimeSpan;
	//一天内最大次数
	private String phoneMaxCount;
	//短信最大长度
	private String maxLength;
	//权重
	private String priority;
	//状态
	private String state;
	
	public String getPhoneTimeSpan() {
		return phoneTimeSpan;
	}
	public void setPhoneTimeSpan(String phoneTimeSpan) {
		this.phoneTimeSpan = phoneTimeSpan;
	}
	public String getPhoneMaxCount() {
		return phoneMaxCount;
	}
	public void setPhoneMaxCount(String phoneMaxCount) {
		this.phoneMaxCount = phoneMaxCount;
	}
	public String getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(String maxLength) {
		this.maxLength = maxLength;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConduitId() {
		return conduitId;
	}
	public void setConduitId(String conduitId) {
		this.conduitId = conduitId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsLong() {
		return isLong;
	}
	public void setIsLong(String isLong) {
		this.isLong = isLong;
	}
	public String getIsBulk() {
		return isBulk;
	}
	public void setIsBulk(String isBulk) {
		this.isBulk = isBulk;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
