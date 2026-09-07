package com.ismail.springboot.webapp1.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, false, LocalDate.now().plusYears(1), "Get AWS Certified", "Ismail"));
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

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findByID(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        int id = todo.getId();
        deleteById(todo.getId());
        todos.add(todo);
    }
}
