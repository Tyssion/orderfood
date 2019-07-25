package com.qing.service.impl;

import com.qing.dao.MenuMapper;
import com.qing.dao.TypeMapper;
import com.qing.entity.Menu;
import com.qing.entity.Type;
import com.qing.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhching
 * @Date: 2019/7/15 11:26
 * @Version 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Menu> findAll() {
        return menuMapper.findAll();
    }

    @Override
    public Integer selectCount() {
        return menuMapper.selectCount();
    }

    @Override
    public Menu findById(Integer id) {
        return menuMapper.findById(id);
    }

    @Override
    public int save(Menu menu) {
        return menuMapper.save(menu);
    }

    @Override
    public int update(Menu menu) {
        return menuMapper.update(menu);
    }

    @Override
    public int deleteById(Integer id) {
        return menuMapper.deleteById(id);
    }

    @Override
    public List<Type> findTypes() {
        return typeMapper.findAll();
    }
}
