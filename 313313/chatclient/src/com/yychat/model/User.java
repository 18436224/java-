package com.yychat.model;

import java.io.Serializable;

public class User implements Serializable{//序列化窗口
	private String userName;
    private String passWord;
    private String userMessageType;//让登录与注册分开
    
    
	public String getUserMessageType() {
		return userMessageType;
	}
	public void setUserMessageType(String userMessageType) {
		this.userMessageType = userMessageType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
