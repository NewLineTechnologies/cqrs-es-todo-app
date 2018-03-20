package net.nlt.cqrsesdemo.todoapp.service.impl;

import lombok.SneakyThrows;
import net.nlt.cqrsesdemo.todoapp.domain.document.todo.TodoDocument;
import net.nlt.cqrsesdemo.todoapp.exception.EntityNotFoundException;
import net.nlt.cqrsesdemo.todoapp.repository.TodoRepository;
import net.nlt.cqrsesdemo.todoapp.service.TodoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TodoQueryServiceImpl implements TodoQueryService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Collection<TodoDocument> listAll() {
        return todoRepository.findAll();
    }

    @Override
    public Collection<TodoDocument> findByCompleted(boolean completed) {
        return todoRepository.findByCompleted(completed);
    }

    @Override
    @SneakyThrows
    public TodoDocument getById(String todoId) {
        return todoRepository.findById(todoId).orElseThrow(() -> {
            throw new EntityNotFoundException("Todo", todoId);
        });
    }
}
