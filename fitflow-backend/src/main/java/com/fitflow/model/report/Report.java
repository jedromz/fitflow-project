package com.fitflow.model.report;

import com.fitflow.model.projection.ReportResponse;
import com.fitflow.model.trainee.Trainee;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Report {

    public static final String ENTITY_NAME = "Report";
    @Id
    private Long id;
    private LocalDate date;
    private String description;
    private String text;
    @ManyToOne
    private Trainee trainee;
    @OneToMany(mappedBy = "report")
    private List<Comment> comments;

    public ReportResponse toResponse() {
        return new ReportResponse() {
            @Override
            public Long getId() {
                return Report.this.getId();
            }

            @Override
            public LocalDate getDate() {
                return Report.this.getDate();
            }

            @Override
            public String getDescription() {
                return Report.this.getDescription();
            }

            @Override
            public String getText() {
                return Report.this.getText();
            }
        };
    }
}
