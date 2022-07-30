package com.vmanav123.service.controller;

import com.vmanav123.service.command.api.UserCreatedCommand;
import com.vmanav123.service.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.extensions.reactor.commandhandling.gateway.ReactorCommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.ExecutionException;


@Slf4j
@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    private ReactorCommandGateway commandGateway;

    public UserController(ReactorCommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping(path = "/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<UserDto> createUser(@RequestBody UserDto userDto) throws ExecutionException, InterruptedException {

        log.info("Data : {}",userDto);

        return Mono.just(userDto);
//        return Mono.just((UserDto) Mono.just(userDtoMono)
//                .flatMap(userDto -> {
//                    UserCreatedCommand userCreatedCommand = UserCreatedCommand.builder().build();
//                    log.info("user data transfer object : {} .", userDto.toString());
//                    BeanUtils.copyProperties(userDto, userCreatedCommand);
//                    userCreatedCommand.setStatus("STARTED");
//                    return Mono.just(userCreatedCommand);
//                })
//                .log()
//                .flatMap(userCreateCommand -> commandGateway.send(userCreateCommand))
//                .log()
//                .toFuture().get()
//        );
    }


    @GetMapping(path = "/get")
    public Mono<String> getUser() { return Mono.just("Hello"); }
}
