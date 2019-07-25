package com.qing.dao;

import com.qing.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zhching
 * @Date: 2019/7/23 10:39
 * @Version 1.0
 */
@Mapper
public interface AdminMapper {
    Admin login(String username,String password);
}
