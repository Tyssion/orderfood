package com.qing.service.impl;

import com.qing.dao.AdminMapper;
import com.qing.entity.Admin;
import com.qing.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zhching
 * @Date: 2019/7/23 14:19
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        return adminMapper.login(username, password);
    }
}
