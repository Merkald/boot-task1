package spring.boot.task1.boottask1.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import spring.boot.task1.boottask1.model.Role;
import spring.boot.task1.boottask1.repository.RoleRepository;
import spring.boot.task1.boottask1.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void create(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Optional<Role> getByField(Role example) {
        Example<Role> role = Example.of(example);
        return roleRepository.findOne(role);
    }
}
