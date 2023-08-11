package com.fitflow.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StartMentorshipRequest {
    private Long trainerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer price;

}
