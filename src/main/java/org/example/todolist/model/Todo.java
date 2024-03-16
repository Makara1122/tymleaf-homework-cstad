package org.example.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class Todo {
    private int id;
    private String uuid;
    private String task;
    private String description;
    private boolean isDone;
    private LocalDateTime createdAt;
}
