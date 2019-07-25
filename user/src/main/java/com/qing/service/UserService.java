package com.qing.service;

import com.qing.entity.User;

import java.util.List;

/**
 * @Author: zhching
 * @Date: 2019/7/22 14:17
 * @Version 1.0
 */
public interface UserService {
    /**
     * 查询全部
     *
     * @return List<User>
     */
    List<User> findAll();

    /**
     * 根据id查询
     *
     * @param  id
     * @return User
     */
    User findById(Integer id);
    /**
     * 根据id查询
     *
     * @param  user
     * @return int
     */
    int save(User user);
    /**
     * 更新
     *
     * @param  user
     * @return int
     */
    int update(User user);
    /**
     * 根据id删除
     *
     * @param  id
     * @return int
     */
    int deleteById(Integer id);
}
