package com.springjwtsecurity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springjwtsecurity.model.Todos;
import com.springjwtsecurity.repo.TodosRepository;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/employee/todos")
public class TodosController {
	
	@Autowired
	TodosRepository todosRepository;
	
	@GetMapping("/alltodos")
	public List<Todos> getAllEmp(){
		List<Todos> alltodos = todosRepository.findAll();
		return alltodos;
	}
	
	@GetMapping("/{todo_id}")
	public Optional<Todos> getTodosById(@PathVariable("todo_id") String todos_id) {
		return todosRepository.findById(todos_id);
	}
	
	@PostMapping("/addtodo")
	public String addTodo(@RequestBody Todos todo) {
		todosRepository.save(todo);
			return "Todo added!";
			
	}

}
