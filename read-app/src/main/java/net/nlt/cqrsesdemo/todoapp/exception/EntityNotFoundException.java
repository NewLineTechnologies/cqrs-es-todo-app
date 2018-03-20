package net.nlt.cqrsesdemo.todoapp.exception;

import static java.lang.String.format;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String entity, String id) {
        super(format("%s with id = [%s] not found", entity, id));
    }
}
