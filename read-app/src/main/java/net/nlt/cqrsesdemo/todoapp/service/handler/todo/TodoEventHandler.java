package net.nlt.cqrsesdemo.todoapp.service.handler.todo;

import com.github.msemys.esjc.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.nlt.cqrsesdemo.todoapp.domain.document.todo.TodoDocument;
import net.nlt.cqrsesdemo.todoapp.domain.events.todo.TodoCompletedEvent;
import net.nlt.cqrsesdemo.todoapp.domain.events.todo.TodoCreatedEvent;
import net.nlt.cqrsesdemo.todoapp.domain.events.todo.TodoEventType;
import net.nlt.cqrsesdemo.todoapp.domain.events.todo.TodoUpdatedEvent;
import net.nlt.cqrsesdemo.todoapp.repository.TodoRepository;
import net.nlt.cqrsesdemo.todoapp.service.handler.BaseEventHandler;
import net.nlt.cqrsesdemo.todoapp.util.TodoEventTypeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class TodoEventHandler extends BaseEventHandler<TodoDocument> {

    private final static String STREAM_NAME = "todo";

    @Autowired
    private TodoRepository todoRepository;

    private CompletableFuture<Subscription> todoSubscription;

    public TodoEventHandler() {
        super(TodoDocument.class);
    }

    @PostConstruct
    public void subscribe() {
        subscribeToTodoEvents();
    }

    @PreDestroy
    @SneakyThrows
    public void close() {
        todoSubscription.get().close();
    }

    private void subscribeToTodoEvents() {
        todoSubscription = eventStore.subscribeToStream(STREAM_NAME, false,
                new VolatileSubscriptionListener() {
                    @Override
                    public void onEvent(Subscription subscription, ResolvedEvent event) {
                        handleTodoEvent(event.originalEvent());
                    }

                    @Override
                    public void onClose(Subscription subscription, SubscriptionDropReason reason, Exception exception) {
                        log.info("Subscription closed: " + reason);
                    }
                });
    }

    @SneakyThrows
    private void handleTodoEvent(RecordedEvent event) {
        TodoEventType type = extractType(event);

        switch (type) {
            case CREATED:
                handleTodoCreatedEvent(event);
                break;

            case UPDATED:
                handleUpdateTodoEvent(event);
                break;

            case COMPLETED:
                handleTodoCompletedEvent(event);
                break;

            default:
                log.error("There is no handler for [Todo {} event]", type.toString());
        }
    }

    @SneakyThrows
    private void handleTodoCompletedEvent(RecordedEvent event) {
        TodoCompletedEvent tce = objectMapper.readValue(event.data, TodoCompletedEvent.class);
        todoRepository.findById(tce.getId()).ifPresent(todoDoc -> {
            todoDoc.setCompleted(true);
            todoRepository.save(todoDoc);

            log.info("{} handled", tce.description());
        });
    }

    @SneakyThrows
    private void handleTodoCreatedEvent(RecordedEvent event) {
        TodoCreatedEvent tce = objectMapper.readValue(event.data, TodoCreatedEvent.class);

        TodoDocument todoDoc = new TodoDocument();
        todoDoc.setId(tce.getId());
        todoDoc.setTask(tce.getTask());
        todoDoc.setCompleted(tce.getCompleted());
        todoDoc.setCreated(event.created);
        todoRepository.save(todoDoc);

        log.info("{} handled", tce.description());
    }

    @SneakyThrows
    private void handleUpdateTodoEvent(RecordedEvent event) {
        TodoUpdatedEvent todoUpdatedEvent = objectMapper.readValue(event.data, TodoUpdatedEvent.class);

        TodoDocument todoDoc = todoRepository.findById(todoUpdatedEvent.getId()).get();
        todoDoc.setTask(todoUpdatedEvent.getTask());
        todoRepository.save(todoDoc);

        log.info("{} handled", todoUpdatedEvent.description());
    }

    @SneakyThrows
    private TodoEventType extractType(RecordedEvent event) {
        return objectMapper.readValue(new String(event.data), TodoEventTypeHelper.class).getEventType();
    }
}
