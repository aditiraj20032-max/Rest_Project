package com.example.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // marks class as implementation class for rest endpoints
public class RestImpl {
	@RequestMapping("/do-greet") // this annotation marks method as request handling method
	public String doGreet() {
		return "Welcom to REST";
	}
	
	@RequestMapping("/get-message")
	public Message getMessage() {
		return new Message();
	}
//	@RequestMapping("/get-all-message")
//	public List<E>
	
}

