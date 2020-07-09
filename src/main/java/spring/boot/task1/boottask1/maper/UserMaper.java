package spring.boot.task1.boottask1.maper;

import spring.boot.task1.boottask1.model.User;
import spring.boot.task1.boottask1.model.dto.request.UserRequestDto;
import spring.boot.task1.boottask1.model.dto.response.UserResponseDto;

public interface UserMaper {

    UserResponseDto convertUser(User user);

    User convertUser(UserRequestDto userRequestDto);
}
