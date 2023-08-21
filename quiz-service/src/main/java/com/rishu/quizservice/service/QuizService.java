package com.rishu.quizservice.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rishu.quizservice.entity.QuestionWrapper;
import com.rishu.quizservice.entity.Quiz;
import com.rishu.quizservice.entity.Responses;
import com.rishu.quizservice.feign.QuizInterface;
import com.rishu.quizservice.repo.QuizRepo;

@Service
public class QuizService {
	
	@Autowired
	QuizRepo quizRepo;
    
	@Autowired
	QuizInterface quizInterface;

	public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
        
        List<Integer>questions = quizInterface.getQuestionForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizRepo.save(quiz);
     	return new ResponseEntity<>("Created",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Quiz quiz = quizRepo.findById(id).get();
		List<Integer>questionIds = quiz.getQuestionIds();
		ResponseEntity<List<QuestionWrapper>>questions = quizInterface.getQuestionsFromId(questionIds);
		return  questions;
	}

	public ResponseEntity<Integer> calculateScore(Integer id, List<Responses> responses) {
		// TODO Auto-generated method stub
		ResponseEntity<Integer>count = quizInterface.getScore(responses);
		
		return count;
	}

}
