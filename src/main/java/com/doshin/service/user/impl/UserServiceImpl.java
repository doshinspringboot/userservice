package com.doshin.service.user.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.doshin.service.user.bao.UserBao;
import com.doshin.service.user.model.UserVO;

@RestController
public class UserServiceImpl {

	@Autowired
	UserBao userBao;

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
	public @ResponseBody  UserVO findByUserId(@PathVariable("userid") Integer userId) {
		System.out.println("Doshin");
		System.out.println(userId);
		return userBao.findByUserId(userId);
	}

}