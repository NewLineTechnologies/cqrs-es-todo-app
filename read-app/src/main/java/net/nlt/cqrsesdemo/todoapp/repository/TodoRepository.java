package net.nlt.cqrsesdemo.todoapp.repository;

import net.nlt.cqrsesdemo.todoapp.domain.document.todo.TodoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoDocument, String> {
}
