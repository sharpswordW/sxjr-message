package com.sxjr.app.msgmanage.service;

import java.util.List;

import com.sxjr.app.msgmanage.entity.SmClientInfo;

public interface SmsManageService {

	int addClient(SmClientInfo smClientInfo);
	List<SmClientInfo> list();
	SmClientInfo findOne(String id);
    void update(SmClientInfo smClientInfo);
    void delete(String id);
}
