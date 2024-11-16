package com.example.kob_bankend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.kob_bankend.mapper.UserMapper;
import com.example.kob_bankend.pojo.User;
import com.example.kob_bankend.service.impl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("username", username);
        User user = userMapper.selectOne(queryWrapper);
        return new UserDetailsImpl(user);
    }
}
