package com.rao.usermanagement.services;

import com.rao.usermanagement.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user );

    User updateUser();

    void deleteUser(Long userId);

    Optional<User> getUserDetails(Long userId);

    List<User> findAll();
}
