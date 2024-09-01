package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import com.example.service.impl.DeptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController  // 是组合注解包括responsebody 会将返回值转成json
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result selectAll(){
        log.info("部门信息的查询操作");
        List<Dept> deptList = deptService.selectAll();
        return Result.success(deptList);
    }

    /**
     * 根据id删除部门
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        log.info("根据id删除部门:{}",id);
        deptService.deleteById(id);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Dept dept){
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        log.info("插入部门信息:{}",dept.getName());
        deptService.insert(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        return Result.success(deptService.selectById(id));
    }

    @PutMapping
    public Result updataById(@RequestBody Dept dept){
        dept.setUpdateTime(LocalDateTime.now());
        deptService.updataById(dept);
        return Result.success();
    }
}
