package com.fitflow.model.trainingplan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Exercise {
    public static final String ENTITY_NAME = "Exercise";
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String tips;
    private String description;
    @OneToMany(mappedBy = "exercise")
    private List<ExerciseTrainingUnit> exerciseTrainingUnits = new ArrayList<>();
    @ManyToMany
    private List<MuscleGroup> muscleGroups = new ArrayList<>();
}
