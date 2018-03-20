package net.nlt.cqrsesdemo.todoapp.util;

import lombok.Getter;
import lombok.Setter;
import net.nlt.cqrsesdemo.todoapp.domain.events.user.UserEventType;

@Getter
@Setter
public class UserEventTypeHelper {

    private UserEventType eventType;
}
