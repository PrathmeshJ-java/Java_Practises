package com.ContactManagerProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.tokens.FlowEntryToken;

import com.ContactManagerProject.Entities.Userlogauth;
import com.ContactManagerProject.service.UserService;
import com.mysql.cj.exceptions.WrongArgumentException;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/saveuser")
	public ResponseEntity<Userlogauth> saveUserDetails(@RequestBody Userlogauth userlog){
	   Userlogauth userlogauth = userService.saveuserlogDetails(userlog);
	   
	   if(userlogauth!= null) {
		   return ResponseEntity.ok(userlogauth);
	   }
		
	   return ResponseEntity.internalServerError().body(userlog);
	}
	
	@GetMapping("/logincheck")
	public ResponseEntity<Boolean> loginCheck(@RequestBody Userlogauth userlogauth){
		Boolean isrecord = userService.logincheck(userlogauth);
		if(isrecord) {
			return ResponseEntity.ok(true);
		}
		
		return ResponseEntity.ofNullable(false);
	}

}
