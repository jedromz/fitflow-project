package com.fitflow.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddNewTraineeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private int weightInGrams;
    private int heightInCentimeters;
}
