package com.tech.tests.payload;

public class OptionPayload{
	private String optionStatement;
	private double marks;
	public OptionPayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OptionPayload(String optionStatement, double marks) {
		super();
		this.optionStatement = optionStatement;
		this.marks = marks;
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
	
	
	
	
}