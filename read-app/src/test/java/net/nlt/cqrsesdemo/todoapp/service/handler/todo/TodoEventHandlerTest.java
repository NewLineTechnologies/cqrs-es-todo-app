package net.nlt.cqrsesdemo.todoapp.service.handler.todo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.nlt.cqrsesdemo.todoapp.domain.events.todo.TodoEventType;
import net.nlt.cqrsesdemo.todoapp.util.TodoEventTypeHelper;
import org.junit.Assert;


public class TodoEventHandlerTest {


    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String json = "{\n" +
                "  \"id\": \"3c85779c-0a82-45b2-981b-faf6dc58e669\",\n" +
                "  \"eventType\": \"CREATED\",\n" +
                "  \"task\": \"my-task-5\",\n" +
                "  \"completed\": false\n" +
                "}";

        TodoEventTypeHelper o = objectMapper.readValue(json, TodoEventTypeHelper.class);

        Assert.assertEquals(TodoEventType.CREATED, o.getEventType());
    }
}