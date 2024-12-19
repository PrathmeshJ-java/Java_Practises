package com.satScoreManagement.services.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satScoreManagement.Entities.Candidate;
import com.satScoreManagement.Repositories.CandidateRepository;
import com.satScoreManagement.services.CandidateService;



@Service
public class CandidateServiceImpl implements CandidateService {
	
	@Autowired
	CandidateRepository candidateRepository;

	@Override
	public Candidate insertCandidate(Candidate candidate) {
		String candiate_result = (candidate.getSat_score()> 30)?"Pass":"Fail";
		candidate.setResult(candiate_result);
		Candidate insertedCandidate = this.candidateRepository.save(candidate);
		return insertedCandidate;
	}

	@Override
	public List<Candidate> getAlldata() {
		List<Candidate> candiateList = this.candidateRepository.findAll(); 
		return candiateList;
	}

	@Override
	public JSONObject getCandidateRanks(String name) {
		List<Candidate> candiateList = this.getAlldata();
		Collections.sort(candiateList, Comparator.comparingInt(Candidate::getSat_score).reversed());
		JSONObject rankJsonObject = new JSONObject();
		int rank=1;
		for (Candidate candidate : candiateList) {
            
            if(candidate.getName().equals(name)) {
            	rankJsonObject.put("name", candidate.getName());            
                rankJsonObject.put("rank", rank);
            }
		rank++;
        }
		return rankJsonObject;
	}

	@Override
	public Candidate updateScore(String name, int sat_score) {
		Candidate candidate = this.candidateRepository.findByName(name);
		candidate.setSat_score(sat_score);
		String candiate_result = (sat_score> 30)?"Pass":"Fail";
		candidate.setResult(candiate_result);
		Candidate saveCandidate = this.candidateRepository.save(candidate);
		return saveCandidate;
	}

	@Override
	public void deleteScore(String name) {
		this.candidateRepository.deleteByName(name);
		
	}
	
	
	
	

}
