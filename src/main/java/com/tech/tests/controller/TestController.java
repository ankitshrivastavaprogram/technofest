package com.tech.tests.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.tests.model.Test;
import com.tech.tests.payload.ApiResponse;
import com.tech.tests.payload.QuestionPayLoad;
import com.tech.tests.payload.TestPaperPayLoad;
import com.tech.tests.payload.TestPayload;
import com.tech.tests.security.CurrentUser;
import com.tech.tests.security.UserPrincipal;
import com.tech.tests.service.TestService;

@RestController
@RequestMapping("/test/")
public class TestController {

	@Autowired
	TestService testService;
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> create(@RequestBody TestPayload testPayload){
		
		try {
			testService.create(testPayload);
		} catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(e.getMessage(), false),HttpStatus.UNAUTHORIZED);
			
		}
		return new ResponseEntity<ApiResponse>(new ApiResponse("Test is created!!", true),HttpStatus.OK);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Test>> getAllTest(){
		
		return new ResponseEntity<List<Test>>(testService.getAllTest(),HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getAllMy")
    public ResponseEntity<List<TestPayload> > getAllMyTest(@CurrentUser UserPrincipal currentUser){
		Long userId = currentUser.getId();
		List<TestPayload>  tests = testService.getAllMyTest(userId);
		
		return new ResponseEntity<List<TestPayload> >(tests,HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/add/question")
	public ResponseEntity<ApiResponse>  addQuestion(@CurrentUser UserPrincipal currentUser, @RequestBody QuestionPayLoad questionPayload) {
		Long userId = currentUser.getId();
		
		try {
			return new ResponseEntity<ApiResponse>(new ApiResponse(testService.addQuestion(userId,questionPayload), true),HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<ApiResponse>(new ApiResponse(e.getMessage(), false),HttpStatus.BAD_REQUEST);
		}
		
		
		
		
	}
	
	
	  @Secured({"ROLE_USER", "ROLE_ADMIN"})
	  
	  @GetMapping("/paper/{testId}") public ResponseEntity<TestPaperPayLoad>
	  getTest(@PathVariable Long testId){
	  
	  testService.getTestPaper(testId); return null; 
	  }
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
}
