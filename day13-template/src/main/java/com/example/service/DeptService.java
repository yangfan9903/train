package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> selectAll();

    public void deleteById(Integer id);

    void insert(Dept dept);

    Dept selectById(Integer id);

    void updataById(Dept dept);
}
