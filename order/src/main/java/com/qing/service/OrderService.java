package com.qing.service;

import com.qing.entity.Order;

import java.util.List;

/**
 * @Author: zhching
 * @Date: 2019/7/24 11:01
 * @Version 1.0
 */
public interface OrderService {
    List<Order> findAllByUid(Integer uid);
    List<Order> findAllByState();
    int save(Order order);
    int deleteByUid(Integer uid);
    int deleteByMid(Integer mid);
    int updateState(Integer id);
}
