package com.usermicroservice.domain.user;

import java.util.Optional;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(String id);
    Optional<User> updateUser(String id, User userDetails);
    boolean deleteUser(String id);
}
