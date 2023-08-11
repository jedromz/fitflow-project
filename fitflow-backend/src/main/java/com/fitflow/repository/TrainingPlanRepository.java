package com.fitflow.repository;

import com.fitflow.model.trainingplan.TrainingPlan;
import com.fitflow.model.projection.DefaultTrainingPlanProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Long> {

    List<DefaultTrainingPlanProjection> findAllBy();

    Optional<DefaultTrainingPlanProjection> findTrainingPlanById(Long id);

    @Query("SELECT tp FROM TrainingPlan tp WHERE tp.trainee.id = :traineeId ORDER BY tp.startDate DESC LIMIT 1")
    Optional<DefaultTrainingPlanProjection> findLatestByTraineeId(@Param("traineeId") Long traineeId);
}

