package com.example.testing_aop_proxy.service;

import com.example.testing_aop_proxy.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class UserService {


    private final int max_user = 10;

    public List<User> getUsers() {

        wait(200, 500); // emulate load from other microservice/db

        List<User> users = new ArrayList<>();
        for (int i = 0; i < max_user; i++) {
            users.add(User.getRandomUser());
        }
        return users;
    }

    public User getUser(String id) {
        wait(50, 200); // emulate load from other microservice/db

        return User.getRandomUser(id);
    }

    public String createUser(User user) {
        wait(100, 200); // emulate load from other microservice/db

        return User.getRandomUser().getId();
    }

    private void wait(int minTimeInMs, int maxTimeInMs) {

        try {
            int timeInMs = new Random().nextInt(maxTimeInMs - minTimeInMs) + minTimeInMs;
            Thread.sleep(timeInMs);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
