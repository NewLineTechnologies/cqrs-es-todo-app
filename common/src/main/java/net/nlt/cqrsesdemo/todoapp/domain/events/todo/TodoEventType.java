package net.nlt.cqrsesdemo.todoapp.domain.events.todo;

import lombok.Getter;

@Getter
public enum TodoEventType {

    CREATED("Created"),
    UPDATED("Updated"),
    COMPLETED("Completed");

    private String value;

    TodoEventType() {
    }

    TodoEventType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
