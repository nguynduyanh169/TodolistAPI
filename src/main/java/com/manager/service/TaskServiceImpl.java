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
public class TaskServiceImpl implements TaskService{
	@Autowired
	TaskRepository taskRepo;

	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return taskRepo.findAll();
	}

	@Override
	public Optional<Task> getTaskById(long id) {
		// TODO Auto-generated method stub
		return taskRepo.findById(id);
	}

	@Override
	public Task saveTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepo.save(task);
	}

	@Override
	public List<Task> getTaskByTodoId(long todoId) {
		// TODO Auto-generated method stub
		return taskRepo.getTaskByTodoId(todoId);
	}
	
	
}
