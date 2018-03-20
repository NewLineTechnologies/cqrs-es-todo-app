package net.nlt.cqrsesdemo.todoapp.repository;

import net.nlt.cqrsesdemo.todoapp.domain.events.todo.BaseTodoEvent;

public interface EventStoreRepository {

    void saveTodoEvent(BaseTodoEvent event);
}
