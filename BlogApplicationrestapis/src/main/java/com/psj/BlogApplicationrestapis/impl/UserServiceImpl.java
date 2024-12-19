package com.psj.BlogApplicationrestapis.impl;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.psj.BlogApplicationrestapis.exceptions.*;

import com.psj.BlogApplicationrestapis.Entities.User;
import com.psj.BlogApplicationrestapis.payloads.UserDto;
import com.psj.BlogApplicationrestapis.repositories.UserRepository;
import com.psj.BlogApplicationrestapis.services.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userdto) {
		User user= this.dtoToUser(userdto);
		User saveUser = this.userRepo.save(user);
		return this.userToDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userdto, int userId) {
		Optional<User> existingUser = Optional.of(this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", "id ", userId)));	
		User user = existingUser.get();
		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setAbout(userdto.getAbout());
		User updatedUser = this.userRepo.save(user);
		return userToDto(updatedUser);		
	}

	@Override
	public UserDto getUser(int userId) {
		Optional<User> user = Optional.of(this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", "id ", userId)));	
		return this.userToDto(user.get());
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());	
		return userDtos;	
	}

	@Override
	public void deleteUser(int userId) {
		Optional<User> user = Optional.of(this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", "id ", userId)));
		
		if(user.isPresent()) {
			this.userRepo.deleteById(userId);
			}
		
	}
	
	
	private User dtoToUser(UserDto userDto) {
		User user= this.modelMapper.map(userDto, User.class);
		return user;	
	}
	
	
	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userInfo = userRepo.findByEmail(username);
		return userInfo.map(UserInfoDetailsServiceImpl::new).orElseThrow(()->new UsernameNotFoundException("user not found.."+username));

	}
}
