package com.qing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qing.entity.Order;
import com.qing.entity.OrderVo;
import com.qing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zhching
 * @Date: 2019/7/24 11:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/findAllByUid")
    public OrderVo findAllByUid(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam("uid") Integer uid) {
        OrderVo orderVo = new OrderVo();
        PageHelper.startPage(pageNum, pageSize);
        List<Order> list = orderService.findAllByUid(uid);
        if (list.size() > 0) {
            PageInfo<Order> pageInfo = new PageInfo<>(list);
            orderVo.setCode(0);
            orderVo.setCount(pageInfo.getTotal());
            orderVo.setData(pageInfo.getList());
            orderVo.setMsg("订单查询成功");
            return orderVo;
        }
        orderVo.setCode(1);
        orderVo.setMsg("订单查询结果为空");
        return orderVo;
    }

    @GetMapping("/findAllByState")
    public OrderVo findAllByState(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        OrderVo orderVo = new OrderVo();
        PageHelper.startPage(pageNum, pageSize);
        List<Order> list = orderService.findAllByState();
        if (list.size() > 0) {
            PageInfo<Order> pageInfo = new PageInfo<>(list);
            orderVo.setCode(0);
            orderVo.setCount(pageInfo.getTotal());
            orderVo.setData(pageInfo.getList());
            orderVo.setMsg("根据订单状态查询结果为空");
            return orderVo;
        }
        orderVo.setCode(1);
        orderVo.setMsg("根据订单状态查询失败");
        return orderVo;
    }

    @PostMapping("/save")
    public OrderVo save(@RequestBody Order order) {
        OrderVo orderVo = new OrderVo();
        if (orderService.save(order) > 0) {
            orderVo.setCode(0);
            orderVo.setMsg("订单创建成功");
            return orderVo;
        }
        orderVo.setCode(1);
        orderVo.setMsg("订单创建失败");
        return orderVo;
    }

    @DeleteMapping("/deleteByUid/{uid}")
    public OrderVo deleteByUid(@PathVariable("uid") Integer uid) {
        OrderVo orderVo = new OrderVo();
        if (orderService.deleteByUid(uid) > 0) {
            orderVo.setCode(0);
            orderVo.setMsg("订单删除成功");
            return orderVo;
        }
        orderVo.setCode(1);
        orderVo.setMsg("订单删除失败");
        return orderVo;
    }

    @DeleteMapping("/deleteByUid/{mid}")
    public OrderVo deleteByMid(@PathVariable("mid") Integer mid) {
        OrderVo orderVo = new OrderVo();
        if (orderService.deleteByMid(mid) > 0) {
            orderVo.setCode(0);
            orderVo.setMsg("订单删除成功");
            return orderVo;
        }
        orderVo.setCode(1);
        orderVo.setMsg("订单删除失败");
        return orderVo;
    }

    @PutMapping("/updateState/{id}")
    public OrderVo updateState(@PathVariable("id") Integer id) {
        OrderVo orderVo = new OrderVo();

        if (orderService.updateState(id) > 0) {
            orderVo.setCode(0);
            orderVo.setMsg("订单状态更新成功");
            return orderVo;
        }
        orderVo.setCode(1);
        orderVo.setMsg("订单状态更新失败");
        return orderVo;
    }

}
