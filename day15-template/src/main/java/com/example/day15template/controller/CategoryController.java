package com.example.day15template.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.day15template.common.BaseContext;
import com.example.day15template.common.R;
import com.example.day15template.pojo.Category;
import com.example.day15template.service.CategoryService;
import com.example.day15template.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public R<String> save(HttpServletRequest request, @RequestBody Category category){
        log.info("category:{}",category);
        String jwt = (String)request.getSession().getAttribute("employee");
        log.info(jwt);
        try {
            JwtUtils.parseJwt(jwt);
//            log.info(claims.get("id").toString());

        } catch (Exception e) {
            return R.error("非法修改员工信息");
        }
        Claims claims = JwtUtils.parseJwt(jwt);
        Long empId = Long.parseLong(claims.get("id").toString());
//        employee.setUpdateUser(empId);
        BaseContext.setCurrentId(empId);
        categoryService.save(category);
        return R.success("成功添加分类信息");
    }

    @GetMapping("/page")
    public R<Page> page(int page, int pageSize){
        Page<Category> pageInfo = new Page<>(page,pageSize);
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByAsc(Category::getSort);
        categoryService.page(pageInfo,lambdaQueryWrapper);
        return R.success(pageInfo);
    }

    @DeleteMapping
    public R<String> delete(Long ids){
        log.info("删除分类,id为{}",ids);
        categoryService.remove(ids);
        return R.success("分类信息删除成功");
    }

    /**
     * 根据id修改分类信息
     * @param category
     * @return
     */
    @PutMapping
    public R<String> update(HttpServletRequest request, @RequestBody Category category){

        String jwt = (String)request.getSession().getAttribute("employee");
        log.info(jwt);
        try {
            JwtUtils.parseJwt(jwt);
//            log.info(claims.get("id").toString());

        } catch (Exception e) {
            return R.error("非法修改员工信息");
        }
        Claims claims = JwtUtils.parseJwt(jwt);
        Long empId = Long.parseLong(claims.get("id").toString());
//        employee.setUpdateUser(empId);
        BaseContext.setCurrentId(empId);
        categoryService.updateById(category);
        return R.success("修改分类成功");
    }
}
