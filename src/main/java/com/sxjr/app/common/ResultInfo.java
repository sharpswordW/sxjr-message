package com.sxjr.app.common;

import java.util.List;

public class ResultInfo<T> {

	private String resultMessage;
	private String resultCode;
	private List<T> resultList;
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	@Override
	public String toString() {
		return "ResultInfo [resultMessage=" + resultMessage + ", resultCode="
				+ resultCode + ", resultList=" + resultList + "]";
	}
}
