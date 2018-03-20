package net.nlt.cqrsesdemo.todoapp.repository;

import net.nlt.cqrsesdemo.todoapp.domain.events.todo.TodoBaseEvent;
import net.nlt.cqrsesdemo.todoapp.domain.events.user.UserBaseEvent;

public interface EventStoreRepository {

    void saveTodoEvent(TodoBaseEvent event);

    void saveUserEvent(UserBaseEvent event);
}
