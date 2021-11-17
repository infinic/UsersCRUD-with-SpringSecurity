package ru.infinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.infinic.model.Role;
import ru.infinic.model.User;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * @author Oleg Kadochnikov
 */

@Service
public class DBInitializer {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostConstruct
    void init() {
        System.out.println("Starting Database initialization...");

        if (userService.getAllUsers().isEmpty()) {
            roleService.createRole(new Role("ROLE_ADMIN", "Administrator"));
            roleService.createRole(new Role("ROLE_USER", "User"));
            userService.createUser(new User("admin", "admin", "Administrator", true, Set.of(roleService.getRoleByName("ROLE_ADMIN"))));
            userService.createUser(new User("user", "user", "Simple user", true, Set.of(roleService.getRoleByName("ROLE_USER"))));
        }
    }

}