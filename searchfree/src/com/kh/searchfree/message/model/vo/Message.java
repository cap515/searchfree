package com.kh.searchfree.message.model.vo;

import java.sql.Date;

public class Message {

	private int messageNo;
	private String messageTitle;
	private char messageDeleteYN;
	private Date messageCreateDT;
	private int senderNo;
	private int receiverNo;
	private String messageContent;
	private String senderNick;
	
	public Message() {
		super();
	}
	

	public Message(String messageTitle, int senderNo, String messageContent) {
		super();
		this.messageTitle = messageTitle;
		this.senderNo = senderNo;
		this.messageContent = messageContent;
	}


	public Message(int messageNo, String messageTitle, Date messageCreateDT,  int receiverNo,
			String messageContent, String senderNick) {
		super();
		this.messageNo = messageNo;
		this.messageTitle = messageTitle;
		this.messageCreateDT = messageCreateDT;
		this.receiverNo = receiverNo;
		this.messageContent = messageContent;
		this.senderNick = senderNick;
	}



	public Message(int messageNo, String messageTitle, Date messageCreateDT, String messageContent, String senderNick) {
		super();
		this.messageNo = messageNo;
		this.messageTitle = messageTitle;
		this.messageCreateDT = messageCreateDT;
		this.messageContent = messageContent;
		this.senderNick = senderNick;
	}


	public Message(int messageNo, String messageTitle, char messageDeleteYN, Date messageCreateDT, int senderNo,
			int receiverNo, String messageContent) {
		super();
		this.messageNo = messageNo;
		this.messageTitle = messageTitle;
		this.messageDeleteYN = messageDeleteYN;
		this.messageCreateDT = messageCreateDT;
		this.senderNo = senderNo;
		this.receiverNo = receiverNo;
		this.messageContent = messageContent;
	}





	





	public int getMessageNo() {
		return messageNo;
	}





	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}





	public String getMessageTitle() {
		return messageTitle;
	}





	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}





	public char getMessageDeleteYN() {
		return messageDeleteYN;
	}





	public void setMessageDeleteYN(char messageDeleteYN) {
		this.messageDeleteYN = messageDeleteYN;
	}





	public Date getMessageCreateDT() {
		return messageCreateDT;
	}





	public void setMessageCreateDT(Date messageCreateDT) {
		this.messageCreateDT = messageCreateDT;
	}





	public int getSenderNo() {
		return senderNo;
	}





	public void setSenderNo(int senderNo) {
		this.senderNo = senderNo;
	}





	public int getReceiverNo() {
		return receiverNo;
	}





	public void setReceiverNo(int receiverNo) {
		this.receiverNo = receiverNo;
	}





	public String getMessageContent() {
		return messageContent;
	}





	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}





	public String getSenderNick() {
		return senderNick;
	}





	public void setSenderNick(String senderNick) {
		this.senderNick = senderNick;
	}





	@Override
	public String toString() {
		return "Message [messageNo=" + messageNo + ", messageTitle=" + messageTitle + ", messageDeleteYN="
				+ messageDeleteYN + ", messageCreateDT=" + messageCreateDT + ", senderNo=" + senderNo + ", receiverNo="
				+ receiverNo + ", messageContent=" + messageContent + ", senderNick=" + senderNick + "]";
	}

	

	
	
}
