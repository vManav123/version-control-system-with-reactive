package com.vmanav123.service.rest.api;

import com.vmanav123.service.handler.UserApiHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiRouter {

    private UserApiHandler userApiHandler;

//    @Bean
//    public RouterFunction<ServerResponse> route(){
//        return RouterFunctions
//                .route()
//                .GET("/getData",userApiHandler::getData)
//                .build();
//
//    }
}
