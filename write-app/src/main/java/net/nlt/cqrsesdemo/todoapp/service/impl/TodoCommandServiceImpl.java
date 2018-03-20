package net.nlt.cqrsesdemo.todoapp.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.nlt.cqrsesdemo.todoapp.domain.events.todo.TodoCompletedEvent;
import net.nlt.cqrsesdemo.todoapp.domain.events.todo.TodoCreatedEvent;
import net.nlt.cqrsesdemo.todoapp.domain.events.todo.TodoUpdatedEvent;
import net.nlt.cqrsesdemo.todoapp.dto.todo.CreateTodo;
import net.nlt.cqrsesdemo.todoapp.dto.todo.UpdateTodo;
import net.nlt.cqrsesdemo.todoapp.repository.EventStoreRepository;
import net.nlt.cqrsesdemo.todoapp.service.TodoCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TodoCommandServiceImpl implements TodoCommandService {

    @Autowired
    private EventStoreRepository eventStore;

    @Override
    public void createTodo(CreateTodo createTodo) {
        eventStore.saveTodoEvent(new TodoCreatedEvent(createTodo.getTask()));
    }

    @Override
    public void updateTodo(UpdateTodo updateTodo) {
        eventStore.saveTodoEvent(new TodoUpdatedEvent(updateTodo.getId(), updateTodo.getTask()));
    }

    @Override
    public void completeTodo(String todoId) {
        eventStore.saveTodoEvent(new TodoCompletedEvent(todoId));
    }
}
