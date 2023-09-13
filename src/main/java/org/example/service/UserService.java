package org.example.service;

import org.example.model.User;

public interface UserService {

    User createUser(String name, String photoID, String photoIDType, String addressBasedId, String addressBasedIdType, String userAddress);

    User getUserById(Long userId);
}
