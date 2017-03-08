package com.qazit.sysmanager.web.model;

/**
 * 微信调用接口统一返回格式
 * 
 * @author Gaohaibo
 * 
 */
public class JsonResultMessage {
	// 调用接口，状态
	String resultCode;
	// 调用接口返回具体的内容
	Object data;
	
	public void setJsonData(String resultCode,Object data){
		this.resultCode = resultCode;
		this.data = data;
	}

	public String getResultCode() {
		return resultCode;
	}
    
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
