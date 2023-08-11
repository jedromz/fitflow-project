package com.fitflow.controller;

import com.fitflow.model.dto.ExerciseRequest;
import com.fitflow.model.projection.ExerciseResponse;
import com.fitflow.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping
    public List<ExerciseResponse> findAllExercises() {
        return exerciseService.findAllExercises();
    }

    @PostMapping
    public void addExercise(@RequestBody ExerciseRequest exerciseRequest) {
        exerciseService.addExercise(exerciseRequest);
    }
    @GetMapping("/page")
    public Page<ExerciseResponse> findAllExercises(Pageable pageable) {
        return exerciseService.findAllExercises(pageable);
    }
}
