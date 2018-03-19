package net.nlt.cqrsesdemo.todoapp.repository;

import net.nlt.cqrsesdemo.todoapp.domain.events.TodoCreatedEvent;

public interface TodoEventStore {

    void saveTodoCreatedEvent(TodoCreatedEvent event);
}
