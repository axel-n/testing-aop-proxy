package com.example.testing_aop_proxy.controller;

import com.example.testing_aop_proxy.dto.User;
import com.example.testing_aop_proxy.entity.Statistic;
import com.example.testing_aop_proxy.service.StatisticService;
import com.example.testing_aop_proxy.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    private final StatisticService statisticService;
    private static final String CLASS_NAME = "UserController";


    public UserController(UserService userService, StatisticService statisticService) {
        this.userService = userService;
        this.statisticService = statisticService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        long startedTime = System.currentTimeMillis();
        List<User> users =  userService.getUsers();
        statisticService.save(getStatistic("getUsers", startedTime, null));
        return users;
    }



    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") String id) {
        long startedTime = System.currentTimeMillis();
        User user =  userService.getUser(id);

        statisticService.save(getStatistic("getUser", startedTime, id));

        return user;
    }

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        long startedTime = System.currentTimeMillis();
        String id =  userService.createUser(user);
        statisticService.save(getStatistic("createUser", startedTime, id));
        return id;
    }

    private Statistic getStatistic(String method, long start, String requestId) {
        return Statistic.builder()
                .className(CLASS_NAME)
                .method(method)
                .duration(System.currentTimeMillis() - start)
                .requestId(requestId)
                .created(System.currentTimeMillis())
                .build();
    }
}
