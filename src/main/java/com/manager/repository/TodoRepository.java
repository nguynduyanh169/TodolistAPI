package com.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
