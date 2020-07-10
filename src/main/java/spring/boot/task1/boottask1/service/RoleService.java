package spring.boot.task1.boottask1.service;

import java.util.Optional;
import spring.boot.task1.boottask1.model.Role;

public interface RoleService {
    void create(Role role);

    Optional<Role> getByField(Role example);
}
