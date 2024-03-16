package org.example.todolist.controller;

import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.example.todolist.model.Todo;
import org.example.todolist.model.service.TodoService;
import org.example.todolist.repository.TodoDataRepository;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/todo/edit")
    public String edit(@RequestParam(value = "id") String id, Model model) {
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
    @GetMapping("/todo/deleted")
    public String deleteToById(@RequestParam(value = "id") String id, Model model) {
        todoService.deleteTodoById(id);
        model.addAttribute("todos", todoService.getAllTodos());
//        System.out.println(todo);
        return "redirect:/";
    }
}
