package com.fitflow.repository;

import com.fitflow.model.trainer.Trainer;
import com.fitflow.model.projection.TrainerResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    List<TrainerResponse> findAllBy();

    Optional<TrainerResponse> findTrainerById(Long id);

}
