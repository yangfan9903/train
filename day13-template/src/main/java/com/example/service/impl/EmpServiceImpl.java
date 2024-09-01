package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    public PageBean selectByCondition(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {

        // 设置分页插件
        PageHelper.startPage(page,pageSize);
        // 执行查询操作
        List<Emp> empList = empMapper.selectByCondition(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }
//public PageBean selectByCondition(String name,Integer page, Integer pageSize) {
//
//    // 设置分页插件
//    PageHelper.startPage(page,pageSize);
//    // 执行查询操作
//    List<Emp> empList = empMapper.selectByCondition(name);
//    Page<Emp> p = (Page<Emp>) empList;
//    PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
//    return pageBean;
//}

//    @Override
//    public Long count() {
//        return empMapper.count();
//    }

//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        // 获取总记录数
//        Long count = empMapper.count();
//        // 获取分页查询列表
//        Integer start = (page-1)*pageSize;
//        List<Emp> empList = empMapper.page(start,pageSize);
//        // 封装成PageBean对象
//        PageBean pageBean = new PageBean(count,empList);
//        return pageBean;
//    }
//    @Override
    public PageBean page(Integer page, Integer pageSize) {
        // 设置分页参数
        PageHelper.startPage(page,pageSize);
        // 执行查询操作
        List<Emp> empList = empMapper.selectAll();
        Page<Emp> p = (Page<Emp>) empList;
        // 封装成PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
    }

    @Override
    public void insert(Emp emp) {
        if (Objects.isNull(emp.getCreateTime())){
            emp.setCreateTime(LocalDateTime.now());
        }
        if (Objects.isNull(emp.getUpdateTime())){
            emp.setUpdateTime(LocalDateTime.now());
        }

        empMapper.insert(emp);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp selectById(Integer id) {
        return empMapper.selectById(id);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }


}
