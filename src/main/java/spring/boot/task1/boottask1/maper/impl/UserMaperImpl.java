package spring.boot.task1.boottask1.maper.impl;

import org.springframework.stereotype.Component;
import spring.boot.task1.boottask1.maper.UserMaper;
import spring.boot.task1.boottask1.model.User;
import spring.boot.task1.boottask1.model.dto.request.UserRequestDto;
import spring.boot.task1.boottask1.model.dto.response.UserResponseDto;

@Component
public class UserMaperImpl implements UserMaper {

    @Override
    public UserResponseDto convertUser(User user) {
        return new UserResponseDto()
                .setLogin(user.getLogin())
                .setId(user.getId());
    }

    @Override
    public User convertUser(UserRequestDto userRequestDto) {
        return new User()
                .setLogin(userRequestDto.getLogin())
                .setPassword(userRequestDto.getPassword());
    }
}
