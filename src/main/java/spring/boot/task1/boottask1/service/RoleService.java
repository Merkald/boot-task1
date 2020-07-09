package spring.boot.task1.boottask1.service;

import spring.boot.task1.boottask1.model.Role;
import java.util.Optional;

public interface RoleService {
    void create(Role role);

    Optional<Role> getByField(Role example);
}
