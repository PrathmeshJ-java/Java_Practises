package com.example.springMongodb;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/student")
public class MyController {
	
	@Autowired(required=true)
	private StedentRepository studentRepo;
	
	@Autowired(required=true)
	private csvExportService csvservice;
	
	@PostMapping("/")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		
		Student save = this.studentRepo.save(student);
		return ResponseEntity.ok(save);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getStudents(){
		return ResponseEntity.ok(this.studentRepo.findAll());
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable("id") int id){
	    Optional<Student> studentOptional = this.studentRepo.findById(id);

	    if (studentOptional.isPresent()) {
	        this.studentRepo.deleteById(id);
	        return ResponseEntity.ok("Student deleted successfully.");
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable("id") int id, @RequestBody Student updatedStudent) {
	    Optional<Student> studentOptional = this.studentRepo.findById(id);

	    if (studentOptional.isPresent()) {
	       
	        Student existingStudent = studentOptional.get();

	        
	        existingStudent.setName(updatedStudent.getName());
	        existingStudent.setCity(updatedStudent.getCity());
	        existingStudent.setCollege(updatedStudent.getCollege());
	        
	        
	        this.studentRepo.save(existingStudent);

	        return ResponseEntity.ok("Student updated successfully.");
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	
	@RequestMapping(path = "/studentcsv")
    public void getAllStudentsInCsv(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"students.csv\"");
        csvservice.writeStudentsToCsv(servletResponse.getWriter());
    }

}
