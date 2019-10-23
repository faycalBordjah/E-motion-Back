package com.motus.emotion.service;

import com.motus.emotion.model.FileDB;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileDB store(MultipartFile multipartFile, Long vehicleId);
}
