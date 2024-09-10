package com.example.day15template.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.day15template.common.CustomException;
import com.example.day15template.mapper.CategoryMapper;
import com.example.day15template.pojo.Category;
import com.example.day15template.pojo.Dish;
import com.example.day15template.pojo.Setmeal;
import com.example.day15template.service.CategoryService;
import com.example.day15template.service.DishService;
import com.example.day15template.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;


    /**
     * 删除分类信息
     * @param id
     */
    @Override
    public void remove(Long id) {
        log.info("正在调用删除分类接口");
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        Long dishCountByCategory = dishService.count(dishLambdaQueryWrapper);
        // 查询当前分类是否有关联菜品，如果关联抛出异常
        if (dishCountByCategory>0){
            throw new CustomException("当前分类下关联了菜品,不能删除");
        }
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        Long setmealCountByCategory = setmealService.count(setmealLambdaQueryWrapper);
        // 查询当前分类是否有关联套餐，如果关联抛出异常
        if (setmealCountByCategory>0){
            throw new CustomException("当前分类下关联了套餐,不能删除");
        }
        super.removeById(id);

    }
}
