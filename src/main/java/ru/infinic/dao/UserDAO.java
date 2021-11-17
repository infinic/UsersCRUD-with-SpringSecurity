package ru.infinic.dao;

import ru.infinic.model.User;

import java.util.List;

/**
 * @author Oleg Kadochnikov
 */

public interface UserDAO {
    void createUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
    User getUserById(long id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
}
