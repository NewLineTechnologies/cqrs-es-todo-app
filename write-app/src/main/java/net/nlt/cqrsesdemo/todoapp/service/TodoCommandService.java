package net.nlt.cqrsesdemo.todoapp.service;

import net.nlt.cqrsesdemo.todoapp.dto.todo.CreateTodo;
import net.nlt.cqrsesdemo.todoapp.dto.todo.UpdateTodo;

public interface TodoCommandService {

    void createTodo(CreateTodo createTodo);

    void updateTodo(UpdateTodo updateTodo);
}
