package com.tech.tests.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="questions")
public class Question {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="question_statement")
	private String questionStatement;
	
	@ManyToOne
	@JoinColumn(name="test")
	Test test;
	
	@OneToMany(mappedBy="question",cascade=CascadeType.ALL)
	List<Option> options = new ArrayList<Option>();

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(String questionStatement, Test test) {
		super();
		this.questionStatement = questionStatement;
		this.test = test;
	}

	public String getQuestionStatement() {
		return questionStatement;
	}

	public void setQuestionStatement(String questionStatement) {
		this.questionStatement = questionStatement;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Long getId() {
		return id;
	}
	
	
	public boolean addOption(Option option) {
		return options.add(option);
	}
	
	public boolean removeOption(Option option) {
		return options.remove(option);
	}
	
	
	

}
