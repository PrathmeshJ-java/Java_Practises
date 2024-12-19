package com.satScoreManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.satScoreManagement.Entities.Candidate;

import jakarta.transaction.Transactional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
	
	Candidate findByName(String name);
	
	@Transactional
    @Modifying
	 @Query(value = "DELETE FROM Candidate c WHERE c.name = ?1", nativeQuery = true)
	void deleteByName(String name);

}
