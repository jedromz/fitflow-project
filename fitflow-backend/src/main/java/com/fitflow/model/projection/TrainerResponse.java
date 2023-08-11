package com.fitflow.model.projection;

import lombok.Builder;

public interface TrainerResponse {
    Long getId();

    String getFirstName();

    String getLastName();

    String getEmail();
}

