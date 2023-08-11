package com.fitflow.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddMentorshipRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer price;
    private Long traineeId;
    private Long trainerId;
}
