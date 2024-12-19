package com.example.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserRepository;
import com.example.user.User;




@RestController
@ResponseBody
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	@PostMapping("/save")
	public void save(@RequestBody User user) {
		
		
		
		ArrayList<User> list = new ArrayList();
		
		list.add(new User(1,"Prathmesh","Amravati"));
		list.add(new User(2,"Shivam","Yavatmal"));
		list.add(new User(3,"Krushna","Beed"));
		list.add(new User(4,"Pravin","Ahmadnagar"));
		System.out.println("Data Is:" +list);
		
		repo.save(list);
		
	}
	
	

}
