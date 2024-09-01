package com.example.service.impl;

import com.example.mapper.DeptMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.Dept;
import com.example.pojo.DeptLog;
import com.example.service.DeptLogService;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    public List<Dept> selectAll() {
        List<Dept> deptList= deptMapper.selectAll();
        return deptList;
    }

    @Transactional
    public void deleteById(Integer id) {
        // 删除对应的部门ID
        deptMapper.deleteById(id);
        // 部门解散后对应的员工也解散了
        empMapper.deleteByDeptId(id);
        DeptLog deptLog = new DeptLog();
        deptLog.setCreateTime(LocalDateTime.now());
        deptLog.setDescription("执行了解散部门操作,此次解散的部门id为"+id);
        deptLogService.insert(deptLog);

    }


    public void insert(Dept dept) {
        deptMapper.insert(dept);
    }

    @Override
    public Dept selectById(Integer id) {



        return deptMapper.selectById(id);
    }

    @Override
    public void updataById(Dept dept) {
        deptMapper.updataById(dept);
    }
}
