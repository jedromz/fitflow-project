package com.fitflow.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExerciseRequest {
    private String name;
    private String tips;
    private String description;
    private List<String> muscleGroups;
}
