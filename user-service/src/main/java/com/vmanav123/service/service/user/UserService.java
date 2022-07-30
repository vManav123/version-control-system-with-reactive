package com.vmanav123.service.service.user;

import com.vmanav123.service.model.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    public Flux<User> getAllUsers();
    public Mono<User> getUserById(long id);
    public Mono<User> getUserByUsername(String username);
    public Mono<User> getUserByEmailAddress(String emailAddress);
    public Mono<User> updateUser(long id,Mono<User> userMono);
    public Mono<User> deleteUser(long id);
    public Mono<User> createUser(User user);
}
