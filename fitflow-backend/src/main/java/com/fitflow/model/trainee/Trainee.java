package com.fitflow.model.trainee;

import com.fitflow.model.report.Comment;
import com.fitflow.model.report.Report;
import com.fitflow.model.trainer.Mentorship;
import com.fitflow.model.trainingplan.TrainingPlan;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public
class Trainee {
    public final static String ENTITY_NAME = "Trainee";
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int weightInGrams;
    private int heightInCentimeters;
    private boolean isDeleted;
    @OneToMany(mappedBy = "trainee")
    private Set<TrainingPlan> trainingPlans = new HashSet<>();
    @OneToMany(mappedBy = "trainee")
    private Set<Mentorship> mentorships = new HashSet<>();
    @OneToMany(mappedBy = "trainee")
    private Set<BodyPartMeasurement> bodyPartMeasurements = new HashSet<>();
    @OneToMany(mappedBy = "trainee")
    private Set<Report> reports = new HashSet<>();
    @OneToMany(mappedBy = "trainee")
    private Set<Comment> comments = new HashSet<>();

    public void addBodyMeasurement(BodyPartMeasurement bodyPartMeasurement) {
        bodyPartMeasurements.add(bodyPartMeasurement);
    }
}
