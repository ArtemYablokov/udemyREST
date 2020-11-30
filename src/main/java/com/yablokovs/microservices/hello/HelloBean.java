package com.yablokovs.microservices.hello;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {
	private String value;
	
	public HelloBean() { }
	
	public HelloBean(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}