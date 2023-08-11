package com.fitflow.model.trainee;

import com.fitflow.model.projection.ProgressionResponse;
import com.fitflow.model.trainingplan.ExerciseTrainingUnit;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Progression {
    @Id
    @GeneratedValue
    private Long id;
    private Double weight;
    private Integer numberOfRepetitions;
    private Integer numberOfSets;
    @ManyToOne
    @JoinColumn(name = "exercise_training_unit_id")
    private ExerciseTrainingUnit exerciseTrainingUnit;

    public ProgressionResponse toResponse() {
        return new ProgressionResponse() {

            public Long getId() {
                return id;
            }

            public Double getWeight() {
                return weight;
            }

            public Integer getNumberOfRepetitions() {
                return numberOfRepetitions;
            }

            public Integer getNumberOfSets() {
                return numberOfSets;
            }
        };
    }
}
