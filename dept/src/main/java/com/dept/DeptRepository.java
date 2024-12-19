package com.dept;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends CrudRepository<Department, Long> {
	
	

}
