package com.sxjr.message.model;

import java.util.Date;

public class LogConduitStatistics {
    private Integer id;

    private Date startdate;

    private Date enddate;

    private String conduitid;

    private Integer smscount;

    private Integer successcount;

    private Integer errorcount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getConduitid() {
        return conduitid;
    }

    public void setConduitid(String conduitid) {
        this.conduitid = conduitid == null ? null : conduitid.trim();
    }

    public Integer getSmscount() {
        return smscount;
    }

    public void setSmscount(Integer smscount) {
        this.smscount = smscount;
    }

    public Integer getSuccesscount() {
        return successcount;
    }

    public void setSuccesscount(Integer successcount) {
        this.successcount = successcount;
    }

    public Integer getErrorcount() {
        return errorcount;
    }

    public void setErrorcount(Integer errorcount) {
        this.errorcount = errorcount;
    }
}