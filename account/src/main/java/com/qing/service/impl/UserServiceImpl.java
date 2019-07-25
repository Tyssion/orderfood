package com.qing.service.impl;

import com.qing.dao.UserMapper;
import com.qing.entity.User;
import com.qing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhching
 * @Date: 2019/7/23 14:20
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }
}
