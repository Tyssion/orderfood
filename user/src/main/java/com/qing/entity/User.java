package com.qing.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: zhching
 * @Date: 2019/7/22 14:19
 * @Version 1.0
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private Date registerDate;
    private String address;
}
