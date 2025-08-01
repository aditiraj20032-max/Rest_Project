package com.example.rest;

import java.time.LocalDate;

public class Message {
	private String content;
	private LocalDate deliveredOn;
	public Message() {
		content ="Happy New Year";
		deliveredOn=LocalDate.of(2002, 1, 1);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDate getDeliveredOn() {
		return deliveredOn;
	}
	public void setDeliveredOn(LocalDate deliveredOn) {
		this.deliveredOn = deliveredOn;
	}
}
