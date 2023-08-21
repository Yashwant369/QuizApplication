package com.rishu.quizservice.feign;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.rishu.quizservice.entity.QuestionWrapper;
import com.rishu.quizservice.entity.Responses;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	
	//generate
		@GetMapping("questions/generate")
		public ResponseEntity<List<Integer>>getQuestionForQuiz(@RequestParam String category , @RequestParam Integer numQ);
		
		
		
		// get question on basis of id
		@PostMapping("questions/getQuestions")
		public ResponseEntity<List<QuestionWrapper>>getQuestionsFromId(@RequestBody List<Integer>questionsIds);
		
		// get score
		@PostMapping("questions/getScore")
		public ResponseEntity<Integer>getScore(@RequestBody List<Responses>responses);
		
		

}
