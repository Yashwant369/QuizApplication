package com.rishu.questionservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rishu.questionservice.entity.Questions;




public interface QuestionsRepo extends JpaRepository<Questions , Integer>{
       
	List<Questions> findByCategory(String category);
	
	@Query(value = "SELECT q.id FROM questions q WHERE "
	        + "q.category = :category"
	        + " ORDER BY RAND() LIMIT :numQ", nativeQuery = true)

    List<Integer>findQuestions(String category,Integer numQ);

	
	
}
