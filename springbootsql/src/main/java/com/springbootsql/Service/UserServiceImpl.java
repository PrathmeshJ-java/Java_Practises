package com.springbootsql.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springbootsql.Entities.Hotel;
import com.springbootsql.Entities.Rating;
import com.springbootsql.Entities.User;
import com.springbootsql.Exceptions.ResourceNotFoundException;
import com.springbootsql.dto.UserDto;

import com.springbootsql.repository.UserRepository;

import netscape.javascript.JSObject;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	RestTemplate restTemplate;
	
	

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	public User createUser(User user) {
//		String randomid = UUID.randomUUID().toString();
//		user.setId(randomid);
		return this.userRepository.save(user);
	}

	public List<User> getAllUser() {
		return this.userRepository.findAll();
	}

	public UserDto getUser(String UserId) {
	  
		UserDto userDto = new UserDto();
		ArrayList<UserDto> userDtoList = new ArrayList<>();
		User user = userRepository.findUserById(UserId);
		Rating[] ratingList = restTemplate.getForObject("http://localhost:8083/ratings/users/" + UserId,Rating[].class);
		List<Rating> ratings = Arrays.stream(ratingList).toList();
		
		
		List<Rating> rating1 = ratings.stream().map(rating ->{
			ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://localhost:8082/hotels/" + rating.getHotelid(), Hotel.class);
	        Hotel hotel = hotelEntity.getBody();
            rating.setHotel(hotel);
            return rating;
			
		}).collect(Collectors.toList());
//		for (Rating rating : ratingList) {
//	        ResponseEntity<Hotel> hotelEntity = restTemplate.getForEntity("http://localhost:8082/hotels/" + rating.getHotelid(), Hotel.class);
//	        Hotel hotel = hotelEntity.getBody();
//	        rating.setHotel(hotel); // Set the hotel object within the rating
//	    };
	    
	    
		userDto.setId(user.getId());
		userDto.setAbout(user.getAbout());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setRating(rating1);
		
		
		return userDto;
	}

	public void DeleteUser(String userId) {
		Optional<User> userOptional = userRepository.findById(userId);

		if (userOptional.isPresent()) {
			userRepository.deleteById(userId);
		} else {
			throw new ResourceNotFoundException("User with ID " + userId + " not found");
		}
	}

	public User UpdateUser(User user) {
		String userId = user.getId();

		Optional<User> existingUserOptional = userRepository.findById(userId);

		if (existingUserOptional.isPresent()) {

			User existingUser = existingUserOptional.get();

			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			existingUser.setAbout(user.getAbout());

			return userRepository.save(existingUser);
		} else {

			throw new ResourceNotFoundException("User with ID " + userId + " not found");
		}
	}

}
