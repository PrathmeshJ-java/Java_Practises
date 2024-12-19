package com.dept;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface DeptService {
	
Department saveDepartment(Department department);
	 
    
    List<Department> fetchDepartmentList();
 
    
    Department updateDepartment(Department department, Long departmentId);
 
    
    void deleteDepartmentById(Long departmentId);

}
