package com.tech.tests.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tests")
public class Test extends UserAudit{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="test_name")
	private String testName;
	
	@OneToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="topic")
	Topic topic;
	
	@OneToMany(mappedBy="test",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	List<Question> questions = new ArrayList<Question>();

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Test(String testName, Topic topic) {
		super();
		this.testName = testName;
		this.topic = topic;
	}



	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Long getId() {
		return id;
	}
	
	public boolean addQuestion(Question question) {
		return questions.add(question);
	}
	
	public boolean removeQuestion(Question question) {
		return questions.remove(question);
	}
	
	

}
