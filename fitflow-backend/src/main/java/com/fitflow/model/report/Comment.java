package com.fitflow.model.report;

import com.fitflow.model.projection.CommentResponse;
import com.fitflow.model.trainee.Trainee;
import com.fitflow.model.trainer.Trainer;
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
public class Comment {
    public static final String ENTITY_NAME = "Comment";
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;
    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private Trainee trainee;
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    public CommentResponse toResponse() {
        return new CommentResponse() {

            public Long getId() {
                return Comment.this.getId();
            }

            public String getText() {
                return Comment.this.getText();
            }

            public LocalDate getDate() {
                return Comment.this.getDate();
            }
        };
    }
}
