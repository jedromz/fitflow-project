package com.fitflow.service;

import com.fitflow.model.trainingplan.Exercise;
import com.fitflow.model.trainingplan.MuscleGroup;
import com.fitflow.model.dto.ExerciseRequest;
import com.fitflow.model.projection.ExerciseResponse;
import com.fitflow.repository.ExerciseRepository;
import com.fitflow.repository.MuscleGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final MuscleGroupRepository muscleGroupRepository;

    public List<ExerciseResponse> findAllExercises() {
        return exerciseRepository.findAllBy();
    }

    @Transactional
    public void addExercise(ExerciseRequest exerciseRequest) {
        var exercise = new Exercise();
        exerciseRequest.getMuscleGroups()
                .forEach(muscleGroupName -> {
                    Optional<MuscleGroup> muscleGroupOpt = muscleGroupRepository.findByName(muscleGroupName);
                    if (muscleGroupOpt.isPresent()) {
                        exercise.getMuscleGroups().add(muscleGroupOpt.get());
                    } else {
                        MuscleGroup newMuscleGroup = new MuscleGroup();
                        newMuscleGroup.setName(muscleGroupName);
                        muscleGroupRepository.save(newMuscleGroup);
                        exercise.getMuscleGroups().add(newMuscleGroup);
                    }
                });
        exercise.setName(exerciseRequest.getName());
        exercise.setDescription(exerciseRequest.getDescription());
        exercise.setTips(exerciseRequest.getTips());
        exerciseRepository.save(exercise);
    }

    public Page<ExerciseResponse> findAllExercises(Pageable pageable) {
        return exerciseRepository.findAllBy(pageable);
    }
}
