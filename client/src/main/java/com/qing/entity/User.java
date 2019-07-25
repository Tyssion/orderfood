package com.qing.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: zhching
 * @Date: 2019/7/22 14:19
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends Admin{

}
