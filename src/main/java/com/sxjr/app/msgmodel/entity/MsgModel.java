package com.sxjr.app.msgmodel.entity;

import com.sxjr.app.common.BaseEntity;

public class MsgModel extends BaseEntity{
	
	private String id;
	
	private String modelId;
	
	private String content;
	
	private String enable;

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

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
