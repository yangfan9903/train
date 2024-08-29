package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Delete("delete from emp where id = #{id}")
    public void deleteEmpById(Integer id);

    public void deleteEmpByIds(List<Integer> ids);
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image},job=#{job}" +
            ",entrydate = #{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id = #{id}")
    public void update(Emp emp);

//    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image},job=#{job}" +
//            ",entrydate = #{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id = #{id}")
    public void update2(Emp emp);

//    @Select("select * from emp where id = #{id}")
//    public Emp selectById(Integer id);
//@Select("select id, username, password, name, gender, image, job, entrydate" +
//        ", dept_id deptId, create_time createTime, update_time updateTime from emp where id = #{id}")
//public Emp selectById(Integer id);

//    @Results({
//            @Result(column = "dept_id", property = "deptId"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
    @Select("select * from emp where id = #{id}")
    public Emp selectById(Integer id);

//    @Select("select * from emp where name like concat('%',#{name},'%') and gender = #{gender}" +
//            " and entrydate between #{startTime} and #{endTime} order by update_time desc")
    public List<Emp> selectCondition(@Param("name") String name, @Param("gender") Integer gender,@Param("startTime") LocalDate startTime,@Param("endTime") LocalDate endTime);
}
