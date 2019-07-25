package com.qing.service.impl;

import com.qing.dao.OrderMapper;
import com.qing.entity.Order;
import com.qing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhching
 * @Date: 2019/7/24 11:01
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findAllByUid(Integer uid) {
        return orderMapper.findAllByUid(uid);
    }

    @Override
    public List<Order> findAllByState() {
        return orderMapper.findAllByState();
    }

    @Override
    public int save(Order order) {
        return orderMapper.save(order);
    }

    @Override
    public int deleteByUid(Integer uid) {
        return orderMapper.deleteByUid(uid);
    }

    @Override
    public int deleteByMid(Integer mid) {
        return orderMapper.deleteByMid(mid);
    }

    @Override
    public int updateState(Integer id) {
        return orderMapper.updateState(id);
    }
}
