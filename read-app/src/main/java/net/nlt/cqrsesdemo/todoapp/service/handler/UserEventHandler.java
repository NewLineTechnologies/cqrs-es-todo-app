package net.nlt.cqrsesdemo.todoapp.service.handler;

import com.github.msemys.esjc.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.nlt.cqrsesdemo.todoapp.domain.document.user.UserDocument;
import net.nlt.cqrsesdemo.todoapp.domain.events.user.UserEventType;
import net.nlt.cqrsesdemo.todoapp.domain.events.user.UserRegisteredEvent;
import net.nlt.cqrsesdemo.todoapp.repository.UserRepository;
import net.nlt.cqrsesdemo.todoapp.util.UserEventTypeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class UserEventHandler extends BaseEventHandler {

    private final static String STREAM_NAME = "user";

    @Autowired
    private UserRepository userRepository;

    private CompletableFuture<Subscription> subscription;

    @PostConstruct
    public void subscribe() {
        subscribeToTodoEvents();
    }

    @PreDestroy
    @SneakyThrows
    public void close() {
        subscription.get().close();
    }

    private void subscribeToTodoEvents() {
        subscription = eventStore.subscribeToStream(STREAM_NAME, false,
                new VolatileSubscriptionListener() {
                    @Override
                    public void onEvent(Subscription subscription, ResolvedEvent event) {
                        handleUserEvent(event.originalEvent());
                    }

                    @Override
                    public void onClose(Subscription subscription, SubscriptionDropReason reason, Exception exception) {
                        log.info("Subscription closed: " + reason);
                    }
                });
    }

    @SneakyThrows
    private void handleUserEvent(RecordedEvent event) {
        UserEventType type = extractType(event, UserEventTypeHelper.class).getEventType();

        switch (type) {
            case REGISTERED:
                handleUserRegisteredEvent(event);
                break;

            default:
                log.error("There is no handler for [User {} event]", type.toString());
        }
    }

    @SneakyThrows
    private void handleUserRegisteredEvent(RecordedEvent event) {
        UserRegisteredEvent ure = objectMapper.readValue(event.data, UserRegisteredEvent.class);

        UserDocument userDoc = new UserDocument();
        userDoc.setEmail(ure.getEmail());
        userDoc.setPassword(ure.getPassword());
        userDoc.setFirstName(ure.getFirstName());
        userDoc.setLastName(ure.getLastName());
        userRepository.save(userDoc);

        log.info("{} handled", ure.description());
    }
}
