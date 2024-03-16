package org.example.todolist.controller;

import lombok.RequiredArgsConstructor;
import org.example.todolist.model.Todo;
import org.example.todolist.model.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private Todo oldTodo;
    private final TodoService todoService;
    @GetMapping("/")
    public String index(Model model) {
        List<Todo> todoList = todoService.getAllTodos();
        model.addAttribute("todos", todoList);
//        model.addAttribute("todo", new Todo());
        return "index";
    }
    @GetMapping("/todo/search")
    public String search(@RequestParam(value = "task") String task, Model model) {
        model.addAttribute("tasks",todoService.search(task));
        return "result";
    }
    @GetMapping("/todo/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        Todo todo = todoService.getTodoById(id);
        oldTodo = todo;
        model.addAttribute("todo", todo);
        return "edit";
    }
    @PostMapping("/todoEdit1")
   public String edit1(@ModelAttribute("todo") Todo todo, Model model) {
        todoService.updateTodoById(todo.getUuid(), todo);
        model.addAttribute("todos", todoService.getAllTodos());
//        System.out.println(todo);
        return "redirect:/";
    }
    @GetMapping("/todo/delete/{id}")
    public String deleteToById(@PathVariable String id, Model model) {
        todoService.deleteTodoById(id);
        model.addAttribute("todos", todoService.getAllTodos());
//        System.out.println(todo);
        return "redirect:/";
    }
    @GetMapping("/todo/new")
    public String newTodo(Model model) {
        Todo todo =  new Todo();
        todo.setId(new Random().nextInt(1000));
        todo.setUuid(UUID.randomUUID().toString());
        todo.setCreatedAt(LocalDateTime.now());
        model.addAttribute("newTodo", todo);
        todoService.addNewTodo(todo);
        return "new";
    }
}
