package com.sxjr.app.msgmodel.interfaces;

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
	public boolean save(SmsTemplate msgmodel) {
		boolean result = false;
		if(coutnStr(msgmodel.getContent()) > 5 ){
    		result = false;
    	}else{
    		if(msgModelMapper.save(msgmodel) > 0){
    			result = true;
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
