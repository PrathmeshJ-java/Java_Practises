package com.HotelService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HotelService.Entities.Rating;
import com.HotelService.Service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAll(){
		return ResponseEntity.ok(ratingService.getAllRating());
	}
	
	@GetMapping("/users/{userid}")
	public ResponseEntity<List<Rating>> getratingonuserid(@PathVariable String userid){
		 List<Rating> ratings = ratingService.getratingbyuserid(userid);
		return ResponseEntity.ok(ratings);
	}
	
	@GetMapping("/hotels/{hotelid}")
	public ResponseEntity<List<Rating>> getratingonhotelid(@PathVariable String hotelid){
		return ResponseEntity.ok(ratingService.getratingbyhotelid(hotelid));
	}

}
