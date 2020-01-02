package com.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.manager.entity.Task;
import com.manager.repository.TaskRepository;

@Service
@ComponentScan(basePackages = "com.manager.repository")
public interface TaskService {
	
	public List<Task> getAllTask();
	
	public Optional<Task> getTaskById(long id);
	
	public Task saveTask(Task task);
	
	public List<Task> getTaskByTodoId(long todoId);
	
	

}
