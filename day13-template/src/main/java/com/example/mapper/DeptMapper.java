package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询全部的部门信息
     * @return
     */
    @Select("select * from dept")
    public List<Dept> selectAll();

}
