package ru.infinic.service;

import ru.infinic.model.User;

import java.util.List;

/**
 * @author Oleg Kadochnikov
 */
public interface UserService {
    void createUser(User user);
    void updateUser(User user);
    void updateUserById(long id, User user);
    void deleteUser(User user);
    void deleteUserById(long id);
    User getUser(long id);
    List<User> getAllUsers();
}
