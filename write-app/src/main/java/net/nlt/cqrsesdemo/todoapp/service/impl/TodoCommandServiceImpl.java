package net.nlt.cqrsesdemo.todoapp.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.nlt.cqrsesdemo.todoapp.domain.Todo;
import net.nlt.cqrsesdemo.todoapp.domain.events.TodoCreatedEvent;
import net.nlt.cqrsesdemo.todoapp.repository.TodoEventStore;
import net.nlt.cqrsesdemo.todoapp.service.TodoCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TodoCommandServiceImpl implements TodoCommandService {

    @Autowired
    private TodoEventStore todoEventStore;

    @Override
    public void createTodo(Todo todo) {
        todoEventStore.saveTodoCreatedEvent(new TodoCreatedEvent(todo.getTask(), false));
    }

    @Override
    public void updateTodo(Todo todo) {
    }
}
