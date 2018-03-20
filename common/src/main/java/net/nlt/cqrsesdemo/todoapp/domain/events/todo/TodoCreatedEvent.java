package net.nlt.cqrsesdemo.todoapp.domain.events.todo;

import lombok.Getter;
import lombok.Setter;

import static java.util.UUID.randomUUID;

@Getter
@Setter
public class TodoCreatedEvent extends BaseTodoEvent {

    private String task;
    private Boolean completed;

    public TodoCreatedEvent() {
    }

    public TodoCreatedEvent(String task) {
        super(randomUUID().toString(), TodoEventType.CREATED);
        this.task = task;
        this.completed = false;
    }
}
