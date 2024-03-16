package org.example.todolist.model.service;

import lombok.RequiredArgsConstructor;
import org.example.todolist.model.Todo;
import org.example.todolist.repository.TodoDataRepository;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
@RequiredArgsConstructor
public class TodoServiceImp implements TodoService{
    private final TodoDataRepository todoDataRepository;
    @Override
    public List<Todo> getAllTodos() {
        return TodoDataRepository.todoList;
    }

    @Override
    public List<Todo> search(String task) {
        return TodoDataRepository.todoList.stream()
                .filter(todo -> todo.getTask().toLowerCase().contains(task.toLowerCase()))
                .toList();
    }
    @Override
    public Todo getTodoById(String uuid) {
        return TodoDataRepository.todoList.stream()
                .filter(todo -> todo.getUuid().equals(uuid)).findFirst().orElse(null);
    }

    @Override
    public Todo updateTodoById(String uuid, Todo todo) {
        System.out.println(todo.isDone());
        return TodoDataRepository.todoList.stream()
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
        TodoDataRepository.todoList.removeIf(todo -> todo.getUuid().equals(uuid));
    }
}
