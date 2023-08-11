package com.fitflow.model.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntityNotFoundException extends RuntimeException {
    private String entityName;
    private String key;
    private String value;

    EntityNotFoundException(String message, String entityName, String key, String value) {
        super(message);
        this.entityName = entityName;
        this.key = key;
        this.value = value;
    }
}
