package com.satScoreManagement.payloads;


public class CandidateDto {
	
	private String name;
	private String address;
	private String city;
	private String country;
	private String pincode;
	private int sat_score;
	private String result;
	
	private int rank;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getSat_score() {
		return sat_score;
	}

	public void setSat_score(int sat_score) {
		this.sat_score = sat_score;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public CandidateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
