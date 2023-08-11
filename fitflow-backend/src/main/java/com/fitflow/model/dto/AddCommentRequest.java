package com.fitflow.model.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class AddCommentRequest {
    private LocalDate date;
    private String text;
}
