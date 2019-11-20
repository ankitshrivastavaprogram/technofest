package com.tech.tests.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.tests.model.Topic;
import com.tech.tests.payload.ApiResponse;
import com.tech.tests.payload.TopicPayload;
import com.tech.tests.security.CurrentUser;
import com.tech.tests.security.UserPrincipal;
import com.tech.tests.service.TopicService;

@RestController
@RequestMapping("/topic/")
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	@PostMapping("create")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ApiResponse> create(@RequestBody TopicPayload topicPayload){
		
		try {
			System.out.println("aaaaaaaaacccc");
			topicService.create(topicPayload);
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(new ApiResponse(e.getMessage(), false),HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(new ApiResponse("Topic got saved", true),HttpStatus.OK);
	}
	
	@PostMapping("update")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ApiResponse> update(@CurrentUser UserPrincipal currentUser,@RequestBody TopicPayload topicPayload){
		
		try {
			topicService.update(currentUser,topicPayload);
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(new ApiResponse(e.getMessage(), true),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ApiResponse("Topic got updated", true),HttpStatus.OK);
	}
	
	@GetMapping("getAll")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
     public ResponseEntity<Object> get(){
		List<Topic> topics = topicService.get();
		
		return new ResponseEntity<>(topics,HttpStatus.OK);
	}
	

}
