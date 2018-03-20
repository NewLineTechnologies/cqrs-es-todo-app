package net.nlt.cqrsesdemo.todoapp.service;

import net.nlt.cqrsesdemo.todoapp.dto.user.RegisterUser;

public interface UserCommandService {

    void register(RegisterUser user);
}
