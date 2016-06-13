package com.sxjr.app.model;

/**
 * Created by wangrq on 2016/6/6.
 */
public class Conduit extends BaseEntity{
	
	private String id;
	
	private String conduitId;
	
	private String name;
	
	private String account;
	
	private String password;
	
	private String longMessage;
	
	private String bulkMessage;
	
	private String priority;
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConduitId() {
		return conduitId;
	}

	public void setConduitId(String conduitId) {
		this.conduitId = conduitId;
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

	public String getLongMessage() {
		return longMessage;
	}

	public void setLongMessage(String longMessage) {
		this.longMessage = longMessage;
	}

	public String getBulkMessage() {
		return bulkMessage;
	}

	public void setBulkMessage(String bulkMessage) {
		this.bulkMessage = bulkMessage;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

}
