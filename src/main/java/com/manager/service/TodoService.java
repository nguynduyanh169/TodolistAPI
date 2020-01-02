package com.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Todo;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public interface TodoService {
	
	public List<Todo> getAllTodo();
	
	public Optional<Todo> getTodoById(long id);
	
	public Todo saveTodo(Todo todo);
	

}
