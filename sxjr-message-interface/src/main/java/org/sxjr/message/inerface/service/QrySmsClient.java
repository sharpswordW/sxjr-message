package org.sxjr.message.inerface.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.sxjr.message.inerface.model.SmClientInfo;

import com.alibaba.fastjson.JSON;
import com.sxjr.common.util.RedisUtil;

public class QrySmsClient {

	@Autowired
	private static RedisUtil redisUtil;
	private static final String STATUS="1";
	private static final String CLIENT_KEY = "smClient.info.";
	public static boolean isExists(String key,String screteID) {
		 Object result = redisUtil.get(CLIENT_KEY+key);
		 if(result != null ){
	            SmClientInfo smClientInfo= JSON.parseObject(result.toString(),SmClientInfo.class);
	            if (screteID.equals(smClientInfo.getAssessSecret()) && STATUS.equals(smClientInfo.getStatus())) {
					return true;
				}
	        }
		
		return false;
		
	}
	
}