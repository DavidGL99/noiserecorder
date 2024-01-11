package com.hiberus.noiserecorder.service;

import com.hiberus.noiserecorder.dto.NoiseRecordDto;
import com.hiberus.noiserecorder.entity.NoiseRecord;
import com.hiberus.noiserecorder.repository.NoiseRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
public class NoiseRecordService {

    @Autowired
    private NoiseRecordRepository noiseRecordRepository;

    public boolean saveRecord(NoiseRecordDto dto) {
        try {
            NoiseRecord record = noiseRecordRepository.save(NoiseRecord.builder()
                    .maxDb(dto.getMaxDb())
                    .minDb(dto.getMinDb())
                    .avergageDb(dto.getAverageDb())
                    .date(formatDate(dto.getDate()))
                    .office(dto.getOffice())
                    .build());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<NoiseRecordDto> getAllRecords() {
        return noiseRecordRepository.findAll().stream().map(e -> NoiseRecordDto.builder()
                .maxDb(e.getMaxDb())
                .minDb(e.getMinDb())
                .averageDb(e.getAvergageDb())
                .date(parseDate(e.getDate()))
                .office(e.getOffice())
                .build()).collect(Collectors.toList());
    }

    private String parseDate(Date date) {
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return f.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private Date formatDate(String date) {
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date fdate = f.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fdate);
            // Suma una hora para convertir a UTC+1
            calendar.add(Calendar.HOUR_OF_DAY, -2);
            // Obtiene la nueva fecha y hora
            return calendar.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
