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
public class AddNewTraineeToTrainerRequest {
    private String firstName;
    private String lastName;
    private String email;
    private int weightInGrams;
    private int heightInCentimeters;
    private Long trainerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer price;
}
