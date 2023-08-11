package com.fitflow.model.projection;

import java.time.LocalDate;

public interface MentorshipResponse {
    Long getId();

    LocalDate getStartDate();

    LocalDate getEndDate();

    Integer getPrice();
}

