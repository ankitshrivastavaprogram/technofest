package com.tech.tests.payload;

public class TestPayload {
	
	private String testName;
	private Long topicId;
	private Long testId;
	public TestPayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestPayload(String testName, Long topicId, Long testId) {
		super();
		this.testName = testName;
		this.topicId = topicId;
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	public Long getTestId() {
		return testId;
	}
	public void setTestId(Long testId) {
		this.testId = testId;
	}
	
	
	
	

}
