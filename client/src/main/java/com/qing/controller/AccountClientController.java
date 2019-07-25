package com.qing.controller;

import com.qing.entity.Account;
import com.qing.entity.Admin;
import com.qing.entity.User;
import com.qing.feign.AccountFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Author: zhching
 * @Date: 2019/7/23 14:45
 * @Version 1.0
 */
@Controller
@RequestMapping("/accountClient")
public class AccountClientController {
    @Autowired
    private AccountFeignClient accountFeignClient;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session){
        Account account = accountFeignClient.login(username, password, type);
        String target = null;
        if (account == null){
            target= "login";
        }else {
            switch (type) {
                case "admin":
                    target = "redirect:/accountClient/redirect/manage";
                    session.setAttribute("admin",account);
                    break;
                case "user":
                    target = "redirect:/accountClient/redirect/index";
                    session.setAttribute("user",account);
                    break;
                 default:
                     break;
            }
        }
        return target;
    }

    @RequestMapping("/redirect/{target}")
    public String redirect(@PathVariable("target") String target){
        return target;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}
