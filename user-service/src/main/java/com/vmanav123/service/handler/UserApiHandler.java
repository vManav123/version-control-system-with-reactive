package com.vmanav123.service.handler;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class UserApiHandler {
    public Mono<ServerResponse> getData(ServerRequest request)
    {
        var queryParam = request.queryParams();
        queryParam.forEach(((k, v) -> System.out.println("Key : "+k +" value : "+v)));
        return ServerResponse.ok().body("fetched data",String.class);
    }
}
