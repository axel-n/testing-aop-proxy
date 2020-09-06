package com.example.testing_aop_proxy.controller;

import com.example.testing_aop_proxy.dto.User;
import com.example.testing_aop_proxy.dto.UserDto;
import com.example.testing_aop_proxy.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }



    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
    }

    @PostMapping("/users")
    public String createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }
}
