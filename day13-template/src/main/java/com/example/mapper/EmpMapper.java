package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 条件查询
     * 功能：分页
     * @param name 模糊匹配
     * @param gender 全匹配
     * @param begin 大于等于
     * @param end 小于等于
     * @return
     */
    List<Emp> selectByCondition(@Param("name") String name, @Param("gender") Integer gender,
                                @Param("begin") LocalDate begin, @Param("end") LocalDate end);
//    List<Emp> selectByCondition(@Param("name") String name);

//    @Select("SELECT count(*) from emp")
//    Long count();

//    @Select("SELECT id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp ")
//    List<Emp> selectAll(@Param("page") Integer page,@Param("pageSize") Integer pageSize);

    @Select("SELECT id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp order by update_time desc")
    List<Emp> selectAll();


    void deleteByIds(List<Integer> ids);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);


    void update(Emp emp);

    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp" +
            " where id = #{id}")
    Emp selectById(Integer id);

    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where username=#{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    @Delete("delete from emp where dept_id=#{id}")
    void deleteByDeptId(Integer id);
}
