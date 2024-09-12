package com.example.day15template.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.day15template.dto.DishDto;
import com.example.day15template.mapper.DishMapper;
import com.example.day15template.pojo.Category;
import com.example.day15template.pojo.Dish;
import com.example.day15template.pojo.DishFlavor;
import com.example.day15template.service.CategoryService;
import com.example.day15template.service.DishFlavorService;
import com.example.day15template.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
    @Autowired
    private DishFlavorService dishFlavorService;

//    @Autowired
//    private CategoryService categoryService;
    @Override
    @Transactional
    public void saveOrUpdateWithFlavor(DishDto dishDto) {
        this.saveOrUpdate(dishDto);
        Long dishId = dishDto.getId();
        LambdaQueryWrapper<DishFlavor> dishFlavorLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishFlavorLambdaQueryWrapper.eq(DishFlavor::getDishId,dishId);
        dishFlavorService.remove(dishFlavorLambdaQueryWrapper);
        List<DishFlavor> dishFlavors = dishDto.getFlavors().stream().map(item->{
            item.setDishId(dishId);
            return item;
        }).collect(Collectors.toList());
        dishFlavorService.saveOrUpdateBatch(dishFlavors);
    }

    @Override
    public DishDto getWithFlavor(Long id) {
        Dish dish = this.getById(id);
        DishDto dishDto = new DishDto();
        BeanUtils.copyProperties(dish,dishDto);
        List<DishFlavor> dishFlavorList = null;
        LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(DishFlavor::getDishId,id);
        dishFlavorList = dishFlavorService.list(lambdaQueryWrapper);
        dishDto.setFlavors(dishFlavorList);
        return dishDto;
    }

    @Override
    public void updateStatusByIds(Integer status, List<Long> ids) {
        LambdaUpdateWrapper<Dish> dishLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        dishLambdaUpdateWrapper.in(Dish::getId,ids);
        dishLambdaUpdateWrapper.set(Dish::getStatus, status);
        this.update(dishLambdaUpdateWrapper);
    }
}
