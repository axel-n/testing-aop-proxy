package com.example.testing_aop_proxy.dto

import java.util.*

data class User(
        val id: String,
        val name: String,
        val lastName: String
)

fun getRandomUser(): User = User(UUID.randomUUID().toString(), "name", "last_name")

fun getRandomUser(id: String): User = User(id, "name", "last_name")