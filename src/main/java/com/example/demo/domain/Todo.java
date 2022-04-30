package com.example.demo.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Todo{
	
	
	private String state;
	private String task;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date deadline;
	
//	public Todo(String task, Date deadline) {
//		this.state = "未完了";
//		this.task = task;
//		this.deadline = deadline;
//	}
	
}