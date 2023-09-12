package org.example.service;

import org.example.dao.UserDao;
import org.example.model.User;

public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User createUser(String name, String photoID, String photoIDType, String addressBasedId, String addressBasedIdType, String userAddress) {
        User user = new User(name, photoID, photoIDType, addressBasedId, addressBasedIdType,userAddress);
        userDao.addUser(user);
        return user;
    }

    @Override
    public User getUserById(Long userId) {
        return userDao.getUserById(userId);
    }
}
