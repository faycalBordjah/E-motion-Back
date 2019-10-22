package com.motus.emotion.service.impl;

import com.motus.emotion.exception.NotFoundException;
import com.motus.emotion.model.FileDB;
import com.motus.emotion.repository.FileDBRepository;
import com.motus.emotion.repository.VehicleRepository;
import com.motus.emotion.service.FileService;
import com.motus.emotion.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service("fileService")
public class FileServiceImpl implements FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);
    private FileDBRepository fileDBRepository;
    private VehicleRepository vehicleRepository;

    @Autowired
    public FileServiceImpl(FileDBRepository fileDBRepository, VehicleRepository vehicleRepository) {
        this.fileDBRepository = fileDBRepository;
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public FileDB store(MultipartFile file, Long vehicleId) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            FileDB fileDB = new FileDB(fileName,
                    file.getContentType(),
                    file.getBytes(),
                    vehicleRepository.getOne(vehicleId));
            return fileDBRepository.save(fileDB);
        } catch (IOException exp) {
            throw new NotFoundException("REPLACE BY EXACT EXCEPTION");
        }
    }
}
