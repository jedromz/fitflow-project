package com.fitflow.model.trainee;

import com.fitflow.model.trainingplan.BodyPart;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class BodyPartMeasurement {
    @Id
    @GeneratedValue
    private Long id;
    private Double circumference;
    private LocalDate date;
    @OneToOne
    private BodyPart bodyPart;
    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private Trainee trainee;
}
