package com.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Todo;
import com.manager.repository.TodoRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public class TodoServiceImpl implements TodoService{
	@Autowired
	TodoRepository todoRepo;
	
	@Override
	public List<Todo> getAllTodo() {
		// TODO Auto-generated method stub
		return todoRepo.findAll();
	}

	@Override
	public Optional<Todo> getTodoById(long id) {
		// TODO Auto-generated method stub
		return todoRepo.findById(id);
	}

	@Override
	public Todo saveTodo(Todo todo) {
		// TODO Auto-generated method stub
		return todoRepo.save(todo);
	}

}
