package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.EmpService;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    //    @Autowired
//    private EmpMapper empMapper;
//    @GetMapping("/depts")
//    public Result selectAll(){
//        List<Dept> deptList = empMapper.;
//        return Result.success(deptList);
//    }
    @Autowired
    private EmpService empService;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping
    public Result selectByCondition(String name,
                                    Integer gender,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                                    @RequestParam(required = false,defaultValue = "1") Integer page,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer pageSize){
        log.info("员工查询操作");
        PageBean pageBean = empService.selectByCondition(name, gender, begin, end, page, pageSize);
        return Result.success(pageBean);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("查询员工信息,id:{}",id);
        return Result.success(empService.selectById(id));
    }

    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids){
        log.info("根据id删除员工,删除的员工id为{}",ids);
        empService.deleteByIds(ids);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Emp emp){
        log.info("添加员工信息");
        empService.insert(emp);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息");
        empService.update(emp);
        return Result.success();
    }
//@GetMapping
//public Result selectByCondition(String name,
//                                @RequestParam(required = false,defaultValue = "1") Integer page,
//                                @RequestParam(required = false, defaultValue = "10")Integer pageSize){
//    log.info("员工查询操作");
//    PageBean pageBean = empService.selectByCondition(name,page, pageSize);
//    return Result.success(pageBean);
//}
//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize){
//        log.info("分页查询,参数:{},{}", page,pageSize);
//
//        PageBean pageBean = empService.page(page,pageSize);
//
//        return Result.success(pageBean);
//    }
}
