package com.example.day15template.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.day15template.dto.DishDto;
import com.example.day15template.pojo.Dish;

import java.util.List;

public interface DishService extends IService<Dish> {
    void saveOrUpdateWithFlavor(DishDto dishDto);

    DishDto getWithFlavor(Long id);

    void updateStatusByIds(Integer status, List<Long> ids);
}
