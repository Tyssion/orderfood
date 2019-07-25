package com.qing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qing.entity.User;
import com.qing.entity.UserVo;
import com.qing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhching
 * @Date: 2019/7/22 14:42
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public UserVo findAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize){
        UserVo userVo = new UserVo();
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(userService.findAll());

        if (userService.findAll().size()>0){
            userVo.setCode(0);
            userVo.setMsg("用户查询成功");
            userVo.setCount(pageInfo.getTotal());
            userVo.setData(pageInfo.getList());
            return userVo;
        }else {
            userVo.setCode(0);
            userVo.setMsg("用户查询失败");
            return userVo;
        }
    }

    @GetMapping("/findById/{id}")
    public UserVo finById(@PathVariable("id") Integer id){
        UserVo userVo = new UserVo();
        List<User> list = new ArrayList<>();
        if (userService.findById(id) != null){
            list.add(userService.findById(id));
            userVo.setCode(0);
            userVo.setMsg("用户查询成功");
            userVo.setData(list);
            return userVo;

        }else {
            userVo.setCode(0);
            userVo.setMsg("用户查询失败");
            return userVo;
        }
    }

    @PostMapping("/save")
    public UserVo save(@RequestBody User user){
        UserVo userVo = new UserVo();
        if (userService.save(user) > 0){
            userVo.setCode(0);
            userVo.setMsg("用户添加成功");
            return userVo;
        }else {
            userVo.setCode(1);
            userVo.setMsg("用户添加失败");
            return userVo;
        }
    }

    @PutMapping("/update")
    public UserVo update(@RequestBody User user){
        UserVo userVo = new UserVo();
        if (userService.update(user) > 0){
            userVo.setCode(0);
            userVo.setMsg("用户更新成功");
            return userVo;
        }else {
            userVo.setCode(1);
            userVo.setMsg("用户更新失败");
            return userVo;
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public UserVo deleteById(@PathVariable("id") Integer id){
        UserVo userVo = new UserVo();
        if (userService.deleteById(id) > 0){
            userVo.setCode(0);
            userVo.setMsg("用户删除成功");
            return userVo;
        }else {
            userVo.setCode(1);
            userVo.setMsg("用户删除失败");
            return userVo;
        }
    }

}
