package com.example.day15template.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.day15template.dto.SetmealDto;
import com.example.day15template.pojo.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    void saveSetmealWithDish(SetmealDto setmealDto);

    SetmealDto getByIdWithDishes(Long id);

    void updateStatus(Integer status, List<Long> ids);

    void deleteWithDishesByIds(List<Long> ids);
}
