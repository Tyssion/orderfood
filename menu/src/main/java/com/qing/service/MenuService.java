package com.qing.service;

import com.qing.entity.Menu;
import com.qing.entity.Type;

import java.util.List;

/**
 * @Author: zhching
 * @Date: 2019/7/15 11:26
 * @Version 1.0
 */
public interface MenuService {
    /**
     * 查询全部
     *
     * @return List<Menu>
     */
    List<Menu> findAll();
    /**
     * 查询总条数
     *
     * @return Integer
     */
    Integer selectCount();
    /**
     * 根据id查询
     *
     * @param  id
     * @return Menu
     */
    Menu findById(Integer id);
    /**
     * 根据id查询
     *
     * @param  menu
     * @return int
     */
    int save(Menu menu);
    /**
     * 更新
     *
     * @param  menu
     * @return int
     */
    int update(Menu menu);
    /**
     * 根据id删除
     *
     * @param  id
     * @return int
     */
    int deleteById(Integer id);

    /***
     * 查询全部类型
     * @return
     */
    List<Type> findTypes();

}
