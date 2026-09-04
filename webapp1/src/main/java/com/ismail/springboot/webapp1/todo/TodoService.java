package com.ismail.springboot.webapp1.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, false, LocalDate.now().plusYears(1), "Learn AWS", "Ismail"));
        todos.add(new Todo(2, false, LocalDate.now().plusYears(2), "Learn Azure", "Ismail"));
        todos.add(new Todo(3, false, LocalDate.now().plusYears(3), "Learn FullStack dev", "Ismail"));
    }

    public List<Todo> findByUsername(String username) {
        return todos.stream().filter(todo -> todo.getUsername().equalsIgnoreCase("ismail")).toList();
    }
}
