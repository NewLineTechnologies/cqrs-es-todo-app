package net.nlt.cqrsesdemo.todoapp.service.impl;

import net.nlt.cqrsesdemo.todoapp.domain.document.todo.TodoDocument;
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
}
