package net.nlt.cqrsesdemo.todoapp.domain.events;

import lombok.Getter;
import lombok.Setter;

import static java.lang.String.format;

@Getter
@Setter
public abstract class BaseEvent {

    private String id;

    public BaseEvent() {
    }

    public BaseEvent(String id) {
        this.id = id;
    }

    protected abstract String getType();

    protected abstract String getSubType();

    public String description() {
        return format("[%s %s Event]", getType(), getSubType());
    }
}
