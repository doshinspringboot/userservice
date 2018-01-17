package com.doshin.spring;

import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

@Component
public class CheckEnpoint extends AbstractEndpoint<String> {

	public CheckEnpoint() {
		super("CheckEnpoint");
	}

	@Override
	public String invoke() {
		return "Doshin checking!";
	}

}
