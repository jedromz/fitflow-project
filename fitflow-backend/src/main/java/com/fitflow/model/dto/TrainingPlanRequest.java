package com.fitflow.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class TrainingPlanRequest {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<TrainingUnitRequest> trainingUnits;

    @Data
    @NoArgsConstructor
    public static class TrainingUnitRequest {
        private String name;
        private String tips;
        private List<ExerciseTrainingUnitRequest> exerciseTrainingUnits;
    }

    @Data
    @NoArgsConstructor
    public static class ExerciseTrainingUnitRequest {
        private Integer numberOfSets;
        private Integer numberOfRepetitions;
        private Exercise exercise;
    }

    @Data
    @NoArgsConstructor
    public static class Exercise {
        private String name;
    }

}


