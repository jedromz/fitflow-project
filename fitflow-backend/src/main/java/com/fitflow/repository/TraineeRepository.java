package com.fitflow.repository;

import com.fitflow.model.projection.TraineeResponse;
import com.fitflow.model.trainee.Trainee;
import com.fitflow.model.trainer.Trainer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {

    List<TraineeResponse> findAllBy();

    Optional<TraineeResponse> findTraineeById(Long id);

    List<TraineeResponse> findByMentorships_Trainer(Trainer trainer);

    List<TraineeResponse> findByMentorships_Trainer_Id(Long id);

    Page<TraineeResponse> findByMentorships_Trainer_Id(Long id, Pageable pageable);

}

