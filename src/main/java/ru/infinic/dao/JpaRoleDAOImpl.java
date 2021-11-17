package ru.infinic.dao;

import org.springframework.stereotype.Repository;
import ru.infinic.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Oleg Kadochnikov
 */

@Repository
public class JpaRoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void deleteRole(Role role) {
        entityManager.remove(role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role getRoleById(long id) {
        return entityManager.createQuery("select r from Role r where r.id=:id", Role.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public Role getRoleByName(String name) {
        return entityManager.createQuery("select r from Role r where r.name=:name", Role.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

}
