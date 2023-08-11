package com.fitflow.controller;

import com.fitflow.model.dto.AddNewTraineeToTrainerRequest;
import com.fitflow.model.projection.MentorshipResponse;
import com.fitflow.model.projection.ReportResponse;
import com.fitflow.model.projection.TraineeResponse;
import com.fitflow.model.projection.TrainerResponse;
import com.fitflow.model.trainer.Trainer;
import com.fitflow.service.TrainerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trainers")
public class TrainerController {
    private final TrainerService trainerService;

    @PostMapping
    @Operation(summary = "Create trainer")
    public ResponseEntity<TrainerResponse> createTrainer(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.saveTrainer(trainer));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get trainer by id")
    public ResponseEntity<TrainerResponse> getTrainerById(@PathVariable Long id) {
        return ResponseEntity.ok(trainerService.findTraineeById(id));
    }

    @PutMapping
    @Operation(summary = "Update trainer")
    public ResponseEntity<TrainerResponse> updateTrainer(@RequestBody Trainer trainer) {
        return ResponseEntity.ok(trainerService.updateTrainer(trainer));
    }

    @GetMapping
    @Operation(summary = "Get all trainers")
    public ResponseEntity<List<TrainerResponse>> getTrainers() {
        return ResponseEntity.ok(trainerService.findAllTrainers());
    }

    @GetMapping("/{id}/trainees")
    @Operation(summary = "Get trainer's trainees")
    public ResponseEntity<List<TraineeResponse>> getTrainerTrainees(@PathVariable Long id) {
        return ResponseEntity.ok(trainerService.findTrainerTrainees(id));
    }

    @PostMapping("/{id}/trainees")
    @Operation(summary = "Get trainer's trainees")
    public ResponseEntity<TraineeResponse> getTrainerTrainees(@PathVariable Long id, @RequestBody AddNewTraineeToTrainerRequest request) {
        return ResponseEntity.ok(trainerService.addNewTraineeToTrainer(id, request));
    }

    @GetMapping("/{id}/trainees/page")
    @Operation(summary = "Get trainer's trainees with pagination")
    public ResponseEntity<Page<TraineeResponse>> getTrainerTraineesWithPagination(@PathVariable Long id, Pageable pageable) {
        return ResponseEntity.ok(trainerService.findTrainerTrainees(id, pageable));
    }

    @GetMapping("/{id}/mentorships")
    @Operation(summary = "Get trainer's mentorships")
    public ResponseEntity<List<MentorshipResponse>> getTrainerMentorships(@PathVariable Long id) {
        return ResponseEntity.ok(trainerService.findTrainerMentorships(id));
    }

    @GetMapping("/{id}/reports")
    @Operation(summary = "Get trainer's reports")
    public ResponseEntity<List<ReportResponse>> getTrainerReports(@PathVariable Long id) {
        return ResponseEntity.ok(trainerService.findTrainerReports(id));
    }
}
