package com.fitflow.controller;

import com.fitflow.model.trainingplan.TrainingPlan;
import com.fitflow.model.projection.DefaultTrainingPlanProjection;
import com.fitflow.model.dto.TrainingPlanDto;
import com.fitflow.service.TrainingPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/training-plans")
@Tag(name = "Training Plan Controller", description = "Controller for managing training plans")
public class TrainingPlanController {

    private final TrainingPlanService trainingPlanService;

    @GetMapping
    @Operation(summary = "Get all training plans")
    public ResponseEntity<List<TrainingPlanDto>> getAllTrainingPlans() {
        return ResponseEntity.ok(trainingPlanService.findAllTrainingPlans());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get training plan by id")
    public ResponseEntity<DefaultTrainingPlanProjection> getTrainingPlanById(@PathVariable Long id) {
        return ResponseEntity.ok(trainingPlanService.findTrainingPlanById(id));
    }

    @PostMapping
    @Operation(summary = "Create training plan")
    public ResponseEntity<DefaultTrainingPlanProjection> createTrainingPlan(TrainingPlan trainingPlan) {
        return ResponseEntity.ok(trainingPlanService.saveTrainingPlan(trainingPlan));
    }

    @PutMapping
    @Operation(summary = "Update training plan")
    public ResponseEntity<DefaultTrainingPlanProjection> updateTrainingPlan(TrainingPlan trainingPlan) {
        return ResponseEntity.ok(trainingPlanService.updateTrainingPlan(trainingPlan));
    }
}
