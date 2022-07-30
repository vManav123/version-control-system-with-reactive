package com.vmanav123.service.helper;

import com.vmanav123.service.model.dto.UserDto;
import com.vmanav123.service.model.entity.User;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;
import reactor.core.publisher.Mono;

@UtilityClass
public class UserUtility {
    
    public static Mono<UserDto> UserToUserDto(Mono<User> userMono){
        return userMono.flatMap(user -> {
            UserDto userDto = UserDto.builder().build();
            BeanUtils.copyProperties(user,userDto);
            return Mono.just(userDto);
        });
    }

    public static Mono<User> UserDtoToUser(Mono<UserDto> userMono){
        return userMono.flatMap(userDto -> {
            User user = User.builder().build();
            BeanUtils.copyProperties(userDto,user);
            return Mono.just(user);
        });
    }
}
