package net.nlt.cqrsesdemo.todoapp.util;

import lombok.Getter;
import lombok.Setter;
import net.nlt.cqrsesdemo.todoapp.domain.events.todo.TodoEventType;

@Getter
@Setter
public class TodoEventTypeHelper {

    private TodoEventType eventType;

    public TodoEventTypeHelper() {
    }
}
