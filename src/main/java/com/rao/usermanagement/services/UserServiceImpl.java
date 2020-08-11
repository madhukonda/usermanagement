package com.rao.usermanagement.services;


import com.rao.usermanagement.exception.PassWordValidationException;
import com.rao.usermanagement.model.User;
import com.rao.usermanagement.repository.UserRepository;
import com.rao.usermanagement.validations.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        if (!PasswordValidator.validatePassword(user.getPassword())) {
            throw new PassWordValidationException();
        }
        return userRepository.save(user);
    }

    public User updateUser() {
        return null;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Optional<User> getUserDetails(Long userId) {
        return userRepository.findById(userId);
    }


    public List<User> findAll() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC));
    }
}
