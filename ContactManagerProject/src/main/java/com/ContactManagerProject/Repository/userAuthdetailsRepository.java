package com.ContactManagerProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ContactManagerProject.Entities.Userlogauth;

public interface userAuthdetailsRepository extends JpaRepository<Userlogauth, String>{
	
	Userlogauth findByUsername(String username);

}
