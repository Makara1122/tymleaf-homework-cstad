package org.example.todolist.model.service;

import lombok.RequiredArgsConstructor;
import org.example.todolist.model.Todo;
import org.example.todolist.repository.TodoListDataStore;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
@RequiredArgsConstructor
public class TodoServiceImp implements TodoService{
    private final TodoListDataStore todoListDataStore;

    @Override
    public void addNewTodo(Todo todo) {
        TodoListDataStore.todoList.add(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return TodoListDataStore.todoList;
    }

    @Override
    public List<Todo> search(String task) {
        return TodoListDataStore.todoList.stream()
                .filter(todo -> todo.getTask().toLowerCase().contains(task.toLowerCase()))
                .toList();
    }
    @Override
    public Todo getTodoById(String uuid) {
        return TodoListDataStore.todoList.stream()
                .filter(todo -> todo.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    @Override
    public Todo updateTodoById(String uuid, Todo todo) {
        System.out.println(todo.isDone());
        return TodoListDataStore.todoList.stream()
                .filter(t -> t.getUuid().equals(uuid.trim()))
                .peek(e -> {
                    e.setTask(todo.getTask());
                    e.setDescription(
                            todo.getDescription() == null
                            ?e.getDescription():todo.getDescription());
                    e.setDone(todo.isDone() || e.isDone());
                }).findFirst().orElse(null);
    }

    @Override
    public void deleteTodoById(String uuid) {
        TodoListDataStore.todoList.removeIf(todo -> todo.getUuid().equals(uuid));
    }
}
