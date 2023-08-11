package com.fitflow.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AddBodyMeasurementRequest {
    Double circumference;
    LocalDate date;
    String bodyPart;
}
