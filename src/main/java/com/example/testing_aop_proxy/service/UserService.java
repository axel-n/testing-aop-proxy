package com.example.testing_aop_proxy.service;

import com.example.testing_aop_proxy.dto.User;
import com.example.testing_aop_proxy.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {
    private static final int max_user = 10;

    public List<User> getUsers() {

        wait(200); // emulate load from other microservice/db

        List<User> users = new ArrayList<>();
        for (int i = 0; i < max_user; i++) {
            users.add(User.getRandomUser());
        }
        return users;
    }

    public User getUser(String id) {
        wait(50); // emulate load from other microservice/db

        return User.getRandomUser(id);
    }

    public String createUser(UserDto userDto) {
        wait(100); // emulate load from other microservice/db

        return userDto.toUser().getId();
    }

    private void wait(int timeInMs) {
        try {
            Thread.sleep(timeInMs);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
