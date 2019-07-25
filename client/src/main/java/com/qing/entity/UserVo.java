package com.qing.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: zhching
 * @Date: 2019/7/22 14:44
 * @Version 1.0
 */
@Data
public class UserVo {
    private Integer code;
    private String msg;
    private Long count;
    private List<User> data;
}
