package ru.infinic.service;

import ru.infinic.model.Role;

import java.util.List;

/**
 * @author Oleg Kadochnikov
 */

public interface RoleService {
    void createRole(Role role);
    void deleteRole(Role role);
    void updateRole(Role role);
    Role getRoleById(long id);
    Role getRoleByName(String name);
    List<Role> getAllRoles();
}
