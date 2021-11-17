package ru.infinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.infinic.dao.RoleDAO;
import ru.infinic.model.Role;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Oleg Kadochnikov
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional
    public void createRole(Role role) {
        roleDAO.createRole(role);
    }

    @Override
    @Transactional
    public void deleteRole(Role role) {
        roleDAO.deleteRole(role);
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        roleDAO.updateRole(role);
    }

    @Override
    public Role getRoleById(long id) {
        return roleDAO.getRoleById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }
}
