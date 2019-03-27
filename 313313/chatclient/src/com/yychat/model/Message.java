package com.yychat.model;

import java.io.Serializable;

public class Message implements Serializable{//注意程序要序列化
      private String sender;
      private String receiver;
      private String messageType;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
}
