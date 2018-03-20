package net.nlt.cqrsesdemo.todoapp.domain.events.user;

import lombok.Getter;
import lombok.Setter;
import net.nlt.cqrsesdemo.todoapp.domain.events.BaseEvent;

@Getter
@Setter
public class UserBaseEvent extends BaseEvent {

    private UserEventType eventType;

    public UserBaseEvent() {
    }

    UserBaseEvent(UserEventType eventType) {
        this.eventType = eventType;
    }

    UserBaseEvent(String id, UserEventType eventType) {
        super(id);
        this.eventType = eventType;
    }

    @Override
    protected String getType() {
        return "User";
    }

    @Override
    protected String getSubType() {
        return getEventType().toString();
    }
}
