package com.qing.controller;

import com.qing.entity.Menu;
import com.qing.entity.MenuVo;
import com.qing.feign.MenuFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: zhching
 * @Date: 2019/7/16 10:13
 * @Version 1.0
 */
@Controller
@RequestMapping("/menuClient")
public class MenuClientController {
    @Autowired
    private MenuFeignClient menuFeignClient;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVo findAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize){
        return menuFeignClient.findAll(pageNum,pageSize);
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id")Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu_update");
        modelAndView.addObject("menu",menuFeignClient.findById(id).getData().get(0));
        modelAndView.addObject("types",menuFeignClient.findTypes());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Menu menu){
        menuFeignClient.save(menu);
        //添加成功之后重定向到菜单页
        return redirect("menu");
    }

    @PostMapping("/update")
    public String update(Menu menu){
        menuFeignClient.update(menu);
        //更新成功之后重定向到菜单页
        return redirect("menu");
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseBody
    public MenuVo deleteById(@PathVariable("id")Integer id){
        return menuFeignClient.deleteById(id);
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
        modelAndView.setViewName("menu_add");
        modelAndView.addObject("list",menuFeignClient.findTypes());
        return modelAndView;
    }

}
