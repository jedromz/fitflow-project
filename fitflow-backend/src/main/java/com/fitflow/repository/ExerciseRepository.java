package com.fitflow.repository;

import com.fitflow.model.projection.ExerciseResponse;
import com.fitflow.model.trainingplan.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Optional<Exercise> findByName(String name);

    List<ExerciseResponse> findAllBy();

    Page<ExerciseResponse> findAllBy(Pageable pageable);

}
