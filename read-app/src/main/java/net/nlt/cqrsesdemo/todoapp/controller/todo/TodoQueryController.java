package net.nlt.cqrsesdemo.todoapp.controller.todo;

import net.nlt.cqrsesdemo.todoapp.controller.BaseQueryController;
import net.nlt.cqrsesdemo.todoapp.domain.document.todo.TodoDocument;
import net.nlt.cqrsesdemo.todoapp.service.TodoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TodoQueryController extends BaseQueryController {

    @Autowired
    private TodoQueryService todoQueryService;

    @GetMapping(path = "/todo")
    public Collection<TodoDocument> listAll() {
        return todoQueryService.listAll();
    }
}
