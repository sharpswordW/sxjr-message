package com.sxjr.message.model;

import java.util.Date;

public class SmsConduit {
    private Integer id;

    private Integer conduitid;

    private String name;

    private String serialno;

    private String account;

    private String password;

    private String islong;

    private String isbulk;

    private Integer phonetimespan;

    private Integer phonemaxcount;

    private Integer maxlength;

    private Integer priority;

    private String state;

    private String createby;

    private Date createdate;

    private Date updatedate;

    private String create;

    private String regtext;

    private String updateby;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConduitid() {
        return conduitid;
    }

    public void setConduitid(Integer conduitid) {
        this.conduitid = conduitid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno == null ? null : serialno.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIslong() {
        return islong;
    }

    public void setIslong(String islong) {
        this.islong = islong == null ? null : islong.trim();
    }

    public String getIsbulk() {
        return isbulk;
    }

    public void setIsbulk(String isbulk) {
        this.isbulk = isbulk == null ? null : isbulk.trim();
    }

    public Integer getPhonetimespan() {
        return phonetimespan;
    }

    public void setPhonetimespan(Integer phonetimespan) {
        this.phonetimespan = phonetimespan;
    }

    public Integer getPhonemaxcount() {
        return phonemaxcount;
    }

    public void setPhonemaxcount(Integer phonemaxcount) {
        this.phonemaxcount = phonemaxcount;
    }

    public Integer getMaxlength() {
        return maxlength;
    }

    public void setMaxlength(Integer maxlength) {
        this.maxlength = maxlength;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
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

    public String getRegtext() {
        return regtext;
    }

    public void setRegtext(String regtext) {
        this.regtext = regtext == null ? null : regtext.trim();
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }
}