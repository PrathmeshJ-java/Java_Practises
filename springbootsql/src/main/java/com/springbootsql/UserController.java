package com.springbootsql;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.springbootsql.Entities.User;
import com.springbootsql.Service.UserServiceImpl;
import com.springbootsql.dto.UserDto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	int retryCount = 0;

	@Autowired(required = true)
	private UserServiceImpl userService;

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
	}

	@GetMapping
	public ResponseEntity<List<User>> Alluser() {
		List User1 = userService.getAllUser();
		return ResponseEntity.ok(User1);
	}

	@GetMapping("/{id}")
//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//	@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<?> Alluser(@PathVariable String id) {
		logger.info("Retry count: {}", retryCount);
		retryCount++;
		UserDto user = userService.getUser(id);

		if (!user.equals(null)) {

			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {


      ex.printStackTrace();

//      User user = User.builder().email("dummy@gmail.com").name("Dummy").about("This user is created dummy because some service is down").userId("141234").build();
      User user1 = new User();
      user1.setId("1222");
      user1.setName("Dummy");
      user1.setEmail("dummy@gmail.com");
      user1.setAbout("this is a dummy user");
      return new ResponseEntity<>(user1, HttpStatus.BAD_REQUEST);
   }
	

	@PutMapping("/updateuser")
	public ResponseEntity<User> update1user(@RequestBody User user) {
		User User1 = userService.UpdateUser(user);
		if (user != null) {

			return ResponseEntity.ok(User1);

		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> DeleteUser(@PathVariable String id) {
		try {
			userService.DeleteUser(id);
			return ResponseEntity.ok("user deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found in server");
		}
	}

}
