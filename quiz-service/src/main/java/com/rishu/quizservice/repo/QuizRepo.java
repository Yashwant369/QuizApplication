package com.rishu.quizservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishu.quizservice.entity.Quiz;

public interface QuizRepo extends JpaRepository<Quiz,Integer>{
	

}
