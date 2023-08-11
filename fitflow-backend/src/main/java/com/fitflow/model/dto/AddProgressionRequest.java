package com.fitflow.model.dto;

import lombok.Data;

@Data
public class AddProgressionRequest {
    private String name;
    private Double weight;
    private Integer numberOfRepetitions;
    private Integer numberOfSets;

}
