package com.hiberus.noiserecorder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
public class NoiseRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="maxdb")
    private Double maxDb;
    @Column(name ="mindb")
    private Double minDb;
    @Column(name ="avergagedb")
    private Double avergageDb;
    @Column(name ="date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;
    @Column(name ="office")
    private String office;

    public NoiseRecord () {}
}
