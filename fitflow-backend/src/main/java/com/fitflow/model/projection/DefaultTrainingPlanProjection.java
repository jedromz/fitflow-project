package com.fitflow.model.projection;

import java.time.LocalDate;

public interface DefaultTrainingPlanProjection {
    Long getId();

    String getName();

    String getDescription();

    LocalDate getStartDate();

    LocalDate getEndDate();
}
