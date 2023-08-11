package com.fitflow.repository;

import com.fitflow.model.trainingplan.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {

    Optional<MuscleGroup> findByName(String muscleGroupName);
}
