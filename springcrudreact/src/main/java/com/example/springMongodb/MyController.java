package com.example.springMongodb;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/employee")
public class MyController {
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	@PostMapping("/")
	public ResponseEntity<?> addEmployee(@RequestBody Employee Employee){
		System.out.println("id : "+Employee.getEmpid()+ "\n Name : " +Employee.getName()+ "\n Designation : "+Employee.getDesignation());
		Employee save = this.employeeRepository.save(Employee);
		return ResponseEntity.ok(save);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getEmployee(){
		return ResponseEntity.ok(this.employeeRepository.findAll());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable("id") int empid, @RequestBody Employee employee) {
	    Optional<Employee> employeeOptional = this.employeeRepository.findById(empid);

	    if (employeeOptional.isPresent()) {
	       
	        Employee existingEmployee = employeeOptional.get();

	        
	        existingEmployee.setName(employee.getName());
	        existingEmployee.setDesignation(employee.getDesignation());
	        
	        
	        
	        this.employeeRepository.save(existingEmployee);

	        return ResponseEntity.ok("Employee updated successfully.");
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
	    Optional<Employee> employeeOptional = this.employeeRepository.findById(id);

	    if (employeeOptional.isPresent()) {
	        this.employeeRepository.deleteById(id);
	        return ResponseEntity.ok("Student deleted successfully.");
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
	



