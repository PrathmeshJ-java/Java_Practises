package com.psj.springAOP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.psj.springAOP.services.userService;

@RestController
public class UserController {
	
	@Autowired
	private userService userService;
	
	@GetMapping("/user/{id}")
	public String getUserInfo(@PathVariable int id) {
		return userService.userInfo(id);
	} 

}
