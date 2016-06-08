package com.sxjr.app.common;

import java.util.Properties;


public class ParseProperties {

	private Properties properties; 
	
	public Properties getProperties() {
		return properties;
	}


	public void setProperties(Properties properties) {
		this.properties = properties;
	}


	public  String getValue(String key) {
		 
		return properties.getProperty(key);
		
	}

	
}
