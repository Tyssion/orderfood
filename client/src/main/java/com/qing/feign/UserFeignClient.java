package com.qing.feign;

import com.qing.entity.User;
import com.qing.entity.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 *
 * 声明式接口调用user服务
 *
 * @Author: zhching
 * @Date: 2019/7/22 15:18
 * @Version 1.0
 */
@FeignClient(value = "user")
public interface UserFeignClient {

    /***
     * 查询全部
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/user/findAll")
    UserVo findAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize);

    /***
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/user/findById/{id}")
    UserVo findById(@PathVariable("id") Integer id);

    /***
     * 添加
     *
     * @param user
     * @return
     */
    @PostMapping("/user/save")
    UserVo save(User user);

    /***
     * 更新
     *
     * @param user
     * @return
     */
    @PutMapping("/user/update")
    UserVo update(User user);

    /***
     * 根据id删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/user/deleteById/{id}")
    UserVo deleteById(@PathVariable("id") Integer id);
}
