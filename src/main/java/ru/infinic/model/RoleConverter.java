package ru.infinic.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.infinic.service.RoleService;

/**
 * @author Oleg Kadochnikov
 */

@Component
public class RoleConverter implements Converter<String, Role> {

    @Autowired
    private RoleService roleService;

    @Override
    public Role convert(String roleName) {
        try {
            Role role = roleService.getRoleByName(roleName);
            return role;
        } catch(Exception e) {
            System.out.println("Error."+ e);
            return null;
        }
    }
}
