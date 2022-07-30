package com.vmanav123.service.repository;

import com.vmanav123.service.model.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User,Long> {
    public Mono<User> findByEmailAddress(String emailAddress);
    public Mono<User> findByUsername(String emailAddress);
}
