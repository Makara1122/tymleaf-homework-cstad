package org.example.todolist.model.service;

import org.example.todolist.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    void addNewTodo(Todo todo);
    List<Todo> getAllTodos();
    List<Todo> search(String task);
    Todo getTodoById(String uuid);
    Todo updateTodoById(String uuid, Todo todo);
    void deleteTodoById(String uuid);
}
