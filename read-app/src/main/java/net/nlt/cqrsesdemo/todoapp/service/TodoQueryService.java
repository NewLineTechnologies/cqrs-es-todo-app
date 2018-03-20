package net.nlt.cqrsesdemo.todoapp.service;

import net.nlt.cqrsesdemo.todoapp.domain.document.todo.TodoDocument;

import java.util.Collection;

public interface TodoQueryService {

    Collection<TodoDocument> listAll();

    Collection<TodoDocument> findByCompleted(boolean completed);

    TodoDocument getById(String todoId);
}
