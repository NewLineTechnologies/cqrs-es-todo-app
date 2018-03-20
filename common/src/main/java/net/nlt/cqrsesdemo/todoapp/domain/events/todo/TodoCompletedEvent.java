package net.nlt.cqrsesdemo.todoapp.domain.events.todo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoCompletedEvent extends TodoBaseEvent {

    public TodoCompletedEvent() {
    }

    public TodoCompletedEvent(String id) {
        super(id, TodoEventType.COMPLETED);
    }
}
