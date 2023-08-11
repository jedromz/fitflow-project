package com.fitflow.controller;

import com.fitflow.model.dto.AddProgressionRequest;
import com.fitflow.model.projection.ProgressionResponse;
import com.fitflow.service.ExerciseTrainingUnitService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise-training-units")
@RequiredArgsConstructor
public class ExerciseTrainingUnitController {

    private final ExerciseTrainingUnitService exerciseTrainingUnitService;

    @PostMapping("/{id}/progressions")
    @Operation(summary = "Add a progression to an exercise training unit")
    public ResponseEntity<ProgressionResponse> addProgressionToExerciseTrainingUnit(@PathVariable Long id, @RequestBody AddProgressionRequest addProgressionRequest) {
        return ResponseEntity.ok(exerciseTrainingUnitService.addProgressionToExerciseTrainingUnit(id, addProgressionRequest));
    }
}
