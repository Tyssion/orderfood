package com.qing.controller;

import com.qing.entity.*;
import com.qing.feign.OrderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author: zhching
 * @Date: 2019/7/24 14:10
 * @Version 1.0
 */
@Controller
@RequestMapping("/orderClient")
public class OrderClientController {
    @Autowired
    private OrderFeignClient orderFeignClient;

    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderVo findAllByUid(@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "10")Integer pageSize, HttpSession session){
        Account account = (Account) session.getAttribute("user");
        return orderFeignClient.findAllByUid(pageNum,pageSize,account.getId());
    }

    @GetMapping("/findAllByState")
    @ResponseBody
    public OrderVo findAllByState(@RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "10")Integer pageSize){
        return orderFeignClient.findAllByState(pageNum,pageSize,0);
    }

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") Integer mid, HttpSession session){
        Account account = (Account) session.getAttribute("user");
        Order order = new Order();
        Menu menu = new Menu();
        menu.setId(mid);
        User user = new User();
        user.setId(account.getId());
        user.setNickname(account.getNickname());
        order.setUser(user);
        order.setMenu(menu);
        order.setDate(new Date());
        orderFeignClient.save(order);
        return "redirect:/accountClient/redirect/order";
    }

    @GetMapping("/updateState/{id}")
    public String updateState(@PathVariable("id") Integer id){
        orderFeignClient.updateState(id);
        return "redirect:/accountClient/redirect/order_handle";
    }
}
