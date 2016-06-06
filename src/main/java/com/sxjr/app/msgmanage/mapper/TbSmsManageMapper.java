package com.sxjr.app.msgmanage.mapper;

import java.util.List;

import com.sxjr.app.msgmanage.entity.SmClientInfo;

public interface TbSmsManageMapper {

	 int save(SmClientInfo smClientInfo);
	 List<SmClientInfo> list();
	 SmClientInfo findOne(String id);
	    void update(SmClientInfo smClientInfo);
	    void delete(String id);
}
