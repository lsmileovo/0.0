package com.example.backend.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/userinfo")
    public List<User> getAll(){
        return userMapper.selectList(null);
    }

    @GetMapping("/user/{userid}")
    public User getUser(@PathVariable int userid){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", userid);
        return userMapper.selectOne(queryWrapper);
    }

    @GetMapping("/adduser/{userid}/{username}/{password}")
    public String addUser(@PathVariable Integer userid,
                          @PathVariable String username,
                          @PathVariable String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoderPassword = encoder.encode(password);
        User user = new User(userid, username, encoderPassword);
        userMapper.insert(user);
        return "Add User Successfully";
    }

    @GetMapping("/deleteuser/{userid}")
    public String deleteUser(@PathVariable int userid){
        userMapper.deleteById(userid);
        return "Delete User Successfully";
    }

}
