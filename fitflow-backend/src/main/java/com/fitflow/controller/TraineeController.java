package com.fitflow.controller;

import com.fitflow.model.dto.AddBodyMeasurementRequest;
import com.fitflow.model.dto.AddNewTraineeRequest;
import com.fitflow.model.dto.AddReportRequest;
import com.fitflow.model.dto.StartMentorshipRequest;
import com.fitflow.model.dto.TraineeDto;
import com.fitflow.model.dto.TrainingPlanDto;
import com.fitflow.model.dto.TrainingPlanRequest;
import com.fitflow.model.dto.UpdateTraineeRequest;
import com.fitflow.model.projection.DefaultTrainingPlanProjection;
import com.fitflow.model.projection.MentorshipResponse;
import com.fitflow.model.projection.ReportResponse;
import com.fitflow.model.projection.TraineeResponse;
import com.fitflow.model.report.Report;
import com.fitflow.service.TraineeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/trainees")
public class TraineeController {

    private final TraineeService traineeService;
    private final ModelMapper modelMapper;

    @PostMapping("/{id}/bodyMeasurements")
    @Operation(summary = "Add body measurement to trainee")
    public ResponseEntity<Void> addBodyMeasurement(@PathVariable Long id, @RequestBody AddBodyMeasurementRequest addBodyMeasurementRequest) {
        traineeService.addBodyMeasurements(id, addBodyMeasurementRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    @Operation(summary = "Create trainee")
    public ResponseEntity<TraineeResponse> createTrainee(@RequestBody AddNewTraineeRequest trainee) {
        return ResponseEntity.ok(traineeService.saveTrainee(trainee));
    }

    @PostMapping("/{traineeId}/trainingPlans")
    @Operation(summary = "Create training plan for trainee")
    public ResponseEntity<DefaultTrainingPlanProjection> addTrainingPlan(@RequestBody TrainingPlanRequest trainingPlan, @PathVariable Long traineeId) {
        return ResponseEntity.ok(traineeService.addTrainingPlan(trainingPlan, traineeId));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get trainee by id")
    public ResponseEntity<TraineeDto> getTraineeById(@PathVariable Long id) {
        var traineeResponse = traineeService.findById(id);
        var dto = modelMapper.map(traineeResponse, TraineeDto.class);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    @Operation(summary = "Get all trainees")
    public ResponseEntity<List<TraineeResponse>> getTrainees() {
        return ResponseEntity.ok(traineeService.findAllTrainees());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update trainee")
    public ResponseEntity<TraineeResponse> updateTrainee(@RequestBody UpdateTraineeRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(traineeService.updateTrainee(request, id));
    }

    @PostMapping("/{traineeId}/mentorships")
    @Operation(summary = "Start mentorship")
    public ResponseEntity<MentorshipResponse> startMentorship(@PathVariable Long traineeId, @RequestBody StartMentorshipRequest startMentorshipRequest) {
        return ResponseEntity.ok(traineeService.startMentorship(traineeId, startMentorshipRequest));
    }

    @PostMapping("/{traineeId}/reports")
    @Operation(summary = "Add report to trainee")
    public ResponseEntity<Report> addReport(@PathVariable Long traineeId, @RequestBody AddReportRequest request) {
        return ResponseEntity.ok(traineeService.addReport(traineeId, request));
    }

    @GetMapping("/{traineeId}/reports")
    @Operation(summary = "Get reports for trainee")
    public ResponseEntity<List<ReportResponse>> getReports(@PathVariable Long traineeId) {
        return ResponseEntity.ok(traineeService.getReports(traineeId));
    }

    @GetMapping("/{traineeId}/training-plans")
    @Operation(summary = "Get training plans for trainee")
    public ResponseEntity<List<DefaultTrainingPlanProjection>> getTrainingPlans(@PathVariable Long traineeId) {
        return ResponseEntity.ok(traineeService.getTrainingPlans(traineeId));
    }

    @GetMapping("/{traineeId}/training-plan")
    @Operation(summary = "Get trainees current training plan")
    public ResponseEntity<TrainingPlanDto> getCurrentTrainingPlan(@PathVariable Long traineeId) {
        return ResponseEntity.ok(traineeService.getCurrentTrainingPlan(traineeId));
    }

    @GetMapping("/{traineeId}/report")
    @Operation(summary = "Get trainees current report")
    public ResponseEntity<ReportResponse> getCurrentReport(@PathVariable Long traineeId) {
        return ResponseEntity.ok(traineeService.getCurrentReport(traineeId));
    }

    @GetMapping("/{traineeId}/mentorship")
    @Operation(summary = "Get trainees current mentorship")
    public ResponseEntity<MentorshipResponse> getCurrentMentorship(@PathVariable Long traineeId) {
        return ResponseEntity.ok(traineeService.getCurrentMentorship(traineeId));
    }

    @DeleteMapping("/{traineeId}/")
    @Operation(summary = "Delete trainee")
    public ResponseEntity<Void> deleteTrainee(@PathVariable Long traineeId) {
        traineeService.deleteTrainee(traineeId);
        return ResponseEntity.ok().build();
    }
}
