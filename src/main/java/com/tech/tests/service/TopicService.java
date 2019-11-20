package com.tech.tests.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.tests.exception.InvalidTopicException;
import com.tech.tests.exception.TopicAlreadyExistsException;
import com.tech.tests.exception.UnAuthorizedAdminException;
import com.tech.tests.model.Topic;
import com.tech.tests.payload.TopicPayload;
import com.tech.tests.repository.TopicRepository;
import com.tech.tests.security.UserPrincipal;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;
	
	public void create(TopicPayload topicPayload) {
		
		String topicName = topicPayload.getTopicName();
		if(topicRepository.existsByTopicName(topicName)) {
			throw new TopicAlreadyExistsException();
		}
		
		Topic topic = new Topic(topicName);
		topicRepository.save(topic);
	}
	
	@Transactional
    public void update(UserPrincipal currentUser,TopicPayload topicPayload) {
    	
    	String topicName = topicPayload.getTopicName();
		
    	Topic topic = topicRepository.findTopicByTopicName(topicName)
    	.orElseThrow(()->new InvalidTopicException());
    	
    	if(!currentUser.getId().equals(topic.getCreateBy())) {
    		throw new UnAuthorizedAdminException();
    	}
		 
    	topic.setTopicName(topicName);		
		
	}
    
      public Topic get(Long topicId) {
    	
    	Topic topic = topicRepository.findById(topicId).orElseThrow(()->new InvalidTopicException());
    	return topic;  
		
	}
      
      public List<Topic> get(){
    	  
    	  return topicRepository.FindAllTopics();
      }
    
		
	

	
	
}
