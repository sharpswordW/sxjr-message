package com.sxjr.app.msgmanage.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.sxjr.app.model.SmClientInfo;
import com.sxjr.app.service.IQrySmsClient;
import com.sxjr.common.util.RedisUtil;

@Service("qrySmsClient")
public class QrySmsClientImpl implements IQrySmsClient {

	@Autowired
	private RedisUtil redisUtil;
	/**
	 * 存入redis中的key前缀
	 */
	private static final String CLIENT_KEY = "smClient.info.";

	private Logger logger = Logger.getLogger(QrySmsClientImpl.class);

	/**
	 * 判断客户端信息key是否存在并且判断接入码screteID是否正确和客户端STATUS是否是可用状态
	 *
	 * @param key
	 *            客户端接入账号 screteID 接入凭证
	 * @return
	 * 
	 */
	@Override
	public SmClientInfo isExists(String assessToken, String assessSecret) {
		Object result = redisUtil.GET(CLIENT_KEY + assessToken);
		SmClientInfo smClientInfo = null;
		if (result != null) {
			smClientInfo = JSON.parseObject(result.toString(),
					SmClientInfo.class);
			if (assessSecret.equals(smClientInfo.getAssessSecret())
					&& smClientInfo.isState()) {
				logger.info("the " + smClientInfo.getName() + " is available");
				return smClientInfo;
			}
		}
		logger.info("the accessToken:" + assessToken
				+ " is unavailable,please make sure accessToken:" + assessToken
				+ "and assessSecret:" + assessSecret
				+ "are exists in redis and state is true ");
		return smClientInfo;
	}

}
