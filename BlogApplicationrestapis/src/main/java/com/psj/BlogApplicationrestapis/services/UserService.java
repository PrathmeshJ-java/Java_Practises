package com.psj.BlogApplicationrestapis.services;

import java.util.List;

import com.psj.BlogApplicationrestapis.payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, int userId);
	
    UserDto getUser(int userId);
    
    List<UserDto> getAllUsers();
    
    void deleteUser(int userId);
}
