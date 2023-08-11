package com.fitflow.repository;


import com.fitflow.model.trainingplan.BodyPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BodyPartRepository extends JpaRepository<BodyPart, Long> {
    Optional<BodyPart> findByName(String bodyPart);
}

