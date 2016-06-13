package com.sxjr.app.msgmodel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxjr.app.model.SmsTemplate;
import com.sxjr.app.msgmodel.mapper.MsgModelMapper;
import com.sxjr.app.msgmodel.service.MsgModelService;

/**
 * Created by wangrq on 2016/6/2.
 */
@Service
@Transactional
public class MsgModelServiceImpl implements MsgModelService {

    @Autowired
    private MsgModelMapper msgModelMapper;

//	@Override
//	public boolean save(SmsTemplate msgmodel) {
//		boolean result = false;
//		if(coutnStr(msgmodel.getContent()) > 5 ){
//    		result = false;
//    	}else{
//    		if(msgModelMapper.save(msgmodel) > 0){
//    			result = true;
//    		}
//    	}
//		return result;
//		
//	}

	@Override
	public List<SmsTemplate> list() {
		return msgModelMapper.list();
	}

	@Override
	public SmsTemplate findOne(String id) {
		return msgModelMapper.findOne(id);
	}

	@Override
	public void update(SmsTemplate msgmodel) {
		msgModelMapper.update(msgmodel);
	}

	@Override
	public void delete(String id) {
		msgModelMapper.delete(id);
		
	}

	@Override
	public void disable(SmsTemplate msgmodel) {
		msgModelMapper.update(msgmodel);
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
