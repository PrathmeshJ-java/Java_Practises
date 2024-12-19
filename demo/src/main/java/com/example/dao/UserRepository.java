package com.example.dao;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.user.User;

public interface UserRepository extends MongoRepository<User, Integer> {

	void save(ArrayList<User> list);

}
