package com.example.testing_aop_proxy.dto

import java.util.*

data class UserDto (
        val name: String,
        val lastName: String
)

fun UserDto.toUser(): User {
    return User(UUID.randomUUID().toString(), this.name, this.lastName)
}