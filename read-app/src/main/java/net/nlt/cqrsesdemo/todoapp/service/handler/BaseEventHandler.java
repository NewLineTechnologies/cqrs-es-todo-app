package net.nlt.cqrsesdemo.todoapp.service.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.msemys.esjc.EventStore;
import com.github.msemys.esjc.RecordedEvent;
import lombok.SneakyThrows;
import net.nlt.cqrsesdemo.todoapp.domain.document.BaseDocument;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseEventHandler<T extends BaseDocument> {

    protected BaseEventHandler(Class<T> resultType) {
        this.resultType = resultType;
    }

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected EventStore eventStore;

    private Class<T> resultType;

    @SneakyThrows
    protected T extractTodo(RecordedEvent re) {
        T result = objectMapper.readValue(re.data, resultType);
        result.setCreated(re.created);
        return result;
    }
}
