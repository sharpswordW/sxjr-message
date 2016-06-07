package com.sxjr.app.sequence.entity;

public class Sequence {
	
	private String name;
	
	private int currentValue;
	
	private int incrementValue;
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}

	public int getIncrementValue() {
		return incrementValue;
	}

	public void setIncrementValue(int incrementValue) {
		this.incrementValue = incrementValue;
	}

}
