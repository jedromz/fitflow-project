package com.fitflow.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddReportRequest {
    private LocalDate date;
    private String description;
}
