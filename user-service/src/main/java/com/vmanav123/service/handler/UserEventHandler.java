package com.vmanav123.service.handler;

import com.vmanav123.service.event.UserCreatedEvent;
import com.vmanav123.service.model.entity.User;
import com.vmanav123.service.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@ProcessingGroup("UserErrorEvent")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserEventHandler {

    private UserService userService;

    @EventHandler
    @SneakyThrows
    public void on(UserCreatedEvent event) {
        User user = new User();
        BeanUtils.copyProperties(event , user);
        userService.createUser(user);
        event.setStatus("SUCCESS");
    }

    @SneakyThrows
    @ExceptionHandler
    public void handle(Exception e)
    {
        log.info("ExceptionHandler handles the exception {}",e.getMessage());
        throw e;
    }
}
