package com.example.controller;

import com.example.pojo.Result;
import com.example.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @PostMapping
    public Result uploadImageFile(MultipartFile image) throws IOException {
        log.info("文件上传,文件名:{}",image.getOriginalFilename());
        String url = uploadService.uploadImageFile(image);
        return Result.success(url);
    }
}
