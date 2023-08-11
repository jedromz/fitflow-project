package com.fitflow.model.trainingplan;

import com.fitflow.model.trainee.Progression;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExerciseTrainingUnit {
    public static final String ENTITY_NAME = "ExerciseTrainingUnit";
    @Id
    @GeneratedValue
    private Long id;
    private Integer numberOfSets;
    private Integer numberOfRepetitions;
    @ManyToOne
    @JoinColumn(name = "training_unit_id")
    private TrainingUnit trainingUnit;
    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    @OneToMany(mappedBy = "exerciseTrainingUnit")
    private List<Progression> progressions = new ArrayList<>();
}
