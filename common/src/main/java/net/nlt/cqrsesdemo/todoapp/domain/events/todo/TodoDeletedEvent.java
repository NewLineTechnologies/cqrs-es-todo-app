package net.nlt.cqrsesdemo.todoapp.domain.events.todo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDeletedEvent extends TodoBaseEvent {

    public TodoDeletedEvent() {
    }

    public TodoDeletedEvent(String id) {
        super(id, TodoEventType.DELETED);
    }
}
