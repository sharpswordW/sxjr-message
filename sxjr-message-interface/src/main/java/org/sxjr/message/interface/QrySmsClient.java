package interfaces;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.sxjr.app.msgmanage.entity.SmClientInfo;
import com.sxjr.app.until.RedisUtil;

public class QrySmsClient {

	@Autowired
	private RedisUtil redisUtil;
	
	private static final String CLIENT_KEY = "smClient.info.";
	public boolean isExists(String key,String screteID) {
		 Object result = redisUtil.get(CLIENT_KEY+key);
		 if(result != null ){
	            SmClientInfo smClientInfo= JSON.parseObject(result.toString(),SmClientInfo.class);
	            if (screteID.equals(smClientInfo.getAssessSecret()) && "0".equals(smClientInfo.getStatus())) {
					return true;
				}
	        }
		
		return false;
		
	}
	public RedisUtil getRedisUtil() {
		return redisUtil;
	}
	public void setRedisUtil(RedisUtil redisUtil) {
		this.redisUtil = redisUtil;
	}
}
