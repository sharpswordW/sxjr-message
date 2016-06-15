package com.sxjr.app.msgmanage.service;

import java.util.List;

import com.sxjr.app.model.SmClientInfo;


public interface SmsManageService {

	int addClient(SmClientInfo smClientInfo);
	List<SmClientInfo> list();
	SmClientInfo findOne(String id);
	SmClientInfo selectbyName(String name);
    void update(SmClientInfo smClientInfo);
    void delete(SmClientInfo smClientInfo);
}
