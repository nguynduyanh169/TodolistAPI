package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	@Query("SELECT tk from Task tk where tk.todo.todoId = :todoId")
	List<Task> getTaskByTodoId(@Param(value = "todoId") long todoId);
}
