package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.UserRepository;
import com.example.user.User;

@SpringBootApplication
public class SpringboottestApplication {
	
	
    public static void main(String[] args) {
		SpringApplication.run(SpringboottestApplication.class, args);
		
		
		
    }
}
