package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UploadMapper {
    @Update("update emp set image=#{image} where id =#{id}")
    public void uploadImageFile(String image);
}
