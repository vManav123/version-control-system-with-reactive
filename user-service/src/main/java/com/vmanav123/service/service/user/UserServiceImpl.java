package com.vmanav123.service.service.user;

import com.vmanav123.service.model.entity.User;
import com.vmanav123.service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("userService")
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    
    @Override
    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Mono<User> getUserByEmailAddress(String emailAddress) { return userRepository.findByEmailAddress(emailAddress); }

    @Override
    public Mono<User> createUser(User user) { return userRepository.save(user); }

    @Override
    public Mono<User> updateUser(long id , Mono<User> userMono) {
        return null;
    }

    @Override
    public Mono<User> deleteUser(long id) {
        return null;
    }
}
