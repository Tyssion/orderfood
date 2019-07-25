package com.qing.controller;

import com.qing.entity.Account;
import com.qing.service.AdminService;
import com.qing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhching
 * @Date: 2019/7/23 14:22
 * @Version 1.0
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @GetMapping("/login/{username}/{password}/{type}")
    public Account login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type){
        Account account = null;
        switch (type){
            case "admin":
                account = adminService.login(username, password);
                break;
            case "user":
                account = userService.login(username, password);
                break;
            default:
                break;
        }
        return account;
    }
}
