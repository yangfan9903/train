package com.example.service.impl;

import com.example.mapper.DeptLogMapper;
import com.example.pojo.DeptLog;
import com.example.service.DeptLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class DeptLogServiceImpl implements DeptLogService {
    @Autowired
    DeptLogMapper deptLogMapper;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}
