package com.rao.usermanagement.controller;

import com.rao.usermanagement.exception.UserNotFoundException;
import com.rao.usermanagement.model.User;
import com.rao.usermanagement.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        logger.info("Creating user with Details {}", user.toString());
        return userService.createUser(user);
    }

    @GetMapping("/allUsers")
    public List<User> findAll(@RequestBody User user) {
        logger.info("Getting All User details");
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable(name = "userId") final Long userId) {
        logger.info("Getting user Details for the user Id {}", userId);
        Optional<User> user = userService.getUserDetails(userId);
        return user
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable(name = "userId") final Long userId) {
        logger.info("Getting user Details for the user Id {}", userId);
        userService.deleteUser(userId);
    }

}
