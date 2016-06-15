package com.sxjr.app.service;

import com.sxjr.app.model.SmClientInfo;

public interface IQrySmsClient {

	SmClientInfo isExists(String key,String screteID); 
}
