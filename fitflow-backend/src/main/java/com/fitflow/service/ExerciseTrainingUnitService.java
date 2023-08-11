package com.fitflow.service;

import com.fitflow.model.trainingplan.ExerciseTrainingUnit;
import com.fitflow.model.trainee.Progression;
import com.fitflow.model.dto.AddProgressionRequest;
import com.fitflow.model.projection.ProgressionResponse;
import com.fitflow.model.exceptions.EntityNotFoundException;
import com.fitflow.repository.ExerciseTrainingUnitRepository;
import com.fitflow.repository.ProgressionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseTrainingUnitService {

    private final ExerciseTrainingUnitRepository exerciseTrainingUnitRepository;
    private final ProgressionRepository progressionRepository;


    public ProgressionResponse addProgressionToExerciseTrainingUnit(Long id, AddProgressionRequest addProgressionRequest) {
        var exerciseTrainingUnit = exerciseTrainingUnitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        ExerciseTrainingUnit.ENTITY_NAME, "id", id.toString()
                ));

        var progression = new Progression();

        progression.setWeight(addProgressionRequest.getWeight());
        progression.setNumberOfRepetitions(addProgressionRequest.getNumberOfRepetitions());
        progression.setNumberOfSets(addProgressionRequest.getNumberOfSets());
        progression.setExerciseTrainingUnit(exerciseTrainingUnit);
        return progressionRepository.save(progression).toResponse();
    }
}
