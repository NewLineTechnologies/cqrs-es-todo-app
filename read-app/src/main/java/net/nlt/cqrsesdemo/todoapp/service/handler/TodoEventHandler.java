package net.nlt.cqrsesdemo.todoapp.service.handler;

import com.github.msemys.esjc.ResolvedEvent;
import com.github.msemys.esjc.Subscription;
import com.github.msemys.esjc.SubscriptionDropReason;
import com.github.msemys.esjc.VolatileSubscriptionListener;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.nlt.cqrsesdemo.todoapp.domain.document.todo.TodoDocument;
import net.nlt.cqrsesdemo.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class TodoEventHandler extends BaseEventHandler<TodoDocument> {

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
        todoSubscription = eventStore.subscribeToStream("todo", false,
                new VolatileSubscriptionListener() {
                    @Override
                    public void onEvent(Subscription subscription, ResolvedEvent event) {
                        todoRepository.save(extractTodo(event.originalEvent()));
                    }

                    @Override
                    public void onClose(Subscription subscription, SubscriptionDropReason reason, Exception exception) {
                        log.info("Subscription closed: " + reason);
                    }
                });
    }
}
