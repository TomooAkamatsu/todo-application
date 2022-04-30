package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.Todo;
import com.example.demo.service.TodoService;

@Controller
public class DummyController{
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/dummy")
	public String getIndex(Model model) {
		
		List<Todo> todoList = todoService.getTodo();
		
		model.addAttribute(todoList);
		
		
		return "dummy";
	}
	
}
