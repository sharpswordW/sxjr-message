package com.sxjrmsg.app.msgmodel.entity;

import com.sxjrmsg.app.common.BaseEntity;

public class MsgModel extends BaseEntity{
	
	private String id;
	
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
