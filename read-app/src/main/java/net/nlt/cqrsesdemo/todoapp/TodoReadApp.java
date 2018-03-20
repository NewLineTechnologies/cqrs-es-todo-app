package net.nlt.cqrsesdemo.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoReadApp {

    public static void main(String[] args) {
        SpringApplication.run(TodoReadApp.class, args);
    }
}