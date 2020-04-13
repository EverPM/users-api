package com.everpm.users.api.controller;

import com.everpm.users.api.cache.CacheApiService;
import com.everpm.users.api.cache.UserParam;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private CacheApiService cacheApiService;

    @PostMapping("/users")
    public String registerUser() {
        UserParam param = UserParam.builder().name("chathuranga")
                .isCached(true)
                .build();
        cacheApiService.getCache(param);
        return "register user";
    }

    @GetMapping("/users")
    public String getUsers() {
        return "get users";
    }
}
