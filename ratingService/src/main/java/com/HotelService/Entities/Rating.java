package com.HotelService.Entities;



import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity(name = "micro_ratings")
public class Rating {
	
	@Id
	private String ratingid;
	
	@Nonnull
	private String userid;
	
	@Nonnull
	private String hotelid;
	
	@Nonnull
	private int rating;
	
	@Nonnull
	private String feedback;
	
	
	public String getRatingid() {
		return ratingid;
	}


	public void setRatingid(String ratingid) {
		this.ratingid = ratingid;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getHotelid() {
		return hotelid;
	}


	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	public Rating(String ratingid, String userid, String hotelid, int rating, String feedback) {
		super();
		this.ratingid = ratingid;
		this.userid = userid;
		this.hotelid = hotelid;
		this.rating = rating;
		this.feedback = feedback;
	}


	public Rating() {
		super();
		
	}
	
	
	
	

}
