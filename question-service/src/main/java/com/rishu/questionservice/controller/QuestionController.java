package com.rishu.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.rishu.questionservice.entity.QuestionWrapper;
import com.rishu.questionservice.entity.Questions;
import com.rishu.questionservice.entity.Responses;
import com.rishu.questionservice.service.QuestionService;

@RestController
@RequestMapping("questions")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Questions>> getAllQuestions()
	{
		return questionService.getAllQuestions();
	}
	@GetMapping("category/{category}")
	public ResponseEntity<List<Questions>>getQuestionsByCategory(@PathVariable String category)
	{
		return questionService.getQuestionsByCategory(category);
	}
	@PostMapping("/addQuestion")
	public ResponseEntity<String>addQuestions(@RequestBody Questions questions)
	{
		return questionService.addQuestions(questions);
		
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteQuestions(@PathVariable Integer id)
	{
		return questionService.deleteQuestions(id);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String>updateQuestions(@RequestBody Questions questions , @PathVariable Integer id)
	{
		return questionService.updateQuestions(questions,id);
	}
	//generate
	@GetMapping("/generate")
	public ResponseEntity<List<Integer>>getQuestionForQuiz(@RequestParam String category , @RequestParam Integer numQ)
	{
		return questionService.getQuestionForQuiz(category,numQ);
	}
	
	
	// get question on basis of id
	@PostMapping("/getQuestions")
	public ResponseEntity<List<QuestionWrapper>>getQuestionsFromId(@RequestBody List<Integer>questionsIds)
	{
		return questionService.getQuestionsFromId(questionsIds);
	}
	// get score
	@PostMapping("/getScore")
	public ResponseEntity<Integer>getScore(@RequestBody List<Responses>responses)
	{
		return questionService.getScore(responses);
	}
	
	


}
