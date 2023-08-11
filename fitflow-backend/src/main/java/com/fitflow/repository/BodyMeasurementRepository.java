package com.fitflow.repository;

import com.fitflow.model.trainee.BodyPartMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyMeasurementRepository extends JpaRepository<BodyPartMeasurement, Long> {
}

