package com.sxjr.app.model;


public class SmClientInfo extends BaseEntity {

	 /**
     * 员工ID
     */
    private String id;
    /**
     * 终端名称
     */
    private String name;
    /**
     * 接入账号
     */
    private String assessToken;
    /**
     * 接入凭证
     */
    private String assessSecret;

    /**
     * 状态
     */
    private String status;
    
    /**
     * 状态
     */
    private String IPList;

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

	public String getAssessToken() {
		return assessToken;
	}

	public void setAssessToken(String assessToken) {
		this.assessToken = assessToken;
	}

	public String getAssessSecret() {
		return assessSecret;
	}

	public void setAssessSecret(String assessSecret) {
		this.assessSecret = assessSecret;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIPList() {
		return IPList;
	}

	public void setIPList(String iPList) {
		IPList = iPList;
	}

	@Override
	public String toString() {
		return "SmClientInfo [id=" + id + ", name=" + name + ", assessToken="
				+ assessToken + ", assessSecret=" + assessSecret + ", status="
				+ status + ", IPList=" + IPList + "]";
	}
  
}
