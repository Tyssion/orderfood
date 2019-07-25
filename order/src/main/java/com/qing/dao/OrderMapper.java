package com.qing.dao;

import com.qing.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zhching
 * @Date: 2019/7/24 10:28
 * @Version 1.0
 */
@Mapper
public interface OrderMapper {
    List<Order> findAllByUid(Integer uid);
    List<Order> findAllByState();
    int save(Order order);
    int deleteByUid(Integer uid);
    int deleteByMid(Integer mid);
    int updateState(Integer id);
}
