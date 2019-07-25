package com.qing.feign;

import com.qing.entity.Menu;
import com.qing.entity.MenuVo;
import com.qing.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 声明式接口调用menu服务
 *
 * @Author: zhching
 * @Date: 2019/7/16 9:56
 * @Version 1.0
 */
@FeignClient(value = "menu")
public interface MenuFeignClient {

    /***
     * 查询全部
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/menu/findAll")
    MenuVo findAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize);

    /***
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/menu/findById/{id}")
    MenuVo findById(@PathVariable("id") Integer id);

    /***
     * 添加
     *
     * @param menu
     * @return
     */
    @PostMapping("/menu/save")
    MenuVo save(Menu menu);

    /***
     * 更新
     *
     * @param menu
     * @return
     */
    @PutMapping("/menu/update")
    MenuVo update(Menu menu);

    /***
     * 根据id删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/menu/deleteById/{id}")
    MenuVo deleteById(@PathVariable("id") Integer id);

    /***
     * 查询所有类型
     *
     * @return
     */
    @GetMapping("/menu/findTypes")
    List<Type> findTypes();
}
