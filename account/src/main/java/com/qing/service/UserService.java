package com.qing.service;

import com.qing.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zhching
 * @Date: 2019/7/23 10:38
 * @Version 1.0
 */
public interface UserService {
    User login(String username, String password);
}
