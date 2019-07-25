package com.qing.dao;

import com.qing.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zhching
 * @Date: 2019/7/22 14:16
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    /**
     * 查询全部
     *
     * @return List<Menu>
     */
    List<User> findAll();

    /**
     * 根据id查询
     *
     * @param  id
     * @return Menu
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
