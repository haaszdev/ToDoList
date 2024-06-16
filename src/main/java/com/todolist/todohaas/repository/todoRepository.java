package com.todolist.todohaas.repository;

import com.todolist.todohaas.model.todoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface todoRepository extends JpaRepository<todoModel, Long> {
}
