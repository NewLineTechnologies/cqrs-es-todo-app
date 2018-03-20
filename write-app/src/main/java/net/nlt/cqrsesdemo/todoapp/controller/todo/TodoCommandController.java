package net.nlt.cqrsesdemo.todoapp.controller.todo;

import net.nlt.cqrsesdemo.todoapp.controller.BaseCommandController;
import net.nlt.cqrsesdemo.todoapp.dto.todo.CreateTodo;
import net.nlt.cqrsesdemo.todoapp.dto.todo.UpdateTodo;
import net.nlt.cqrsesdemo.todoapp.service.TodoCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoCommandController extends BaseCommandController {

    @Autowired
    private TodoCommandService todoCommandService;

    @PostMapping(path = "/todo")
    public void createTodo(@RequestBody CreateTodo createTodo) {
        todoCommandService.createTodo(createTodo);
    }

    @PutMapping(path = "/todo")
    public void updateTodo(@RequestBody UpdateTodo updateTodo) {
        todoCommandService.updateTodo(updateTodo);
    }
}
