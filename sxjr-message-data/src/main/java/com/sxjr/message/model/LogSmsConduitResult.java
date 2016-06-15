package com.sxjr.message.model;

import java.util.Date;

public class LogSmsConduitResult {
    private String smsid;

    private String phonenumber;

    private String templetid;

    private String smspara;

    private String clientid;

    private String conduitid;

    private Date senddate;

    private String errormsg;

    public String getSmsid() {
        return smsid;
    }

    public void setSmsid(String smsid) {
        this.smsid = smsid == null ? null : smsid.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getTempletid() {
        return templetid;
    }

    public void setTempletid(String templetid) {
        this.templetid = templetid == null ? null : templetid.trim();
    }

    public String getSmspara() {
        return smspara;
    }

    public void setSmspara(String smspara) {
        this.smspara = smspara == null ? null : smspara.trim();
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid == null ? null : clientid.trim();
    }

    public String getConduitid() {
        return conduitid;
    }

    public void setConduitid(String conduitid) {
        this.conduitid = conduitid == null ? null : conduitid.trim();
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg == null ? null : errormsg.trim();
    }
}