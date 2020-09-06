package com.example.testing_aop_proxy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Data
@Slf4j
@AllArgsConstructor
public class User {

    private String id;
    private String name;
    private String lastName;

    public static User getRandomUser() {
        return new User(UUID.randomUUID().toString(), "name", "last_name");
    }

    public static User getRandomUser(String id) {
        return new User(id, "name", "last_name");
    }
}
