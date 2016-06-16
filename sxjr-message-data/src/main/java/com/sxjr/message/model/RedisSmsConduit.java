package com.sxjr.message.model;



public class RedisSmsConduit extends RedisBaseEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = 654482496054926598L;
	
	
	
	private Integer id;

    private String content;

    private String clientid;
	
		
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid == null ? null : clientid.trim();
    }
	
	
	
}
