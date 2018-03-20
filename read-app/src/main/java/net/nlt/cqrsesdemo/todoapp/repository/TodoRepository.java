package net.nlt.cqrsesdemo.todoapp.repository;

import net.nlt.cqrsesdemo.todoapp.domain.document.todo.TodoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoRepository extends MongoRepository<TodoDocument, String> {

    List<TodoDocument> findByCompleted(boolean completed);
}
