package net.nlt.cqrsesdemo.todoapp.service.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.msemys.esjc.EventStore;
import com.github.msemys.esjc.RecordedEvent;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseEventHandler {

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected EventStore eventStore;

    @SneakyThrows
    protected <T> T extractType(RecordedEvent event, Class<T> resultType) {
        return objectMapper.readValue(new String(event.data), resultType);
    }
}
