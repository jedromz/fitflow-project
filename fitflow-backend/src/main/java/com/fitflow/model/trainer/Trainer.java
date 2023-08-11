package com.fitflow.model.trainer;

import com.fitflow.model.report.Comment;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public
class Trainer {
    public static final String ENTITY_NAME = "Trainer";
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "trainer")
    private Set<Certificate> certificates = new HashSet<>();
    @OneToMany(mappedBy = "trainer")
    private Set<Mentorship> mentorships = new HashSet<>();
    @OneToMany
    private Set<Comment> comments = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return Objects.equals(firstName, trainer.firstName) && Objects.equals(lastName, trainer.lastName) && Objects.equals(email, trainer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }
}
