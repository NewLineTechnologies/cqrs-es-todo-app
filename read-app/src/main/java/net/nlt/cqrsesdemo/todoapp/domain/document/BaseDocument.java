package net.nlt.cqrsesdemo.todoapp.domain.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Getter
@Setter
public abstract class BaseDocument {

    @Id
    private String id;

    private Instant created;
}
