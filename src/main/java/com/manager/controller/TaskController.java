package com.manager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.manager.entity.Task;
import com.manager.entity.Todo;
import com.manager.service.TaskService;

@RestController
@RequestMapping("/api/v1")
@ComponentScan(basePackages = "com.manager.service")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/tasks")
	public List<Task> getAllTask(){
		return taskService.getAllTask();
	}
	
	@GetMapping("/tasks/{taskId}")
	public ResponseEntity<Task> getTaskById(@PathVariable(value = "taskId") long taskId){
		Optional<Task> task = taskService.getTaskById(taskId);
		if(task.get() == null) {
			return new ResponseEntity<Task>(task.get(), HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Task>(task.get(), HttpStatus.OK);
		}
	}
	
	@GetMapping("/tasks/todos/{todoId}")
	public List<Task> getTaskByTodoId(@PathVariable(value = "todoId") long todoId){
		return taskService.getTaskByTodoId(todoId);
	}
	
	@PostMapping("/tasks")
	public ResponseEntity<Task> saveTask(@Valid @RequestBody Task task){
		Task responeTask = taskService.saveTask(task);
		return new ResponseEntity<Task>(responeTask, HttpStatus.OK);
	}
	
	@PutMapping("/tasks/{taskId}")
	public ResponseEntity<Task> editTask(@PathVariable(value = "taskId") long taskId, @RequestBody Task task){
		Optional<Task> responseTask = taskService.getTaskById(taskId);
		if(responseTask.get() == null) {
			return new ResponseEntity<Task>(responseTask.get(), HttpStatus.NO_CONTENT);
		}else {
			responseTask.get().setName(task.getName());
			responseTask.get().setTodo(task.getTodo());
			responseTask.get().setFinished(task.isFinished());
			Task saveTask = taskService.saveTask(responseTask.get());
			return new ResponseEntity<Task>(saveTask, HttpStatus.OK);
		}
	}
}
