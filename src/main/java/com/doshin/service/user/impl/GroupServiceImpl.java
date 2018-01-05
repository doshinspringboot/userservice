package com.doshin.service.user.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.doshin.service.user.bao.GroupBao;
import com.doshin.service.user.model.GroupVO;

@RestController
public class GroupServiceImpl {

	@Autowired
	GroupBao groupBao;

	@PostMapping(value = "/group",  consumes = MediaType.APPLICATION_XML_VALUE,
			produces = MediaType.APPLICATION_XML_VALUE)
	public void save(@RequestBody GroupVO group) {
		groupBao.save(group);
	}
	
	@GetMapping(value = "/group/{groupid}", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody GroupVO findByGroupId(@PathVariable("groupid") Integer groupId) {
		return groupBao.findByGroupId(groupId);
	}
}