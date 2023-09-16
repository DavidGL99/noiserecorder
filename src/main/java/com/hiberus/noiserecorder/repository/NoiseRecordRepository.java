package com.hiberus.noiserecorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hiberus.noiserecorder.entity.NoiseRecord;
@Repository
public interface NoiseRecordRepository extends JpaRepository<NoiseRecord, Long> {
}
