package net.nlt.cqrsesdemo.todoapp.domain.document.todo;

import lombok.Getter;
import lombok.Setter;
import net.nlt.cqrsesdemo.todoapp.domain.document.BaseDocument;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "todos")
public class TodoDocument extends BaseDocument {

    private String task;

    private boolean completed;
}
