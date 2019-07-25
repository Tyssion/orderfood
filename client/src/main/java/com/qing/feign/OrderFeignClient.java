package com.qing.feign;

import com.qing.entity.Order;
import com.qing.entity.OrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhching
 * @Date: 2019/7/24 14:04
 * @Version 1.0
 */
@FeignClient(value = "order")
public interface OrderFeignClient {

    @GetMapping("/order/findAllByUid")
    OrderVo findAllByUid(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam("uid") Integer uid);

    @GetMapping("/order/findAllByState")
    OrderVo findAllByState(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam("state") Integer state);

    @PostMapping("/order/save")
    OrderVo save(Order order);

    @DeleteMapping("/order/deleteByUid/{uid}")
    OrderVo deleteByUid(@PathVariable("uid") Integer uid);

    @DeleteMapping("/order/deleteByUid/{mid}")
    OrderVo deleteByMid(@PathVariable("mid") Integer mid);

    @PutMapping("/order/updateState/{id}")
    OrderVo updateState(@PathVariable("id") Integer id);
}
