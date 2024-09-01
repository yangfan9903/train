package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageBean selectByCondition(String name, Integer gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);
//    PageBean selectByCondition(String name, Integer page, Integer pageSize);

//    Long count();

    PageBean page(Integer page, Integer pageSize);

    void deleteByIds(List<Integer> ids);

    void insert(Emp emp);

    void update(Emp emp);

    Emp selectById(Integer id);

    Emp login(Emp emp);
}
