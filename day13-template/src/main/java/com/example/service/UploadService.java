package com.example.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {

    String uploadImageFile(MultipartFile image) throws IOException;
}
