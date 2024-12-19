package com.satScoreManagement.Entities;

import java.util.Comparator;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Candidate")
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int candidate_id;
	
	@Column(unique = true)
	private String name;
	private String address;
	private String city;
	private String country;
	private String pincode;
	private int sat_score;
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getCandidate_id() {
		return candidate_id;
	}
	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}
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
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 public static void sort(List<Candidate> candidateList, Comparator<Candidate> comparator) {
	        candidateList.sort(comparator);
	    }
	
	 

}
