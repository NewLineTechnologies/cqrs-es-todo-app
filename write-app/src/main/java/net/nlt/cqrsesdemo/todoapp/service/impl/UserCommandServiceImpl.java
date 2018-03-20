package net.nlt.cqrsesdemo.todoapp.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.nlt.cqrsesdemo.todoapp.domain.events.user.UserRegisteredEvent;
import net.nlt.cqrsesdemo.todoapp.dto.user.RegisterUser;
import net.nlt.cqrsesdemo.todoapp.repository.EventStoreRepository;
import net.nlt.cqrsesdemo.todoapp.service.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserCommandServiceImpl implements UserCommandService {

    @Autowired
    private EventStoreRepository eventStore;

    @Override
    public void register(RegisterUser user) {
        eventStore.saveUserEvent(new UserRegisteredEvent(
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName())
        );
    }
}
