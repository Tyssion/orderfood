package com.qing.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: zhching
 * @Date: 2019/7/23 14:29
 * @Version 1.0
 */
@Data
public class Account {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private Date registerDate;
    private String address;
}
