package com.fitflow.model.projection;

import java.time.LocalDate;

public interface ReportResponse {
    Long getId();

    LocalDate getDate();

    String getDescription();

    String getText();
}
