package net.nlt.cqrsesdemo.todoapp.service;

import net.nlt.cqrsesdemo.todoapp.domain.Todo;

public interface TodoCommandService {

    void createTodo(Todo todo);

    void updateTodo(Todo todo);
}
