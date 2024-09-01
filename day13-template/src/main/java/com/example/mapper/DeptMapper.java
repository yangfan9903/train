package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询全部的部门信息
     * @return
     */
    @Select("select * from dept")
    public List<Dept> selectAll();

    /**
     * 根据id删除部门
     * @param id
     * @return
     */
    @Delete("delete from dept where id = #{id}")
    public void deleteById(Integer id);

    /**
     * 插入部门信息
     * @param dept
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO dept (name, create_time, update_time)"+
    "values (#{name},#{createTime},#{updateTime})")
    public void insert(Dept dept);

    /**
     * 根据id查询部门信息
     * @param id
     * @return
     */
    @Select("select * from dept where id = #{id}")
    Dept selectById(Integer id);

    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void updataById(Dept dept);
}
