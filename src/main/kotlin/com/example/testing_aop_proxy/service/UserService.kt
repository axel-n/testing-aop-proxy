package com.example.testing_aop_proxy.service

import com.example.testing_aop_proxy.dto.User
import com.example.testing_aop_proxy.dto.UserDto
import com.example.testing_aop_proxy.dto.getRandomUser
import com.example.testing_aop_proxy.dto.toUser
import org.slf4j.LoggerFactory

import org.springframework.stereotype.Service
import java.util.*


@Service
class UserService {
    private val logger = LoggerFactory.getLogger(this::class.java.simpleName)

    // emulate load from other microservice/db
    fun getUsers(): List<User> {
        wait(200) // emulate load from other microservice/db
        val users: MutableList<User> = ArrayList()
        for (i in 0 until max_user) {
            users.add(getRandomUser())
        }
        return users
    }


    fun getUser(id: String): User {
        wait(50) // emulate load from other microservice/db
        return getRandomUser(id)
    }

    fun createUser(userDto: UserDto): String {
        wait(100) // emulate load from other microservice/db
        return userDto.toUser().id
    }

    private fun wait(timeInMs: Int) {
        try {
            Thread.sleep(timeInMs.toLong())
        } catch (e: InterruptedException) {
            logger.error(e.message)
        }
    }


    companion object {
        private const val max_user = 10
    }
}