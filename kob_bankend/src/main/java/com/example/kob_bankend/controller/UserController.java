package com.example.kob_bankend.controller;

import com.example.kob_bankend.mapper.UserMapper;
import com.example.kob_bankend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/userinfo")
    public List<User> getUser(){
        return userMapper.selectList(null);
    }

    @GetMapping("/adduser/{id}/{username}/{password}")
    public String addUser(@PathVariable int id,
                          @PathVariable String username,
                          @PathVariable String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String newPassword = encoder.encode(password);
        User user = new User(id, username, newPassword);
        userMapper.insert(user);
        return "Add User";
    }
}
