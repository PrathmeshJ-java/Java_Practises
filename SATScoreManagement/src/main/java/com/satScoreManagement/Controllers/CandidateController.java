package com.satScoreManagement.Controllers;

import java.util.List;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.satScoreManagement.Entities.Candidate;
import com.satScoreManagement.services.CandidateService;

@RestController
@RequestMapping("/api")
public class CandidateController {
	
	@Autowired
	CandidateService candidateService;
	
	@PostMapping("/insertCandidate")
	public ResponseEntity<Candidate> saveCandidate(@RequestBody Candidate candidate){
		Candidate saveCandidate = this.candidateService.insertCandidate(candidate);
		return ResponseEntity.ok(saveCandidate);
	}
	
	@GetMapping("/viewalldata")
	public ResponseEntity<List<Candidate>> viewalldata(){
		List<Candidate> candidateList = this.candidateService.getAlldata(); 
		return new ResponseEntity<List<Candidate>>(candidateList, HttpStatus.OK);
	}
	
	
	@GetMapping("/getRank/{name}")
	public ResponseEntity<?> getAllRanks(@PathVariable String name){
		JSONObject ranklist = this.candidateService.getCandidateRanks(name);
		System.out.println(ranklist);
		return ResponseEntity.ok(ranklist.toMap());
	}
	
	@PutMapping("/updatescore")
	public ResponseEntity<?> updateScore(@RequestParam("name") String name,
			@RequestParam("sat_score") int sat_score){
		Candidate candidate = this.candidateService.updateScore(name, sat_score);
		
		return ResponseEntity.ok(candidate);
	}
	
	@DeleteMapping("/deleterecord")
	public ResponseEntity<?> deleteCandidate(@RequestParam("name") String name){
		try {
			this.candidateService.deleteScore(name);
			return ResponseEntity.status(HttpStatus.OK).body("Record deleted successfully..!");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong..please try again");
		}
	}

}
