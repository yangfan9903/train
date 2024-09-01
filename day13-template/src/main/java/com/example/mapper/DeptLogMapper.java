package com.example.mapper;

import com.example.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface DeptLogMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO dept_log(create_time, description) values (#{createTime},#{description})")
    void insert(DeptLog deptLog);
}
