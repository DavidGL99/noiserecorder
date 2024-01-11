package com.hiberus.noiserecorder.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class NoiseRecordDto {
    private Double maxDb;
    private Double minDb;
    private Double averageDb;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Paris")
    private String date;
    private String office;
}
