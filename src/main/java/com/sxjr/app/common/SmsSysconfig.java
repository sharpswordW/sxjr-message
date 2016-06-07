package com.sxjr.app.common;

public class SmsSysconfig {

	private String configName;
	
	private String configValue;
	
	private String clientPhoneCount;
	
	private String clientPhoneTemplet;
	
	private String clientPhoneTimeSpan;
	
	private String clientBulk;
	
	private String conduitPhoneSecond;
	
	private String conduitBulkSecond;
	
	private String conduitPhoneCount;
	
	private String conduitPhoneRepeat;
	
	public String getConfigName() {
		return configName;
	}
	public void setConfigName(String configName) {
		this.configName = configName;
	}
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	public String getClientPhoneCount() {
		return clientPhoneCount;
	}
	public void setClientPhoneCount(String clientPhoneCount) {
		this.clientPhoneCount = clientPhoneCount;
	}
	public String getClientPhoneTemplet() {
		return clientPhoneTemplet;
	}
	public void setClientPhoneTemplet(String clientPhoneTemplet) {
		this.clientPhoneTemplet = clientPhoneTemplet;
	}
	public String getClientPhoneTimeSpan() {
		return clientPhoneTimeSpan;
	}
	public void setClientPhoneTimeSpan(String clientPhoneTimeSpan) {
		this.clientPhoneTimeSpan = clientPhoneTimeSpan;
	}
	public String getClientBulk() {
		return clientBulk;
	}
	public void setClientBulk(String clientBulk) {
		this.clientBulk = clientBulk;
	}
	public String getConduitPhoneSecond() {
		return conduitPhoneSecond;
	}
	public void setConduitPhoneSecond(String conduitPhoneSecond) {
		this.conduitPhoneSecond = conduitPhoneSecond;
	}
	public String getConduitBulkSecond() {
		return conduitBulkSecond;
	}
	public void setConduitBulkSecond(String conduitBulkSecond) {
		this.conduitBulkSecond = conduitBulkSecond;
	}
	public String getConduitPhoneCount() {
		return conduitPhoneCount;
	}
	public void setConduitPhoneCount(String conduitPhoneCount) {
		this.conduitPhoneCount = conduitPhoneCount;
	}
	public String getConduitPhoneRepeat() {
		return conduitPhoneRepeat;
	}
	public void setConduitPhoneRepeat(String conduitPhoneRepeat) {
		this.conduitPhoneRepeat = conduitPhoneRepeat;
	}
	@Override
	public String toString() {
		return "SmsSysconfig [configName=" + configName + ", configValue="
				+ configValue + ", clientPhoneCount=" + clientPhoneCount
				+ ", clientPhoneTemplet=" + clientPhoneTemplet
				+ ", clientPhoneTimeSpan=" + clientPhoneTimeSpan
				+ ", clientBulk=" + clientBulk + ", conduitPhoneSecond="
				+ conduitPhoneSecond + ", conduitBulkSecond="
				+ conduitBulkSecond + ", conduitPhoneCount="
				+ conduitPhoneCount + ", conduitPhoneRepeat="
				+ conduitPhoneRepeat + "]";
	}
	
}
