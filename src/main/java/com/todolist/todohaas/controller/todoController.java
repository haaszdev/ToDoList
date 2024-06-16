package com.todolist.todohaas.controller;

import com.todolist.todohaas.model.todoModel;
import com.todolist.todohaas.repository.todoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class todoController {

    @Autowired
    private todoRepository todoRepository;

    @GetMapping
    public List<todoModel> getAllTodos() {
        return todoRepository.findAll();
    }

    @PostMapping
    public todoModel createTodo(@RequestBody todoModel todo) {
        todo.setDatacriacao(LocalDateTime.now());
        return todoRepository.save(todo);
    }

    @PutMapping("/{id}")
    public todoModel updateTodo(@PathVariable Long id, @RequestBody todoModel updatedTodo) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setDescricao(updatedTodo.getDescricao());
                    todo.setDataatualizacao(LocalDateTime.now());
                    todo.setStatus(updatedTodo.isStatus());
                    return todoRepository.save(todo);
                })
                .orElseThrow(() -> new RuntimeException("Id não encontrado: " + id));
    }

    @PatchMapping("/{id}/complete")
    public todoModel completeTodo(@PathVariable Long id) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setStatus(true);
                    todo.setDataatualizacao(LocalDateTime.now());
                    return todoRepository.save(todo);
                })
                .orElseThrow(() -> new RuntimeException("Id não encontrado: " + id));
    }

    @PatchMapping("/{id}/todo")
    public todoModel markAsToDo(@PathVariable Long id) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setStatus(false);
                    todo.setDataatualizacao(LocalDateTime.now());
                    return todoRepository.save(todo);
                })
                .orElseThrow(() -> new RuntimeException("Id não encontrado: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }
}
