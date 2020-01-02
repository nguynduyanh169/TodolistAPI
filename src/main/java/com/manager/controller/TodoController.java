package com.manager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.entity.Todo;
import com.manager.service.TodoService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/todos")
	public List<Todo> getAllTodo(){
		return todoService.getAllTodo();
	}
	
	@GetMapping("/todos/{todoId}")
	public ResponseEntity<Todo> getTodoById(@PathVariable(value = "todoId") long todoId){
		Optional<Todo> todo = todoService.getTodoById(todoId);
		if(todo.get() == null) {
			return new ResponseEntity<Todo>(todo.get(), HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Todo>(todo.get(), HttpStatus.OK);
		}
	}
	
	@PostMapping("/todos")
	public ResponseEntity<Todo> saveTodo(@Valid @RequestBody Todo todo){
		Todo responeTodo = todoService.saveTodo(todo);
		return new ResponseEntity<Todo>(responeTodo, HttpStatus.OK);
	}
	
	@PutMapping("/todos/{todoId}")
	public ResponseEntity<Todo> editTodo(@PathVariable(value = "todoId") long todoId, @RequestBody Todo todo){
		Optional<Todo> responseTodo = todoService.getTodoById(todoId);
		if(responseTodo.get() == null) {
			return new ResponseEntity<Todo>(responseTodo.get(), HttpStatus.NO_CONTENT);
		}else {
			responseTodo.get().setName(todo.getName());
			responseTodo.get().setDescription(todo.getDescription());
			responseTodo.get().setPriority(todo.getPriority());
			responseTodo.get().setDueDate(todo.getDueDate());
			Todo saveTodo = todoService.saveTodo(todo);
			return new ResponseEntity<Todo>(saveTodo, HttpStatus.OK);
		}
	}
	

}
