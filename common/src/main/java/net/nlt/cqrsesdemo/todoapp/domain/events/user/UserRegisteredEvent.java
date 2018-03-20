package net.nlt.cqrsesdemo.todoapp.domain.events.user;

import lombok.Getter;
import lombok.Setter;

import static java.util.UUID.randomUUID;

@Getter
@Setter
public class UserRegisteredEvent extends UserBaseEvent {

    private String email;
    private String password;

    private String firstName;
    private String lastName;

    public UserRegisteredEvent() {
    }

    public UserRegisteredEvent(String email, String password, String firstName, String lastName) {
        super(randomUUID().toString(), UserEventType.REGISTERED);
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
