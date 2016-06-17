package com.sxjr.app.msgmodel.interfaces;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.sxjr.app.model.SmsTemplate;
import com.sxjr.app.msgmodel.mapper.MsgModelMapper;
import com.sxjr.app.service.MsgModelInterface;
import com.sxjr.common.util.RedisUtil;
@Service("msgModelInterface")
public class MsgModelInterfaceImpl implements MsgModelInterface{
	
	private static Logger logger = LoggerFactory.getLogger(MsgModelInterfaceImpl.class);
	
	@Autowired
    private MsgModelMapper msgModelMapper;
	@Autowired
    private RedisUtil redisUtil;

	@Override
	public int save(String content) {
		SmsTemplate template = new SmsTemplate();
		template.setContent(content);
		template.setCreateBy("system");
		template.setCreateDate(new Date());
		template.setUpdateDate(new Date());
		template.setState("1");
		int result = 0;
		if(coutnStr(template.getContent()) > 5 ){
    		result = 0;
    	}else{
    		if(msgModelMapper.save(template) > 0);{
    			result =  Integer.parseInt(template.getId());
    			logger.info("新注册模板,id="+ template.getId() + "模板内容:" + content);
    			String obj = JSON.toJSON(template).toString();
    	    	redisUtil.HSET("SmsTemplate", template.getId(), obj);
    		}
    	}
		return result;
	}
	
	private int coutnStr(String str){
    	char []array=str.toCharArray();  
    	String targetStr = "{";
    	int count = 0;
    	for(int i = 0;i < array.length ;i++){
    		String cstr=String.valueOf(array[i]);
    		if(targetStr.equals(cstr)){  
                count++;
            }
    	}
    	return count;
    }

}
