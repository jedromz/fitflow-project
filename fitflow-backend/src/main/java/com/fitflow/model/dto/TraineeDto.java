package com.fitflow.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TraineeDto extends RepresentationModel<TraineeDto> {
    private Long traineeId;
    private String firstName;
    private String lastName;
    private String email;
    private int weightInGrams;
    private int heightInCentimeters;
}
