package com.fitflow.model.trainer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
 public class Certificate {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private LocalDate issueDate;
    private LocalDate expirationDate;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

}
