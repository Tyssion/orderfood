package com.qing.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Author: zhching
 * @Date: 2019/7/15 11:22
 * @Version 1.0
 */
@Data
public class Menu {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String flavor;
    private Type type;
}
