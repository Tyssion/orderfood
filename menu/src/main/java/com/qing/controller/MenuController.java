package com.qing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qing.entity.Menu;
import com.qing.entity.MenuVo;
import com.qing.entity.Type;
import com.qing.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhching
 * @Date: 2019/7/15 15:32
 * @Version 1.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    MenuVo menuVo = new MenuVo();

    @GetMapping("/findAll")
    public MenuVo findAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Menu> pageInfo = new PageInfo<>(menuService.findAll());

        if (menuService.findAll().size()>0){
            menuVo.setCode(0);
            menuVo.setMsg("菜单查询成功");
            menuVo.setCount(pageInfo.getTotal());
            menuVo.setData(pageInfo.getList());
            return menuVo;
        }else {
            menuVo.setCode(0);
            menuVo.setMsg("菜单查询失败");
            return menuVo;
        }
    }

    @GetMapping("/findById/{id}")
    public MenuVo finById(@PathVariable("id") Integer id){
        List<Menu> list = new ArrayList<>();
        if (menuService.findById(id) != null){
            list.add(menuService.findById(id));
            menuVo.setCode(0);
            menuVo.setMsg("菜单查询成功");
            menuVo.setData(list);
            return menuVo;
        }else {
            menuVo.setCode(0);
            menuVo.setMsg("菜单查询失败");
            return menuVo;
        }
    }

    @PostMapping("/save")
    public MenuVo save(@RequestBody Menu menu){
        if (menuService.save(menu) > 0){
            menuVo.setCode(0);
            menuVo.setMsg("菜单添加成功");
            return menuVo;
        }else {
            menuVo.setCode(1);
            menuVo.setMsg("菜单添加失败");
            return menuVo;
        }
    }

    @PutMapping("/update")
    public MenuVo update(@RequestBody Menu menu){
        if (menuService.update(menu) > 0){
            menuVo.setCode(0);
            menuVo.setMsg("菜单更新成功");
            return menuVo;
        }else {
            menuVo.setCode(1);
            menuVo.setMsg("菜单更新失败");
            return menuVo;
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public MenuVo deleteById(@PathVariable("id") Integer id){
        if (menuService.deleteById(id) > 0){
            menuVo.setCode(0);
            menuVo.setMsg("菜单删除成功");
            return menuVo;
        }else {
            menuVo.setCode(1);
            menuVo.setMsg("菜单删除失败");
            return menuVo;
        }
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes(){
        return menuService.findTypes();
    }
}
