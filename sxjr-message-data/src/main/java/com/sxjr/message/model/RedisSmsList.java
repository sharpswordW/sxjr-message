package com.sxjr.message.model;


import java.util.ArrayList;
import java.util.List;



public class RedisSmsList extends RedisBaseEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = 654482496054926598L;
	
	private int count;
	
	private List<RedisSms> smsList;
		


	public RedisSmsList()
	{
		count = 0;
		smsList = new ArrayList<RedisSms>();
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	public List<RedisSms> getSmsList() {
		return smsList;
	}

	public void setSmsList(List<RedisSms> smsList) {		
		this.smsList = smsList;
	}
		
	
}
