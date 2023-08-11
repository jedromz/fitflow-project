package com.fitflow.model.trainingplan;

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
public
class TrainingUnit {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String tips;

    @ManyToOne
    @JoinColumn(name = "training_plan_id")
    private TrainingPlan trainingPlan;
    @OneToMany(mappedBy = "trainingUnit")
    private List<ExerciseTrainingUnit> exerciseTrainingUnits = new ArrayList<>();

    public void addExerciseTrainingUnit(ExerciseTrainingUnit exerciseTrainingUnit) {
        exerciseTrainingUnits.add(exerciseTrainingUnit);
    }
}
