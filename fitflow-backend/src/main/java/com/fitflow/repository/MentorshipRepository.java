package com.fitflow.repository;


import com.fitflow.model.trainer.Mentorship;
import com.fitflow.model.projection.MentorshipResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MentorshipRepository extends JpaRepository<Mentorship, Long> {
    List<MentorshipResponse> findAllBy();

    Optional<MentorshipResponse> findMentorshipById(Long id);

    List<MentorshipResponse> findByTrainer_Id(Long id);

    Optional<MentorshipResponse> findFirstByTrainee_IdOrderByStartDateDesc(Long id);
}
