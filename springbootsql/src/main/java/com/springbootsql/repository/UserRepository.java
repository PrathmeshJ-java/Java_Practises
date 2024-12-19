package com.springbootsql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootsql.Entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findUserById(String id);

}
