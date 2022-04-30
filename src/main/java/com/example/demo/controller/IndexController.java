package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Todo;
import com.example.demo.repository.TodoMapper;
import com.example.demo.service.TodoService;

@Controller
public class IndexController{
	
	@Autowired
	TodoService todoService;
	
	@Autowired
	TodoMapper todoMapper;
	
	@GetMapping("/index")
	public String getIndex(Model model) {
		
		List<Todo> todo = todoService.getTodo();
		model.addAttribute("todo", todo);
		
		return "index";
	}
	
	@PostMapping(value="/index", params = "ok")
	public String submitOk(@RequestParam("ok")String task) {
		System.out.println(task);
		todoMapper.updateOk(task);
		return "redirect:/index";
	}
	
	@PostMapping(value="/index", params="delete")
	public String delete(@RequestParam("delete") String task) {
		System.out.println(task);
		todoMapper.deleteTodo(task);
		return "redirect:/index";
	}
	
}