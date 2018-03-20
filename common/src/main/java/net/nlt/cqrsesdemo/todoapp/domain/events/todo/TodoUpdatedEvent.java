package net.nlt.cqrsesdemo.todoapp.domain.events.todo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoUpdatedEvent extends BaseTodoEvent {

    private String id;
    private String task;

    public TodoUpdatedEvent() {
    }

    public TodoUpdatedEvent(String id, String task) {
        super(TodoEventType.UPDATED);
        this.id = id;
        this.task = task;
    }
}

