package com.HotelService.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelService.Entities.Rating;
import com.HotelService.Repository.RatingRepository;



@Service
public class RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	public Rating createRating(Rating rating) {
//		String randomid = UUID.randomUUID().toString();
//		rating.setRatingid(randomid);
		return ratingRepository.save(rating);
		
	}
	
	public List<Rating> getAllRating(){
		return ratingRepository.findAll();
	}
	
	public List<Rating> getratingbyuserid(String userid){
		return  ratingRepository.findByUserid(userid);
		
	}
	
	public List<Rating> getratingbyhotelid(String hotelid){
		return ratingRepository.findByHotelid(hotelid);
	}

}
