package com.example.testing_aop_proxy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String name;
    private String lastName;

    public User toUser() {
        return new User(UUID.randomUUID().toString(), name, lastName);
    }
}
