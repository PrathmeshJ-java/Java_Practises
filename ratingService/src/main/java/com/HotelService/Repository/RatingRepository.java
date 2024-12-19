package com.HotelService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.HotelService.Entities.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {
	
	public List<Rating> findByUserid(String userid);
	
	public List<Rating> findByHotelid(String hotelid);

}
