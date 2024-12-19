package com.springbootsql.Entities;

import java.util.List;

public class Rating {

	private String ratingid;
	private String userid;
	private String hotelid;
	private int rating;
	private String feedback;
	private Hotel hotel;

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

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
		// TODO Auto-generated constructor stub
	}

}
