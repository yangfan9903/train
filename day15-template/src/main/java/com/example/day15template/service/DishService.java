package com.example.day15template.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.day15template.dto.DishDto;
import com.example.day15template.pojo.Dish;

public interface DishService extends IService<Dish> {
    void saveWithFlavor(DishDto dishDto);
}
