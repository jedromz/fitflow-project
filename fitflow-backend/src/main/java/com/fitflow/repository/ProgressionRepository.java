package com.fitflow.repository;

import com.fitflow.model.trainee.Progression;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressionRepository extends JpaRepository<Progression, Long> {

}

