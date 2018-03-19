package net.nlt.cqrsesdemo.todoapp.domain.events;

import lombok.Getter;
import lombok.Setter;

import static java.util.UUID.randomUUID;

@Getter
@Setter
public class TodoCreatedEvent {

    private String id;
    private String task;
    private Boolean completed;

    public TodoCreatedEvent(String task, Boolean completed) {
        this.id = randomUUID().toString();
        this.task = task;
        this.completed = completed;
    }
}
