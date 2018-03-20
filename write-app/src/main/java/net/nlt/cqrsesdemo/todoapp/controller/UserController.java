package net.nlt.cqrsesdemo.todoapp.controller;

import net.nlt.cqrsesdemo.todoapp.dto.user.RegisterUser;
import net.nlt.cqrsesdemo.todoapp.service.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseCommandController {

    @Autowired
    private UserCommandService userCommandService;

    @PostMapping(path = "/register")
    public void registerUser(@RequestBody RegisterUser user) {
        userCommandService.register(user);
    }
}
