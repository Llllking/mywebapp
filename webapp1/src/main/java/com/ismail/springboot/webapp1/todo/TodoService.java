package com.ismail.springboot.webapp1.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, false, LocalDate.now().plusYears(1), "Learn AWS", "Ismail"));
        todos.add(new Todo(++todosCount, false, LocalDate.now().plusYears(2), "Learn Azure", "Ismail"));
        todos.add(new Todo(++todosCount, false, LocalDate.now().plusYears(3), "Learn FullStack dev", "Ismail"));
    }

    public List<Todo> findByUsername(String username) {
        return todos.stream().filter(todo -> todo.getUsername().equalsIgnoreCase("ismail")).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todosCount, done, targetDate, description, username);
        todos.add(todo);
    }
}
