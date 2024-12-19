package com.usermanagement.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.usermanagement.Config.CustomException;
import com.usermanagement.Entities.UserMaster;
import com.usermanagement.Service.UserMasterService;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserMasterService userMasterService;
	
	
	@PostMapping("/create")
	public ResponseEntity<?> CreateUser(@RequestBody UserMaster user) {
	    try {
	        UserMaster saveUser = this.userMasterService.createUser(user);
	        return ResponseEntity.ok(saveUser);
	    } catch (CustomException e) {
	        
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	    }
	}
	
	
	@GetMapping("/getusers")
	public ResponseEntity<?> getUsers() {
	    try {
	        List<UserMaster> userList = this.userMasterService.getusers();
	        return ResponseEntity.ok(userList);
	    } catch (CustomException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	    }
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<?> updateusers(@RequestBody UserMaster users, @PathVariable int id) {
	    try {
	        UserMaster updatedUser = this.userMasterService.updateUser(id, users);
	        return ResponseEntity.ok(updatedUser);
	    } catch (CustomException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	    }
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
	    try {
	        if (this.userMasterService.DeleteUser(id)) {
	            return ResponseEntity.status(HttpStatus.OK).body("Record deleted successfully of id: " + id);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: " + id);
	        }
	    } catch (CustomException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	    }
	}

}
