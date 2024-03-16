package org.example.todolist.repository;

import org.example.todolist.model.Todo;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Repository
public class TodoListDataStore {
    public static List<Todo> todoList = new ArrayList<>();
    public TodoListDataStore() {
        todoList.add(new Todo(1000, "35968c0d-8785-4662-b770-f19cd4f1aa0a","Task 1", "Description 1", false, LocalDateTime.now()));
        todoList.add(new Todo(1234,"8f88e4e9-f8d7-46fd-9e9c-7e0df180d862","Task 2", "Description 2", false, LocalDateTime.now()));
        todoList.add(new Todo(3244,"2e7490cd-64ec-4aef-8258-bb26d08f5900","Task 3", "Description 3", false, LocalDateTime.now()));
        todoList.add(new Todo(5676, "4b82ce7c-ea83-41e8-8f2e-821d6ddf5d9c","Task 4", "Description 4", false, LocalDateTime.now()));
        todoList.add(new Todo(4543, "9b6a4da0-c512-4634-8c6a-aa38390f3cf0","Task 5", "Description 5", false, LocalDateTime.now()));
        todoList.add(new Todo(8886, "65aa7dfe-c223-4a47-a117-7ad7a87cce75","Task 6", "Description 3", false, LocalDateTime.now()));
    }
}
