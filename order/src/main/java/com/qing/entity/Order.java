package com.qing.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: zhching
 * @Date: 2019/7/24 10:23
 * @Version 1.0
 */
@Data
public class Order {
    private Integer id;
    private User user;
    private Menu menu;
    private Admin admin;
    private Date date;
    private Integer state;
}
