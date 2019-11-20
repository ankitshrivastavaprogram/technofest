package com.tech.tests.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="options")
public class Option {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="option_statement")
	private String optionStatement;
	
	@Column(name="marks")
	private double marks;
	
	@ManyToOne
	@JoinColumn(name="question")
	Question question;

	public Option() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Option(String optionStatement, double marks, Question question) {
		super();
		this.optionStatement = optionStatement;
		this.marks = marks;
		this.question = question;
	}

	public String getOptionStatement() {
		return optionStatement;
	}

	public void setOptionStatement(String optionStatement) {
		this.optionStatement = optionStatement;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Long getId() {
		return id;
	}
	
	

}
