package com.sxjr.app.msgmanage.mapper;

import java.util.List;

import com.sxjr.app.model.SmClientInfo;

public interface TbSmsManageMapper {

	 int save(SmClientInfo smClientInfo);
	 List<SmClientInfo> list();
	 SmClientInfo selectbyid(String id);
	 SmClientInfo selectbyName(String name);
	 void update(SmClientInfo smClientInfo);
	 void delete(String id);
}
