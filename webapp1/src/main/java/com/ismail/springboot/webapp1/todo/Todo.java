package com.ismail.springboot.webapp1.todo;

import java.time.LocalDate;

public class Todo {
    private int id;
    private String username;
    private String Description;
    private LocalDate targetDate;
    private boolean done;

    public Todo(int id, boolean done, LocalDate targetDate, String description, String username) {
        this.id = id;
        this.done = done;
        this.targetDate = targetDate;
        Description = description;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", Description='" + Description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}
