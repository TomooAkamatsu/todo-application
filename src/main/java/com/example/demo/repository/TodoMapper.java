package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Todo;

@Mapper
public interface TodoMapper{
	
	@Select("SELECT * FROM todo_table")
	public List<Todo> findAll();
	
	@Update("UPDATE todo_table SET state = '完了' WHERE task = #{task}")
	public void updateOk(String task);
	
	@Insert("INSERT INTO todo_table VALUES(#{state}, #{task}, #{deadline})")
	public void addTodo(Todo todo);
	
	@Delete("DELETE FROM todo_table WHERE task = #{task}")
	public void deleteTodo(String task);
	
	
}