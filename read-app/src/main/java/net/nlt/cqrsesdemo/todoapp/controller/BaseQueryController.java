package net.nlt.cqrsesdemo.todoapp.controller;

import net.nlt.cqrsesdemo.todoapp.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping(path = "/api/v1")
public abstract class BaseQueryController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public String notFoundHandler(EntityNotFoundException e) {
        return e.getMessage();
    }
}
