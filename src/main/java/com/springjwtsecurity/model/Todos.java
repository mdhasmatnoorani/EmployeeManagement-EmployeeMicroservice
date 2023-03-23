package com.springjwtsecurity.model;


import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="todos")
public class Todos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	@Column(name="todo_id")
	private String todoId;
	
	@Column(name="todo_name")
	private String todoName;
	
	@Column(name="todo_description")
	private String todoDescription;
	
	@Column(name="employee_id")
	private String employeeId;
	
	@Column(name="todo_last_updated")
	private LocalDateTime todoLastUpdatedDateTime = LocalDateTime.now();
	
	public Todos() {
		super();
	}

	public Todos(String todoId, String todoName, String todoDescription, String employeeId,
			LocalDateTime todoLastUpdatedDateTime) {
		super();
		this.todoId = todoId;
		this.todoName = todoName;
		this.todoDescription = todoDescription;
		this.employeeId = employeeId;
		this.todoLastUpdatedDateTime = todoLastUpdatedDateTime;
	}

	public String getTodoId() {
		return todoId;
	}

	public void setTodoId(String todoId) {
		this.todoId = todoId;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public String getTodoDescription() {
		return todoDescription;
	}

	public void setTodoDescription(String todoDescription) {
		this.todoDescription = todoDescription;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDateTime getTodoLastUpdatedDateTime() {
		return todoLastUpdatedDateTime;
	}

	public void setTodoLastUpdatedDateTime(LocalDateTime todoLastUpdatedDateTime) {
		this.todoLastUpdatedDateTime = todoLastUpdatedDateTime;
	}

	@Override
	public String toString() {
		return "Todos [todoId=" + todoId + ", todoName=" + todoName + ", todoDescription=" + todoDescription
				+ ", employeeId=" + employeeId + ", todoLastUpdatedDateTime=" + todoLastUpdatedDateTime + "]";
	}




	
	
}
