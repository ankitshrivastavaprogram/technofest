package com.tech.tests.service;



import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.tests.exception.InvalidTestException;
import com.tech.tests.exception.InvalidTestModifierException;
import com.tech.tests.exception.InvalidTopicException;
import com.tech.tests.exception.TestNotFoundException;
import com.tech.tests.model.Option;
import com.tech.tests.model.Question;
import com.tech.tests.model.Test;
import com.tech.tests.model.Topic;
import com.tech.tests.payload.OptionPayload;
import com.tech.tests.payload.QuestionPayLoad;
import com.tech.tests.payload.TestPaperPayLoad;
import com.tech.tests.payload.TestPayload;
import com.tech.tests.repository.QuestionRepository;
import com.tech.tests.repository.TestRepository;
import com.tech.tests.repository.TopicRepository;


@Service
public class TestService {
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	QuestionRepository questionRepository;
	
	public void create(TestPayload testPayload) {
		
		String testName = testPayload.getTestName();
		Long topicId = testPayload.getTopicId();
		
		Topic topic = topicRepository.findById(topicId)
				.orElseThrow(()->new InvalidTopicException());
		
		if(testRepository.existsByTestName(testName)) {
			throw new InvalidTestException();
		}
		
		Test test = new Test(testName,topic);
		testRepository.save(test);
		
	}
	
	public List<Test> getAllTest(){
		
		return testRepository.findAllTest();
	}
	
    public List<TestPayload> getAllMyTest(Long userId){
    	List<Test> tests = testRepository.findAllMyTest(userId);
    	
		
		return tests.stream()
				.map(test-> new TestPayload(test.getTestName(), test.getTopic().getId(), test.getId()))
						.collect(Collectors.toList());
	}
	
	
	
	
    public String addQuestion(Long userId,QuestionPayLoad questionPayload) {
    	
		
		  Long testId = questionPayload.getTestId();
		  
		  
		  Test test = testRepository.findById(testId).orElseThrow(()->new TestNotFoundException());
				  String questionStatement = questionPayload.getQuestionStatement();
				  
				  Question question = new Question(questionStatement,test);
				  test.addQuestion(question);			  
				  
				if(test.getCreateBy() != userId) {
					throw new InvalidTestModifierException();
				}
				  
		  List<OptionPayload> optionPayLoads = questionPayload.getOptionPayLoads();
		  
		  
		  for(OptionPayload optionPayLoad : optionPayLoads) {
		  String optionStatement = optionPayLoad.getOptionStatement();
		  double marks = optionPayLoad.getMarks();		  
		  Option option = new Option(optionStatement, marks, question);
		 question.addOption(option);
		
		  
		  }
		  testRepository.save(test);
		 
		 return "Question got saveed";
		
	}
    
   
    
    public void getTestPaper(Long testId) {
		/*
		 * Function<Question,QuestionPayLoad > getQuestionPayload = (question)->{
		 * 
		 * Long questionId = question.getId(); String questionStatement =
		 * question.getQuestionStatement(); //question.getOptions() return new
		 * QuestionPayLoad(); };
		 * 
		 * Test t = testRepository.findById(testId).get(); List<Question> questions =
		 * t.getQuestions(); questions .stream() .map(q->getQuestionPayload.apply(q))
		 * .collect(Collectors.toList());
		 */
    	
		/*
		 * t.getQuestions().stream()
		 * .forEach(question->System.out.println(question.getQuestionStatement()) );
		 */
    }
	

}
