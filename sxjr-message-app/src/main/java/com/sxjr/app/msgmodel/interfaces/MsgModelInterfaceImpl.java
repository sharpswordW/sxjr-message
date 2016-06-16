package com.sxjr.app.msgmodel.interfaces;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxjr.app.model.SmsTemplate;
import com.sxjr.app.msgmodel.mapper.MsgModelMapper;
import com.sxjr.app.service.MsgModelInterface;
@Service("msgModelInterface")
public class MsgModelInterfaceImpl implements MsgModelInterface{
	
	@Autowired
    private MsgModelMapper msgModelMapper;

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
