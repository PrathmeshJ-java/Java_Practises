package com.satScoreManagement.services;

import java.util.List;


import org.json.JSONObject;


import com.satScoreManagement.Entities.Candidate;




public interface CandidateService {
	
	public Candidate insertCandidate(Candidate candidate);
	
	public List<Candidate> getAlldata();
	
	public JSONObject getCandidateRanks(String name);
	
	public Candidate updateScore(String name, int sat_score);
	
	public void deleteScore(String name);
	
	

}
