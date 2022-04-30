package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Todo;
import com.example.demo.repository.TodoMapper;
import com.example.demo.service.TodoService;

@Controller
public class AddController {
	
	@Autowired
	TodoMapper todoMapper;
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/add")
	public String getAddpage(Model model) {
		model.addAttribute("todo", new Todo());
		return "add";
	}
	
	@PostMapping("/add")
	public String postTodo(Todo todo) {
		
		todo.setState("未完了");
		
		todoMapper.addTodo(todo);
		
		return "redirect:/index";
	}
	
//	@PostMapping("/add")
//	public String postTodo(@RequestParam("task") String task, @RequestParam("deadline") String strDeadline) {
//		
//		System.out.println(task + strDeadline);
//		
//		try {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date deadline = sdf.parse(strDeadline);
//		System.out.println(task + deadline);
//		
////		Todo todo = new Todo(task, deadline);
//		
//		todoMapper.addTodo(task, deadline);
//		
//		}catch(ParseException e) {
//			e.printStackTrace();
//		}
//		
//		
//		return "redirect:/index";
//	}

}
