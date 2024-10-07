package com.authapimicroservice.domain.user;

import java.util.Optional;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(String id);
    User createUser(User user);
    Optional<User> updateUser(String id, User userDetails);
    boolean deleteUser(String id);
}
