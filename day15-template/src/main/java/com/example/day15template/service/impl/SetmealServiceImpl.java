package com.example.day15template.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.day15template.common.CustomException;
import com.example.day15template.dto.SetmealDto;
import com.example.day15template.mapper.SetmealMapper;
import com.example.day15template.pojo.Dish;
import com.example.day15template.pojo.Setmeal;
import com.example.day15template.pojo.SetmealDish;
import com.example.day15template.service.DishService;
import com.example.day15template.service.SetmealDishService;
import com.example.day15template.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
    @Autowired
    private SetmealDishService setmealDishService;
    @Autowired
    private DishService dishService;


    @Override
    @Transactional
    public void saveSetmealWithDish(SetmealDto setmealDto) {
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getName,setmealDto.getName());
        if (this.getOne(setmealLambdaQueryWrapper)==null) {
            this.save(setmealDto);
        }
        List<SetmealDish> setmealDishList = setmealDto.getSetmealDishes();
        setmealDishList = setmealDishList.stream().map(item->{
            item.setSetmealId(setmealDto.getId());
//            LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
//            dishLambdaQueryWrapper.eq(Dish::getName,item.getName());
//            item.setDishId(dishService.getOne(dishLambdaQueryWrapper).getId());
            return item;
        }).collect(Collectors.toList());
        setmealDishService.saveBatch(setmealDishList);
    }

    @Override
    public SetmealDto getByIdWithDishes(Long id) {
        SetmealDto setmealDto = new SetmealDto();
        Setmeal setmeal = this.getById(id);
        BeanUtils.copyProperties(setmeal,setmealDto);
        LambdaQueryWrapper<SetmealDish> setmealDishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealDishLambdaQueryWrapper.eq(SetmealDish::getSetmealId,setmeal.getId());
        List<SetmealDish> setmealDishList = setmealDishService.list(setmealDishLambdaQueryWrapper);
        setmealDto.setSetmealDishes(setmealDishList);
        return setmealDto;
    }

    @Override
    public void updateStatus(Integer status, List<Long> ids) {
        LambdaUpdateWrapper<Setmeal> setmealLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        setmealLambdaUpdateWrapper.in(Setmeal::getId,ids);
        setmealLambdaUpdateWrapper.set(Setmeal::getStatus,status);
        this.update(setmealLambdaUpdateWrapper);
    }

    @Transactional
    @Override
    public void deleteWithDishesByIds(List<Long> ids) {
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.in(Setmeal::getId,ids);
        setmealLambdaQueryWrapper.eq(Setmeal::getStatus,1);
        if (this.count(setmealLambdaQueryWrapper)!=0){
            throw new CustomException("套餐正在售卖中，不能删除");
        }
        this.removeByIds(ids);
        LambdaUpdateWrapper<SetmealDish> setmealDishLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        setmealDishLambdaUpdateWrapper.in(SetmealDish::getSetmealId,ids);
        setmealDishService.remove(setmealDishLambdaUpdateWrapper);

    }
}
