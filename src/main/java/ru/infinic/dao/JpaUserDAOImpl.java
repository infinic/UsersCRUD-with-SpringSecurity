package ru.infinic.dao;

import org.springframework.stereotype.Repository;
import ru.infinic.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Oleg Kadochnikov
 */
@Repository
public class JpaUserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUsersTable() {}

    @Override
    public void dropUsersTable() {}

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(User user) { entityManager.remove(user); }

    @Override
    public void updateUser(User user) { entityManager.merge(user); }

    @Override
    public User getUser(long id) {
        return entityManager.createQuery("select u from User u where u.id=:id", User.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
}
