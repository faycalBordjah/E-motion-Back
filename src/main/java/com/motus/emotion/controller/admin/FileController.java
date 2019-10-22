package com.motus.emotion.controller.admin;

import com.motus.emotion.dto.FileDto;
import com.motus.emotion.model.FileDB;
import com.motus.emotion.model.api.ApiResponse;
import com.motus.emotion.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/emotion/api/admin/upload")
@Api("Api to upload a file, for now only admin can upload when he create a vehicle")
public class FileController {

    public static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    private FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/{vehicleId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "join an image to a vehicle")
    public ApiResponse<FileDto> upload(@PathVariable @ApiParam("The vehicle id ") Long vehicleId,
                                       @RequestParam("file") @RequestBody MultipartFile file) {
        FileDB fileDB = fileService.store(file, vehicleId);
        FileDto fileResponse = new FileDto(fileDB.getFileName(), file.getContentType(), file.getSize());
        return new ApiResponse<>(HttpStatus.OK.value(), "file uploaded", fileResponse);
    }

}
