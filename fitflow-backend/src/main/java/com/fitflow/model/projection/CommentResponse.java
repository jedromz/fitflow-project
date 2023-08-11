package com.fitflow.model.projection;

import java.time.LocalDate;


public interface CommentResponse {
    Long getId();

    String getText();

    LocalDate getDate();
}
