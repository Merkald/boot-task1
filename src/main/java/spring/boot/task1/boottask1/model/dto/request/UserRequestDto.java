package spring.boot.task1.boottask1.model.dto.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserRequestDto {
    private String login;
    private String password;
}
