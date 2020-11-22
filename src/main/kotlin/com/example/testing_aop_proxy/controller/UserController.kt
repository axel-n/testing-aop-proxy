package com.example.testing_aop_proxy.controller

import com.example.testing_aop_proxy.dto.User
import com.example.testing_aop_proxy.dto.UserDto
import com.example.testing_aop_proxy.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
class UserController(private val userService: UserService) {

    @GetMapping("/users")
    fun getUsers(): List<User> = userService.getUsers()

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable("id") id: String): User = userService.getUser(id)

    @PostMapping("/users")
    fun createUser(@RequestBody userDto: UserDto): String = userService.createUser(userDto)
}