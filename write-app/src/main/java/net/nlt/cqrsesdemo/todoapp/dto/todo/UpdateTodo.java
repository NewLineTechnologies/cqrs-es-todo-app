package net.nlt.cqrsesdemo.todoapp.dto.todo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTodo {

    private String id;
    private String task;
}
