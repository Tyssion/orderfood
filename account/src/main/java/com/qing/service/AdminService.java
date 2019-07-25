package com.qing.service;

import com.qing.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zhching
 * @Date: 2019/7/23 10:39
 * @Version 1.0
 */
public interface AdminService {
    Admin login(String username, String password);
}
