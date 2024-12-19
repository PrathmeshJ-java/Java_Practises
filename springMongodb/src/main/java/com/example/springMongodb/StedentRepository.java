package com.example.springMongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StedentRepository extends MongoRepository<Student, Integer>{

}
