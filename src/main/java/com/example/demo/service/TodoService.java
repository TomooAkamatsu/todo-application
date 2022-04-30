package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Todo;
import com.example.demo.repository.TodoMapper;

@Service
public class TodoService {
	
	@Autowired
	TodoMapper todoMapper;
	
	public List<Todo> getTodo(){
		return todoMapper.findAll();
	}
	
}
