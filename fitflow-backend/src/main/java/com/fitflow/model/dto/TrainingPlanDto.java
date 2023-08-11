package com.fitflow.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TrainingPlanDto extends RepresentationModel<TrainingPlanDto> {

    private Long trainingPlanId;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
