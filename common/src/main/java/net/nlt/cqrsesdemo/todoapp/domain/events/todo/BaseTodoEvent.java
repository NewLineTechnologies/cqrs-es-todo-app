package net.nlt.cqrsesdemo.todoapp.domain.events.todo;

import lombok.Getter;
import lombok.Setter;
import net.nlt.cqrsesdemo.todoapp.domain.events.BaseEvent;

@Getter
@Setter
public abstract class BaseTodoEvent extends BaseEvent {

    private TodoEventType eventType;

    public BaseTodoEvent() {
    }

    BaseTodoEvent(TodoEventType eventType) {
        this.eventType = eventType;
    }

    BaseTodoEvent(String id, TodoEventType eventType) {
        super(id);
        this.eventType = eventType;
    }

    @Override
    protected String getType() {
        return "Todo";
    }

    @Override
    protected String getSubType() {
        return getEventType().toString();
    }
}
