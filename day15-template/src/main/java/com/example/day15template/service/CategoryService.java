package com.example.day15template.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.day15template.pojo.Category;

public interface CategoryService extends IService<Category> {
    void remove(Long id);
}
