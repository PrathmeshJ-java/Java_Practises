package com.ContactManagerProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ContactManagerProject.Entities.Userlogauth;
import com.ContactManagerProject.Repository.userAuthdetailsRepository;

@Service
public class UserService {
	
	@Autowired
	userAuthdetailsRepository userAuthRepo;
	
	public Userlogauth saveuserlogDetails(Userlogauth userlogauth) {
		return userAuthRepo.save(userlogauth);
	}
	
	public Boolean logincheck(Userlogauth userlogauth) {
		Userlogauth userauthdetailsUserlogauth =userAuthRepo.findByUsername(userlogauth.getUsername());
		if(userlogauth.getPassword().equals(userauthdetailsUserlogauth.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}

}
