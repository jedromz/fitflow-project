package com.fitflow.service;

import com.fitflow.model.dto.AddMentorshipRequest;
import com.fitflow.model.exceptions.EntityNotFoundException;
import com.fitflow.model.projection.MentorshipResponse;
import com.fitflow.model.trainee.Trainee;
import com.fitflow.model.trainer.Mentorship;
import com.fitflow.model.trainer.Trainer;
import com.fitflow.repository.MentorshipRepository;
import com.fitflow.repository.TraineeRepository;
import com.fitflow.repository.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MentorshipService {
    private final MentorshipRepository mentorshipRepository;
    private final TraineeRepository traineeRepository;
    private final TrainerRepository trainerRepository;

    public List<MentorshipResponse> findAllMentorships() {
        return mentorshipRepository.findAllBy();
    }

    public MentorshipResponse findMentorshipById(Long id) {
        return mentorshipRepository.findMentorshipById(id)
                .orElseThrow(() -> new EntityNotFoundException(Mentorship.ENTITY_NAME, "id", id.toString()));
    }

    public MentorshipResponse saveMentorship(Mentorship mentorship) {
        return mapToMentorshipResponse(mentorshipRepository.save(mentorship));
    }

    @Transactional
    public MentorshipResponse saveMentorship(AddMentorshipRequest request) {
        var trainee = traineeRepository.findById(request.getTraineeId())
                .orElseThrow(() -> new EntityNotFoundException(Mentorship.ENTITY_NAME, "traineeId", request.getTraineeId().toString()));
        var trainer = trainerRepository.findById(request.getTrainerId())
                .orElseThrow(() -> new EntityNotFoundException(Mentorship.ENTITY_NAME, "trainerId", request.getTrainerId().toString()));
        var mentorship = createMentorship(request, trainee, trainer);
        return mapToMentorshipResponse(mentorshipRepository.save(mentorship));
    }

    private static Mentorship createMentorship(AddMentorshipRequest request, Trainee trainee, Trainer trainer) {
        var mentorship = new Mentorship();
        mentorship.setTrainee(trainee);
        mentorship.setTrainer(trainer);
        mentorship.setStartDate(request.getStartDate());
        mentorship.setEndDate(request.getEndDate());
        return mentorship;
    }

    public MentorshipResponse updateMentorship(Mentorship mentorship) {
        return mapToMentorshipResponse(mentorshipRepository.save(mentorship));
    }

    private MentorshipResponse mapToMentorshipResponse(Mentorship savedMentorship) {
        return new MentorshipResponse() {

            public Long getId() {
                return savedMentorship.getId();
            }

            public LocalDate getStartDate() {
                return savedMentorship.getStartDate();
            }

            public LocalDate getEndDate() {
                return savedMentorship.getEndDate();
            }

            public Integer getPrice() {
                return savedMentorship.getPrice();
            }
        };
    }
}