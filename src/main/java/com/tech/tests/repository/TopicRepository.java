package com.tech.tests.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tech.tests.model.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Long>{
	
	boolean existsByTopicName(String topicName);
	Optional<Topic> findById(Long topicId);
	
	Optional<Topic> findTopicByTopicName(String topicName);
	
	@Query("select t from Topic t")
	List<Topic> FindAllTopics();

}
