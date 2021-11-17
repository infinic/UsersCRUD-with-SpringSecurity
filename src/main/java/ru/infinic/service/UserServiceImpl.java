package ru.infinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.infinic.dao.UserDAO;
import ru.infinic.model.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Oleg Kadochnikov
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public void updateUserById(long id, User user) {
        user.setId(id);
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) { userDAO.deleteUser(user); }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        User user = userDAO.getUserById(id);
        userDAO.deleteUser(user);
    }

    @Override
    public User getUserById(long id) { return userDAO.getUserById(id); }

    @Override
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
