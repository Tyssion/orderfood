package com.qing.controller;

import com.qing.entity.User;
import com.qing.entity.UserVo;
import com.qing.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: zhching
 * @Date: 2019/7/22 15:22
 * @Version 1.0
 */
@Controller
@RequestMapping("/userClient")
public class UserClientController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/findAll")
    @ResponseBody
    public UserVo findAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize){
        return userFeignClient.findAll(pageNum,pageSize);
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id")Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_update");
        modelAndView.addObject("user",userFeignClient.findById(id).getData().get(0));
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(User user){
        userFeignClient.save(user);
        //添加成功之后重定向到用户列表页
        return "redirect:/userClient/redirect/user";
    }

    @PostMapping("/update")
    public String update(User user){
        userFeignClient.update(user);
        //更新成功之后重定向到用户列表页
        return redirect("user");
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseBody
    public UserVo deleteById(@PathVariable("id")Integer id){
        return userFeignClient.deleteById(id);
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location")String location){
        return location;
    }

    /***
     * 跳转到添加页面
     * @return
     */
    @GetMapping("/gotoAdd")
    public ModelAndView gotoAdd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_add");
        return modelAndView;
    }

}
