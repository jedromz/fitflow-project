package com.fitflow.model.trainer;

import com.fitflow.model.projection.MentorshipResponse;
import com.fitflow.model.trainee.Trainee;
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
public
class Mentorship {
    public static final String ENTITY_NAME = "Mentorship";
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private Trainee trainee;
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    public Mentorship(LocalDate startDate, LocalDate endDate, Integer price, Trainee trainee, Trainer trainer) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.trainee = trainee;
        this.trainer = trainer;
    }

    public MentorshipResponse toResponse() {
        return new MentorshipResponse() {

            @Override
            public Long getId() {
                return Mentorship.this.getId();
            }

            @Override
            public LocalDate getStartDate() {
                return Mentorship.this.getStartDate();
            }

            @Override
            public LocalDate getEndDate() {
                return Mentorship.this.getEndDate();
            }

            @Override
            public Integer getPrice() {
                return Mentorship.this.getPrice();
            }
        };
    }
}
