package com.arijit.ai.controller;

import com.arijit.ai.model.PsnIoiDto;
import com.arijit.ai.service.PsnIoiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/psn-ioi")
@Slf4j
public class PsnIoiController {

    private final PsnIoiService psnIoiService;

    @Autowired
    public PsnIoiController(PsnIoiService psnIoiService) {
        this.psnIoiService = psnIoiService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPsnIoi(@RequestBody PsnIoiDto psnIoiDto) {
        log.info("Creating PSN and IOI details"+psnIoiDto);
        boolean isValid = psnIoiService.validatePsnIoiDetails(psnIoiDto);
        if (!isValid) {
            return ResponseEntity.badRequest().body("Validation failed for PSN and IOI details");
        }
        psnIoiService.createPsnIoi(psnIoiDto);
        return ResponseEntity.ok("PSN and IOI details have been successfully created");
    }
}
