package com.fitflow.model.trainingplan;

import com.fitflow.model.projection.DefaultTrainingPlanProjection;
import com.fitflow.model.trainee.Trainee;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public
class TrainingPlan {

    public static final String ENTITY_NAME = "TrainingPlan";
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    private Trainee trainee;
    @OneToMany(mappedBy = "trainingPlan")
    private List<TrainingUnit> trainingUnit = new ArrayList<>();

    public Long getTraineeId() {
        return trainee.getId();
    }

    public DefaultTrainingPlanProjection toResponse() {
        return new DefaultTrainingPlanProjection() {
            @Override
            public Long getId() {
                return TrainingPlan.this.getId();
            }

            @Override
            public String getName() {
                return TrainingPlan.this.getName();
            }

            @Override
            public String getDescription() {
                return TrainingPlan.this.getDescription();
            }

            @Override
            public LocalDate getStartDate() {
                return TrainingPlan.this.getStartDate();
            }

            @Override
            public LocalDate getEndDate() {
                return TrainingPlan.this.getEndDate();
            }
        };
    }

    public void addTrainingUnit(TrainingUnit trainingUnit) {
        this.trainingUnit.add(trainingUnit);
    }
}
