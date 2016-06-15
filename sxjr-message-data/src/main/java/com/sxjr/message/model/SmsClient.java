package com.sxjr.message.model;

import java.util.Date;

public class SmsClient {
    private Integer id;

    private String name;

    private String assesstoken;

    private String assesssecret;

    private Boolean state;

    private String iplist;

    private Date createdate;

    private Date updatedate;

    private String create;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAssesstoken() {
        return assesstoken;
    }

    public void setAssesstoken(String assesstoken) {
        this.assesstoken = assesstoken == null ? null : assesstoken.trim();
    }

    public String getAssesssecret() {
        return assesssecret;
    }

    public void setAssesssecret(String assesssecret) {
        this.assesssecret = assesssecret == null ? null : assesssecret.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getIplist() {
        return iplist;
    }

    public void setIplist(String iplist) {
        this.iplist = iplist == null ? null : iplist.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create == null ? null : create.trim();
    }
}