package com.fitflow.service;

import com.fitflow.model.trainingplan.TrainingPlan;
import com.fitflow.model.projection.DefaultTrainingPlanProjection;
import com.fitflow.model.dto.TrainingPlanDto;
import com.fitflow.model.exceptions.EntityNotFoundException;
import com.fitflow.repository.TrainingPlanRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingPlanService {
    private final TrainingPlanRepository trainingPlanRepository;
    private final ModelMapper modelMapper;

    public List<TrainingPlanDto> findAllTrainingPlans() {
        return trainingPlanRepository.findAllBy().stream()
                .map(trainingPlan -> modelMapper.map(trainingPlan, TrainingPlanDto.class))
                .toList();
    }

    public DefaultTrainingPlanProjection saveTrainingPlan(TrainingPlan trainingPlan) {
        return mapToTrainingPlanResponse(trainingPlanRepository.save(trainingPlan));
    }

    public DefaultTrainingPlanProjection updateTrainingPlan(TrainingPlan trainingPlan) {
        return mapToTrainingPlanResponse(trainingPlanRepository.save(trainingPlan));
    }

    public DefaultTrainingPlanProjection findTrainingPlanById(Long id) {
        return trainingPlanRepository.findTrainingPlanById(id)
                .orElseThrow(() -> new EntityNotFoundException(TrainingPlan.ENTITY_NAME, "id", id.toString()));
    }

    private DefaultTrainingPlanProjection mapToTrainingPlanResponse(TrainingPlan savedTrainingPlan) {
        return new DefaultTrainingPlanProjection() {

            public Long getId() {
                return savedTrainingPlan.getId();
            }

            public String getName() {
                return savedTrainingPlan.getName();
            }

            public String getDescription() {
                return savedTrainingPlan.getDescription();
            }

            public LocalDate getStartDate() {
                return savedTrainingPlan.getStartDate();
            }

            public LocalDate getEndDate() {
                return savedTrainingPlan.getEndDate();
            }
        };
    }
}
