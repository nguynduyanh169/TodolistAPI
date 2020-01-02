package com.manager.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Todo")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Todo implements Serializable{
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "todo")
	@JsonIgnore
	private List<Task> listTask;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TodoId")
	private long todoId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "Priority")
	private int priority;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "DueDate")
	private Date dueDate;

	public long getTodoId() {
		return todoId;
	}

	public void setTodoId(long todoId) {
		this.todoId = todoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	
	
	

}
