package com.psj.BlogApplicationrestapis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.psj.BlogApplicationrestapis.payloads.ApiResponse;
import com.psj.BlogApplicationrestapis.payloads.UserDto;
import com.psj.BlogApplicationrestapis.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class userController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto creadtedUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(creadtedUserDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateuser/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable int userId){
		UserDto updateUser = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updateUser);		
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable int userId){
		this.userService.deleteUser(userId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
	}
	
	@GetMapping("/getallusers")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@GetMapping("/getuser/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable int userId){
		return ResponseEntity.ok(this.userService.getUser(userId));
	}
	
	
}
