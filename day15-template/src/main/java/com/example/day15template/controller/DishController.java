package com.example.day15template.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.day15template.common.R;
import com.example.day15template.dto.DishDto;
import com.example.day15template.pojo.Category;
import com.example.day15template.pojo.Dish;
import com.example.day15template.pojo.DishFlavor;
import com.example.day15template.service.CategoryService;
import com.example.day15template.service.DishFlavorService;
import com.example.day15template.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DishFlavorService dishFlavorService;

    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name){
        Page<Dish> pageInfo = new Page<>(page,pageSize);
        Page<DishDto> dishDtoPage = new Page<>();
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.like(StringUtils.isNotEmpty(name), Dish::getName, name);
        dishLambdaQueryWrapper.orderByDesc(Dish::getUpdateTime);
        dishService.page(pageInfo,dishLambdaQueryWrapper);
        BeanUtils.copyProperties(pageInfo, dishDtoPage,"records");
        List<DishDto> dishDtoList = pageInfo.getRecords().stream().map(item->{
            DishDto dishDto = new DishDto();
            BeanUtils.copyProperties(item,dishDto);
            Long categoryId = item.getCategoryId();
            Category category = categoryService.getById(categoryId);
            if (category!=null){
                String categoryName = category.getName();
                dishDto.setCategoryName(categoryName);
            }
            return dishDto;
        }).collect(Collectors.toList());
        dishDtoPage.setRecords(dishDtoList);


        return R.success(dishDtoPage);
    }

    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto){
        dishService.saveOrUpdateWithFlavor(dishDto);
        return R.success("添加菜品信息成功");
    }
    @PutMapping
    public R<String> update(@RequestBody DishDto dishDto){
        dishService.saveOrUpdateWithFlavor(dishDto);
        return R.success("修改菜品信息成功");
    }

    /**
     * 根据id查询菜品信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<DishDto> getById(@PathVariable Long id){
        DishDto dishDto = dishService.getWithFlavor(id);
//        Dish dish = dishService.getById(id);
//        DishDto dishDto = new DishDto();
//        BeanUtils.copyProperties(dish,dishDto);
//        Category category = categoryService.getById(id);
//        if (category!=null){
//            dishDto.setCategoryName(category.getName());
//        }else {
//            log.info("没有找到该菜品分类名称");
//        }
//        List<DishFlavor> dishFlavorList = null;
//        LambdaQueryWrapper<DishFlavor> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(DishFlavor::getDishId,id);
//        dishFlavorList = dishFlavorService.list(lambdaQueryWrapper);
//        dishDto.setFlavors(dishFlavorList);
        return R.success(dishDto);


    }

//    @PostMapping
//    public R<String>



    /**
     * 修改菜品起售信息
     * @param status
     * @param ids
     * @return
     */
    @PostMapping("/status/{status}")
    public R<String> updateStatus(@PathVariable Integer status, @RequestParam List<Long> ids){
        log.info(ids.toString());
        dishService.updateStatusByIds(status, ids);
        return R.success("修改起售信息成功");

    }

    @GetMapping("/list")
    public R<List<Dish>> selectByCagtegory(Long categoryId){
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(categoryId!=null, Dish::getCategoryId, categoryId);
        dishLambdaQueryWrapper.eq(Dish::getStatus,1);
        dishLambdaQueryWrapper.orderByAsc(Dish::getSort).orderByDesc(Dish::getUpdateTime);
        return R.success(dishService.list(dishLambdaQueryWrapper));
    }



}
