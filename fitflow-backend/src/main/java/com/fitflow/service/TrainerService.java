package com.fitflow.service;

import com.fitflow.model.dto.AddNewTraineeToTrainerRequest;
import com.fitflow.model.exceptions.EntityNotFoundException;
import com.fitflow.model.projection.MentorshipResponse;
import com.fitflow.model.projection.ReportResponse;
import com.fitflow.model.projection.TraineeResponse;
import com.fitflow.model.projection.TrainerResponse;
import com.fitflow.model.trainee.Trainee;
import com.fitflow.model.trainer.Mentorship;
import com.fitflow.model.trainer.Trainer;
import com.fitflow.repository.MentorshipRepository;
import com.fitflow.repository.ReportRepository;
import com.fitflow.repository.TraineeRepository;
import com.fitflow.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerService {
    private final TrainerRepository trainerRepository;
    private final TraineeRepository traineeRepository;
    private final MentorshipRepository mentorshipRepository;
    private final ReportRepository reportRepository;

    @Transactional
    public TrainerResponse saveTrainer(Trainer trainer) {
        Trainer savedTrainer = trainerRepository.save(trainer);
        return mapToTrainerDto(savedTrainer);
    }


    public TrainerResponse findTraineeById(Long id) {
        return trainerRepository.findTrainerById(id)
                .orElseThrow(() -> new EntityNotFoundException(Trainer.ENTITY_NAME, "id", id.toString()));
    }

    public TrainerResponse updateTrainer(Trainer trainer) {
        return mapToTrainerDto(trainerRepository.save(trainer));
    }

    public List<TrainerResponse> findAllTrainers() {
        return trainerRepository.findAllBy();
    }

    public List<TraineeResponse> findTrainerTrainees(Long id) {
        trainerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Trainer.ENTITY_NAME, "id", id.toString()));
        return traineeRepository.findByMentorships_Trainer_Id(id);
    }

    public Page<TraineeResponse> findTrainerTrainees(Long id, Pageable pageable) {
        trainerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Trainer.ENTITY_NAME, "id", id.toString()));
        return traineeRepository.findByMentorships_Trainer_Id(id, pageable);
    }

    public List<MentorshipResponse> findTrainerMentorships(Long id) {
        trainerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Trainer.ENTITY_NAME, "id", id.toString()));
        return mentorshipRepository.findByTrainer_Id(id);
    }

    public List<ReportResponse> findTrainerReports(Long id) {
        var trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Trainer.ENTITY_NAME, "id", id.toString()));
        return reportRepository.findReportsByTrainer(trainer.getId());
    }

    private TraineeResponse mapToTraineeDto(Trainee save) {
        return new TraineeResponse() {
            @Override
            public Long getId() {
                return save.getId();
            }

            @Override
            public String getFirstName() {
                return save.getFirstName();
            }

            @Override
            public String getLastName() {
                return save.getLastName();
            }

            @Override
            public String getEmail() {
                return save.getEmail();
            }

            @Override
            public int getWeightInGrams() {
                return save.getWeightInGrams();
            }

            @Override
            public int getHeightInCentimeters() {
                return save.getHeightInCentimeters();
            }
        };
    }

    private static TrainerResponse mapToTrainerDto(Trainer savedTrainer) {
        return new TrainerResponse() {
            public Long getId() {
                return savedTrainer.getId();
            }

            public String getFirstName() {
                return savedTrainer.getFirstName();
            }

            public String getLastName() {
                return savedTrainer.getLastName();
            }

            public String getEmail() {
                return savedTrainer.getEmail();
            }
        };
    }

    @Transactional
    public TraineeResponse addNewTraineeToTrainer(Long id, AddNewTraineeToTrainerRequest request) {
        var trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Trainer.ENTITY_NAME, "id", id.toString()));
        Trainee trainee = createTrainee(request);
        var savedTrainee = traineeRepository.saveAndFlush(trainee);
        var mentorship = new Mentorship(request.getStartDate(), request.getEndDate(), request.getPrice(), savedTrainee, trainer);
        savedTrainee.getMentorships().add(mentorship);
        mentorshipRepository.saveAndFlush(mentorship);
        return mapToTraineeDto(savedTrainee);
    }


    private static Trainee createTrainee(AddNewTraineeToTrainerRequest request) {
        var trainee = new Trainee();
        trainee.setFirstName(request.getFirstName());
        trainee.setLastName(request.getLastName());
        trainee.setEmail(request.getEmail());
        trainee.setHeightInCentimeters(request.getHeightInCentimeters());
        trainee.setWeightInGrams(request.getWeightInGrams());
        return trainee;
    }
}

