package com.doshin.service.user.impl;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.doshin.service.user.bao.UserBao;
import com.doshin.service.user.model.UserVO;
import com.doshin.spring.UserGauageService;

@RestController
public class UserServiceImpl {

	@Autowired
	UserBao userBao;
	
	@Autowired
	UserGauageService userGauageService;
	
	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@PostMapping(value ="/user", consumes = MediaType.APPLICATION_XML_VALUE,
			produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody UserVO save(@RequestBody UserVO user) {
		System.out.println("Doshin");
		System.out.println(user);
		return userBao.save(user);
		
	}

	@PutMapping(value ="/user", consumes = MediaType.APPLICATION_XML_VALUE,
	produces = MediaType.APPLICATION_XML_VALUE)
	public void update(@RequestBody UserVO user) {
		userBao.update(user);

		
	}

	@DeleteMapping(value ="/user", consumes = MediaType.APPLICATION_XML_VALUE,
	produces = MediaType.APPLICATION_XML_VALUE)
	public void delete(@RequestBody UserVO user) {
		userBao.delete(user);
	}

	@GetMapping(value = "/user/{userid}", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody  UserVO findByUserId(@PathVariable("userid") Integer userId, 
			@RequestHeader("x-forwarded-host") Optional<String> host, 
			@RequestHeader("x-forwarded-port") Optional<String> port) {
		logger.info("User service started for : "  +userId );
		if(host.isPresent() && port.isPresent()) {
			logger.info("User service called from proxy service : "  + host.get() + " port : " + port.get());
		}

		userGauageService.increment("userid.call.count");
		Long start = System.nanoTime();
		UserVO user = userBao.findByUserId(userId);
		logger.info("User service returning for : "  +userId + " User : " + user);

		userGauageService.submit("userid.avg.time", (double) ((System.nanoTime() - start)/1000));
		return user;
	}

}