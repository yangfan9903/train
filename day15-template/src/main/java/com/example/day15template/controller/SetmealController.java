package com.example.day15template.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.day15template.common.R;
import com.example.day15template.dto.SetmealDto;
import com.example.day15template.pojo.Category;
import com.example.day15template.pojo.Setmeal;
import com.example.day15template.pojo.SetmealDish;
import com.example.day15template.service.CategoryService;
import com.example.day15template.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    @Autowired
    private SetmealService setmealService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name){
        Page<Setmeal> pageInfo = new Page<>(page,pageSize);
        Page<SetmealDto> setmealDtoPage = new Page<>(page,pageSize);
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.like(StringUtils.isNotEmpty(name),Setmeal::getName,name);
        setmealLambdaQueryWrapper.orderByDesc(Setmeal::getUpdateTime);
        setmealService.page(pageInfo,setmealLambdaQueryWrapper);
        BeanUtils.copyProperties(pageInfo,setmealDtoPage,"records");
        List<SetmealDto> setmealDtoList = pageInfo.getRecords().stream().map(item->{
            SetmealDto setmealDto = new SetmealDto();
            BeanUtils.copyProperties(item,setmealDto);
            Category category = categoryService.getById(item.getCategoryId());
            if (category !=null){
                setmealDto.setCategoryName(category.getName());
            }else {
                log.info("未找到该分类名称");
            }
            return setmealDto;
        }).collect(Collectors.toList());
        setmealDtoPage.setRecords(setmealDtoList);
        return R.success(setmealDtoPage);
    }

    @PostMapping
    public R<String> saveSetmealWithDish(@RequestBody SetmealDto setmealDto){
        setmealService.saveSetmealWithDish(setmealDto);
        return R.success("成功添加菜品信息");
    }

    @GetMapping("/{id}")
    public R<SetmealDto> getById(@PathVariable Long id){
        SetmealDto setmealDto = setmealService.getByIdWithDishes(id);
        return R.success(setmealDto);
    }

    @PostMapping("/status/{status}")
    public R<String> updateStatus(@PathVariable Integer status, @RequestParam List<Long> ids){
        setmealService.updateStatus(status,ids);
        return R.success("成功修改商品售卖状态为"+ (status==1? "启售" : "停售"));
    }


    @DeleteMapping
    public R<String> deleteWithDishesByIds(@RequestParam List<Long> ids){
        setmealService.deleteWithDishesByIds(ids);
        return R.success("删除套餐信息成功");
    }



}
