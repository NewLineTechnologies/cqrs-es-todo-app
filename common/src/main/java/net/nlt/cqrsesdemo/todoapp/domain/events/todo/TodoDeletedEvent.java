package net.nlt.cqrsesdemo.todoapp.domain.events.todo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDeletedEvent extends BaseTodoEvent {

    public TodoDeletedEvent() {
    }

    public TodoDeletedEvent(String id) {
        super(id, TodoEventType.DELETED);
    }
}
