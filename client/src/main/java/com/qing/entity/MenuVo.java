package com.qing.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: zhching
 * @Date: 2019/7/15 11:22
 * @Version 1.0
 */
@Data
public class MenuVo {
    private Integer code;
    private String msg;
    private Long count;
    private List<Menu> data;
}
