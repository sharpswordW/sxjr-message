package com.sxjr.message.model;

import java.util.Date;

public class LogSysStatistics {
    private Integer id;

    private Date startdate;

    private Date enddate;

    private Integer clientsmscount;

    private Integer clienterrorcount;

    private Integer conduitsmscount;

    private Integer conduiterrorcount;

    private Integer rediserror;

    private Integer mysqlerror;

    private Integer syserror;

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

    public Integer getClientsmscount() {
        return clientsmscount;
    }

    public void setClientsmscount(Integer clientsmscount) {
        this.clientsmscount = clientsmscount;
    }

    public Integer getClienterrorcount() {
        return clienterrorcount;
    }

    public void setClienterrorcount(Integer clienterrorcount) {
        this.clienterrorcount = clienterrorcount;
    }

    public Integer getConduitsmscount() {
        return conduitsmscount;
    }

    public void setConduitsmscount(Integer conduitsmscount) {
        this.conduitsmscount = conduitsmscount;
    }

    public Integer getConduiterrorcount() {
        return conduiterrorcount;
    }

    public void setConduiterrorcount(Integer conduiterrorcount) {
        this.conduiterrorcount = conduiterrorcount;
    }

    public Integer getRediserror() {
        return rediserror;
    }

    public void setRediserror(Integer rediserror) {
        this.rediserror = rediserror;
    }

    public Integer getMysqlerror() {
        return mysqlerror;
    }

    public void setMysqlerror(Integer mysqlerror) {
        this.mysqlerror = mysqlerror;
    }

    public Integer getSyserror() {
        return syserror;
    }

    public void setSyserror(Integer syserror) {
        this.syserror = syserror;
    }
}