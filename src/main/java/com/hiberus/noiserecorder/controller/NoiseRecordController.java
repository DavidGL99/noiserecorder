package com.hiberus.noiserecorder.controller;

import com.hiberus.noiserecorder.dto.NoiseRecordDto;
import com.hiberus.noiserecorder.entity.NoiseRecord;
import com.hiberus.noiserecorder.service.NoiseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class NoiseRecordController {

    @Autowired
    NoiseRecordService noiseRecordService;

    @PostMapping("/noise-record")
    private ResponseEntity<NoiseRecord> postNoiseRecord(@RequestBody NoiseRecordDto dto) {


        return noiseRecordService.saveRecord(dto) ? new ResponseEntity<>(HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/noise-record")
    private ResponseEntity<List<NoiseRecordDto>> getAllRecords() {
        List<NoiseRecordDto> records = noiseRecordService.getAllRecords();

        return records == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>(records, HttpStatus.OK);
    }

}
