package com.rishu.questionservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rishu.questionservice.entity.QuestionWrapper;
import com.rishu.questionservice.entity.Questions;
import com.rishu.questionservice.entity.Responses;
import com.rishu.questionservice.repo.QuestionsRepo;

@Service
public class QuestionService {
	
	@Autowired
	QuestionsRepo questionsRepo;

	public ResponseEntity<List<Questions>> getAllQuestions() {
		// TODO Auto-generated method stub
		try 
		{
			 return new ResponseEntity<>(questionsRepo.findAll(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// if error it will return empty array list with bad request response
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}
	public ResponseEntity<List<Questions>>getQuestionsByCategory(String category)
	{
		try
		{
			return new ResponseEntity<>(questionsRepo.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<String> addQuestions(Questions questions) {
		try 
		{
			questionsRepo.save(questions);
			return new ResponseEntity<>("Question Added",HttpStatus.CREATED);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>("Error" , HttpStatus.BAD_REQUEST);
		
		
		
	}
	public ResponseEntity<String> deleteQuestions(Integer id) {
		// TODO Auto-generated method stub
		try 
		{
			questionsRepo.deleteById(id);
			return new ResponseEntity<>("Question Deleted",HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
		
	}
	public ResponseEntity<String> updateQuestions(Questions questions, Integer id) {
		
		// Find the existing question by its ID
	    Optional<Questions> optionalQuestion = this.questionsRepo.findById(id);
	    
	    if (!optionalQuestion.isPresent()) {
	        // If the question with the provided ID doesn't exist, you might want to return an error response
	        return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
	    }
	    
	    // Extract the actual question object from the Optional
	    Questions existingQuestion = optionalQuestion.get();
	   
	    // update data
	    existingQuestion.setOption1(questions.getOption1());
	    existingQuestion.setOption2(questions.getOption2());
	    existingQuestion.setOption3(questions.getOption3());
	    existingQuestion.setOption4(questions.getOption4());
	    existingQuestion.setQuestionTitle(questions.getQuestionTitle());
	    existingQuestion.setRightAnswer(questions.getRightAnswer());
	    existingQuestion.setDifficulty(questions.getDifficulty());
	    existingQuestion.setCategory(questions.getCategory());
	    
	    
	    // TODO: You need to save the changes to the repository
	    this.questionsRepo.save(existingQuestion);
	    
	    // Return a success response indicating the update was successful
	    return new ResponseEntity<>("Question updated successfully", HttpStatus.OK);
		
		
	}
	public ResponseEntity<List<Integer>> getQuestionForQuiz(String category, Integer numQ) {
		// TODO Auto-generated method stub
		List<Integer>questions = questionsRepo.findQuestions(category,numQ);
		return new ResponseEntity<>(questions,HttpStatus.OK);
	}
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionsIds) {
		// TODO Auto-generated method stub
		List<QuestionWrapper>wrappers = new ArrayList<>();
		List<Questions>questions = new ArrayList<>();
		for(Integer id : questionsIds)
		{
			questions.add(questionsRepo.findById(id).get());
		}
		for(Questions question : questions)
		{
			QuestionWrapper wrapper = new QuestionWrapper();
			wrapper.setId(question.getId());
			wrapper.setQuestionTitle(question.getQuestionTitle());;
			wrapper.setOption1(question.getOption1());
			wrapper.setOption2(question.getOption2());
			wrapper.setOption3(question.getOption3());
			wrapper.setOption4(question.getOption4());
			wrappers.add(wrapper);
			
			
		}
		return new ResponseEntity<>(wrappers,HttpStatus.OK);
		
		
	}
	public ResponseEntity<Integer> getScore(List<Responses> responses) {
		// TODO Auto-generated method stub
		
		int score = 0;
	
		for(Responses response : responses)	
		{
			Questions questions = questionsRepo.findById(response.getId()).get();
			if(response.getResponse().equals(questions.getRightAnswer()))
				score++;
			
			
			
		}
		
		return new ResponseEntity<>(score,HttpStatus.OK);
		
	}

}
