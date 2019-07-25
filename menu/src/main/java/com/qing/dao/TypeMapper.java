package com.qing.dao;

import com.qing.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zhching
 * @Date: 2019/7/17 10:27
 * @Version 1.0
 */
@Mapper
public interface TypeMapper {
    /***
     * 查询全部
     * @return
     */
    List<Type> findAll();

    /***
     * 根据id查询
     * @param id
     * @return
     */
    Type findById(String id);
}
