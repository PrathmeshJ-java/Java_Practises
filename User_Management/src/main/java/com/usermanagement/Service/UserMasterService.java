package com.usermanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.Config.CustomException;
import com.usermanagement.Config.UserNotFoundException;
import com.usermanagement.Entities.UserMaster;
import com.usermanagement.Repository.UserMasterRepository;

@Service
public class UserMasterService {
	
	@Autowired
	private UserMasterRepository userMasterRepository;
	
	public UserMaster createUser(UserMaster user) {
		try {	
		return this.userMasterRepository.save(user);
		
		} catch (Exception e) {
            
            throw new CustomException("Failed to create user", e);
        }
	}
	
   public List<UserMaster> getusers(){
	  List<UserMaster> user = this.userMasterRepository.findAll();
	  return user;  
	  }
   
   public UserMaster updateUser(int id, UserMaster user) {
       try {
           Optional<UserMaster> userOptional = userMasterRepository.findById(id);
           if (userOptional.isPresent()) {
               UserMaster existingUser = userOptional.get();
               existingUser.setUserName(user.getUserName());
               existingUser.setUserPassword(user.getUserPassword());
               existingUser.setDateOfRegistration(user.getDateOfRegistration());
               existingUser.setStatus(user.getStatus());
               existingUser.setUserAddress(user.getUserAddress());

               return userMasterRepository.save(existingUser);
           } else {
               throw new UserNotFoundException("User not found");
           }
       } catch (Exception e) {
           throw new CustomException("Failed to update user", e);
       }
   }
   
   
    public boolean DeleteUser(int id) {
    	Optional<UserMaster> userOptional = this.userMasterRepository.findById(id);
    	if(userOptional.isPresent()) {
    		this.userMasterRepository.deleteById(id);
    		return true;
    	}
    	
    	return false;
    }
	   
	  
   
    }
