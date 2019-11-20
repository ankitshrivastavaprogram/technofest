package com.tech.tests.payload;

import java.util.List;

public class QuestionPayLoad {
	private Long testId;
	private String questionStatement;
	private List <OptionPayload> optionPayLoads;
	
	public QuestionPayLoad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionPayLoad(Long testId, String questionStatement, List<OptionPayload> optionPayLoads) {
		super();
		this.testId = testId;
		this.questionStatement = questionStatement;
		this.optionPayLoads = optionPayLoads;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getQuestionStatement() {
		return questionStatement;
	}

	public void setQuestionStatement(String questionStatement) {
		this.questionStatement = questionStatement;
	}

	public List<OptionPayload> getOptionPayLoads() {
		return optionPayLoads;
	}

	public void setOptionPayLoads(List<OptionPayload> optionPayLoads) {
		this.optionPayLoads = optionPayLoads;
	}
	
	
	

}




