package net.nlt.cqrsesdemo.todoapp.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.msemys.esjc.EventData;
import com.github.msemys.esjc.EventStore;
import lombok.extern.slf4j.Slf4j;
import net.nlt.cqrsesdemo.todoapp.domain.events.BaseEvent;
import net.nlt.cqrsesdemo.todoapp.domain.events.todo.BaseTodoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.github.msemys.esjc.EventData.newBuilder;
import static com.github.msemys.esjc.ExpectedVersion.ANY;

@Slf4j
@Repository
public class GregYoungEventStore implements EventStoreRepository {

    private final static String TODO_STREAM_NAME = "todo";

    @Autowired
    private EventStore eventStore;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void saveTodoEvent(BaseTodoEvent event) {
        eventStore.appendToStream(TODO_STREAM_NAME, ANY, convertToEventData(event));
        log.info("{} pushed to event store", event.description());
    }

    private EventData convertToEventData(BaseEvent event) {
        try {
            return newBuilder()
                    .type("created")
                    .jsonData(objectMapper.writeValueAsString(event))
                    .build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Unexpected exception on json serializing");
        }
    }
}
