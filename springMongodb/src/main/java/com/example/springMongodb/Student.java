package com.example.springMongodb;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Students")
public class Student {
	
	private int id;
	private String name;
	private String City;
	private String College;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getCollege() {
		return College;
	}
	public void setCollege(String college) {
		College = college;
	}
	public Student(int id, String name, String city, String college) {
		super();
		this.id = id;
		this.name = name;
		City = city;
		College = college;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", City=" + City + ", College=" + College + "]";
	}
	
	

}
