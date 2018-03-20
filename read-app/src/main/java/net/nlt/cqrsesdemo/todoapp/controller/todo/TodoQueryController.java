package net.nlt.cqrsesdemo.todoapp.controller.todo;

import net.nlt.cqrsesdemo.todoapp.controller.BaseQueryController;
import net.nlt.cqrsesdemo.todoapp.domain.document.todo.TodoDocument;
import net.nlt.cqrsesdemo.todoapp.service.TodoQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TodoQueryController extends BaseQueryController {

    @Autowired
    private TodoQueryService todoQueryService;

    @GetMapping(path = "/todo")
    public Collection<TodoDocument> listAll(@RequestParam(required = false) Boolean completed) {
        return completed != null
                ? todoQueryService.findByCompleted(completed)
                : todoQueryService.listAll();
    }

    @GetMapping(path = "/todo/{todoId}")
    public TodoDocument getById(@PathVariable String todoId) {
        return todoQueryService.getById(todoId);
    }
}
