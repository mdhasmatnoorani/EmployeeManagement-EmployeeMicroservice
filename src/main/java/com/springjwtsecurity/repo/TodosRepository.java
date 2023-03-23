package com.springjwtsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjwtsecurity.model.Todos;

public interface TodosRepository extends JpaRepository<Todos, String> {

}
