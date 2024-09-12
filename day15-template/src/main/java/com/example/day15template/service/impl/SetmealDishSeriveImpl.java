package com.example.day15template.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.day15template.mapper.SetmealDishMapper;
import com.example.day15template.pojo.SetmealDish;
import com.example.day15template.service.SetmealDishService;
import org.springframework.stereotype.Service;

@Service
public class SetmealDishSeriveImpl extends ServiceImpl<SetmealDishMapper, SetmealDish> implements SetmealDishService {
}
