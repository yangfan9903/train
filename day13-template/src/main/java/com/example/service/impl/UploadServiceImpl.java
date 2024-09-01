package com.example.service.impl;

import com.example.mapper.UploadMapper;
import com.example.service.UploadService;
import com.example.utils.AliOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private UploadMapper uploadMapper;
    @Autowired
    private AliOSSUtils aliOSSUtils;
    @Override
    public String uploadImageFile(MultipartFile image) throws IOException {
        String url = aliOSSUtils.upload(image);
//        uploadMapper.uploadImageFile(url);
        return url;
    }
}
