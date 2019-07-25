package com.qing.service.impl;

import com.qing.dao.UserMapper;
import com.qing.entity.User;
import com.qing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: zhching
 * @Date: 2019/7/22 14:17
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public int save(User user) {
        user.setRegisterDate(new Date());
        return userMapper.save(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }
}
