package com.fitflow.service;

import com.fitflow.model.dto.AddBodyMeasurementRequest;
import com.fitflow.model.dto.AddNewTraineeRequest;
import com.fitflow.model.dto.AddReportRequest;
import com.fitflow.model.dto.StartMentorshipRequest;
import com.fitflow.model.dto.TrainingPlanDto;
import com.fitflow.model.dto.TrainingPlanRequest;
import com.fitflow.model.dto.UpdateTraineeRequest;
import com.fitflow.model.exceptions.EntityNotFoundException;
import com.fitflow.model.projection.DefaultTrainingPlanProjection;
import com.fitflow.model.projection.MentorshipResponse;
import com.fitflow.model.projection.ReportResponse;
import com.fitflow.model.projection.TraineeResponse;
import com.fitflow.model.report.Report;
import com.fitflow.model.trainee.BodyPartMeasurement;
import com.fitflow.model.trainee.Trainee;
import com.fitflow.model.trainer.Mentorship;
import com.fitflow.model.trainer.Trainer;
import com.fitflow.model.trainingplan.Exercise;
import com.fitflow.model.trainingplan.ExerciseTrainingUnit;
import com.fitflow.model.trainingplan.TrainingPlan;
import com.fitflow.model.trainingplan.TrainingUnit;
import com.fitflow.repository.BodyMeasurementRepository;
import com.fitflow.repository.BodyPartRepository;
import com.fitflow.repository.ExerciseRepository;
import com.fitflow.repository.ExerciseTrainingUnitRepository;
import com.fitflow.repository.MentorshipRepository;
import com.fitflow.repository.ReportRepository;
import com.fitflow.repository.TraineeRepository;
import com.fitflow.repository.TrainerRepository;
import com.fitflow.repository.TrainingPlanRepository;
import com.fitflow.repository.TrainingUnitRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TraineeService {
    private final TraineeRepository traineeRepository;
    private final TrainingPlanRepository trainingPlanRepository;
    private final ExerciseRepository exerciseRepository;
    private final TrainingUnitRepository trainingUnitRepository;
    private final ExerciseTrainingUnitRepository exerciseTrainingUnitRepository;
    private final BodyMeasurementRepository bodyMeasurementRepository;
    private final BodyPartRepository bodyPartRepository;
    private final TrainerRepository trainerRepository;
    private final MentorshipRepository mentorshipRepository;
    private final ReportRepository reportRepository;
    private final ModelMapper modelMapper;

    public void addBodyMeasurements(Long traineeId, AddBodyMeasurementRequest request) {
        var trainee = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        Trainee.ENTITY_NAME, "id", traineeId.toString()
                ));

        var bodyMeasurement = createBodyMeasurementFromRequest(request);
        bodyMeasurement.setTrainee(trainee);
        bodyMeasurementRepository.save(bodyMeasurement);
    }

    public BodyPartMeasurement createBodyMeasurementFromRequest(AddBodyMeasurementRequest request) {
        var bodyMeasurement = new BodyPartMeasurement();
        var bodyPart = bodyPartRepository.findByName(request.getBodyPart())
                .orElseThrow(() -> new EntityNotFoundException(
                        "BodyPart", "name", request.getBodyPart()
                ));

        bodyMeasurement.setCircumference(request.getCircumference());
        bodyMeasurement.setBodyPart(bodyPart);
        bodyMeasurement.setDate(request.getDate());
        return bodyMeasurement;
    }

    public TraineeResponse saveTrainee(Trainee trainee) {
        return mapToTraineeResponse(traineeRepository.save(trainee));
    }

    public TraineeResponse findById(Long id) {
        return traineeRepository.findTraineeById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        Trainee.ENTITY_NAME, "id", id.toString()
                ));
    }

    @Transactional
    public TraineeResponse updateTrainee(UpdateTraineeRequest request, Long id) {
        var trainee = traineeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        Trainee.ENTITY_NAME, "id", id.toString()
                ));
        createTraineeFromRequest(request, trainee);
        return mapToTraineeResponse(traineeRepository.save(trainee));
    }

    private static void createTraineeFromRequest(UpdateTraineeRequest request, Trainee trainee) {
        trainee.setFirstName(request.getFirstName());
        trainee.setLastName(request.getLastName());
        trainee.setEmail(request.getEmail());
        trainee.setWeightInGrams(request.getWeightInGrams());
        trainee.setHeightInCentimeters(request.getHeightInCentimeters());
    }

    public List<TraineeResponse> findAllTrainees() {
        return traineeRepository.findAllBy();
    }

    @Transactional
    public DefaultTrainingPlanProjection addTrainingPlan(TrainingPlanRequest trainingPlanRequest, Long traineeId) {

        var trainee = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        Trainee.ENTITY_NAME, "id", traineeId.toString()
                ));

        var trainingPlan = createTrainingPlanFromRequest(trainingPlanRequest, trainee);
        var savedTrainingPlan = trainingPlanRepository.saveAndFlush(trainingPlan);
        for (var trainingUnitRequest : trainingPlanRequest.getTrainingUnits()) {
            trainingPlan.addTrainingUnit(createTrainingUnitFromRequest(savedTrainingPlan, trainingUnitRequest));
        }
        return savedTrainingPlan.toResponse();
    }

    private TrainingUnit createTrainingUnitFromRequest(TrainingPlan trainingPlan, TrainingPlanRequest.TrainingUnitRequest trainingUnitRequest) {
        var trainingUnit = new TrainingUnit();
        trainingUnit.setName(trainingUnitRequest.getName());
        trainingUnit.setTips(trainingUnitRequest.getTips());
        trainingUnit.setTrainingPlan(trainingPlan);
        trainingUnit = trainingUnitRepository.save(trainingUnit); // Save the trainingUnit first to generate its ID

        for (var exerciseTrainingUnitRequest : trainingUnitRequest.getExerciseTrainingUnits()) {
            ExerciseTrainingUnit exerciseTrainingUnit = new ExerciseTrainingUnit();
            exerciseTrainingUnit.setNumberOfSets(exerciseTrainingUnitRequest.getNumberOfSets());
            exerciseTrainingUnit.setNumberOfRepetitions(exerciseTrainingUnitRequest.getNumberOfRepetitions());
            Exercise exercise = exerciseRepository.findByName(exerciseTrainingUnitRequest.getExercise().getName())
                    .orElseThrow(() -> new EntityNotFoundException(
                            Exercise.ENTITY_NAME, "name", exerciseTrainingUnitRequest.getExercise().getName()
                    ));
            exerciseTrainingUnit.setExercise(exercise);
            exerciseTrainingUnit.setTrainingUnit(trainingUnit); // Set the trainingUnit to the saved trainingUnit
            var savedExerciseTrainingUnit = exerciseTrainingUnitRepository.save(exerciseTrainingUnit);
            trainingUnit.addExerciseTrainingUnit(savedExerciseTrainingUnit);
        }

        return trainingUnit;
    }


    private static TrainingPlan createTrainingPlanFromRequest(TrainingPlanRequest trainingPlanRequest, Trainee trainee) {
        TrainingPlan trainingPlan = new TrainingPlan();
        trainingPlan.setName(trainingPlanRequest.getName());
        trainingPlan.setDescription(trainingPlanRequest.getDescription());
        trainingPlan.setStartDate(trainingPlanRequest.getStartDate());
        trainingPlan.setEndDate(trainingPlanRequest.getEndDate());
        trainingPlan.setTrainee(trainee);
        return trainingPlan;
    }


    private TraineeResponse mapToTraineeResponse(Trainee savedTrainee) {
        return new TraineeResponse() {
            public Long getId() {
                return savedTrainee.getId();
            }

            public String getFirstName() {
                return savedTrainee.getFirstName();
            }

            public String getLastName() {
                return savedTrainee.getLastName();
            }

            public String getEmail() {
                return savedTrainee.getEmail();
            }

            @Override
            public int getWeightInGrams() {
                return savedTrainee.getWeightInGrams();
            }

            @Override
            public int getHeightInCentimeters() {
                return savedTrainee.getHeightInCentimeters();
            }
        };
    }

    public MentorshipResponse startMentorship(Long traineeId, StartMentorshipRequest startMentorshipRequest) {
        var trainee = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        Trainee.ENTITY_NAME, "id", traineeId.toString()
                ));
        var trainer = trainerRepository.findById(startMentorshipRequest.getTrainerId())
                .orElseThrow(() -> new EntityNotFoundException(
                        Trainer.ENTITY_NAME, "id", startMentorshipRequest.getTrainerId().toString()
                ));

        var mentorship = new Mentorship();
        mentorship.setTrainee(trainee);
        mentorship.setTrainer(trainer);
        mentorship.setStartDate(startMentorshipRequest.getStartDate());
        mentorship.setEndDate(startMentorshipRequest.getEndDate());
        mentorship.setPrice(startMentorshipRequest.getPrice());
        mentorshipRepository.save(mentorship);
        return mentorship.toResponse();
    }

    public Report addReport(Long traineeId, AddReportRequest request) {
        var trainee = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        Trainee.ENTITY_NAME, "id", traineeId.toString()
                ));
        Report report = createReportFromRequest(request, trainee);
        return reportRepository.save(report);
    }

    private static Report createReportFromRequest(AddReportRequest request, Trainee trainee) {
        var report = new Report();
        report.setTrainee(trainee);
        report.setDate(request.getDate());
        report.setDescription(request.getDescription());
        report.setTrainee(trainee);
        return report;
    }

    public List<DefaultTrainingPlanProjection> getTrainingPlans(Long traineeId) {
        var trainee = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        Trainee.ENTITY_NAME, "id", traineeId.toString()
                ));
        return trainee.getTrainingPlans().stream()
                .map(TrainingPlan::toResponse)
                .toList();
    }

    public TrainingPlanDto getCurrentTrainingPlan(Long traineeId) {
        var trainee = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        Trainee.ENTITY_NAME, "id", traineeId.toString()
                ));
        return trainingPlanRepository.findLatestByTraineeId(trainee.getId())
                .map(tp -> modelMapper.map(tp, TrainingPlanDto.class))
                .orElseThrow(() -> new EntityNotFoundException(
                        TrainingPlan.ENTITY_NAME, "traineeId", traineeId.toString()
                ));
    }

    public List<ReportResponse> getReports(Long traineeId) {
        var trainee = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        Trainee.ENTITY_NAME, "id", traineeId.toString()
                ));
        return trainee.getReports().stream()
                .map(Report::toResponse)
                .toList();
    }

    public ReportResponse getCurrentReport(Long traineeId) {
        var trainee = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        Trainee.ENTITY_NAME, "id", traineeId.toString()
                ));
        return reportRepository.findFirstByTrainee_IdOrderByDateDesc(trainee.getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        Report.ENTITY_NAME, "traineeId", traineeId.toString()
                ));
    }

    public MentorshipResponse getCurrentMentorship(Long traineeId) {
        var trainee = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        Trainee.ENTITY_NAME, "id", traineeId.toString()
                ));
        return mentorshipRepository.findFirstByTrainee_IdOrderByStartDateDesc(trainee.getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        Mentorship.ENTITY_NAME, "traineeId", traineeId.toString()
                ));
    }

    @Transactional
    public TraineeResponse saveTrainee(AddNewTraineeRequest request) {
        Trainee trainee = createTraineeFromRequest(request);
        return mapToTraineeResponse(traineeRepository.save(trainee));
    }

    private static Trainee createTraineeFromRequest(AddNewTraineeRequest request) {
        var trainee = new Trainee();
        trainee.setFirstName(request.getFirstName());
        trainee.setLastName(request.getLastName());
        trainee.setEmail(request.getEmail());
        trainee.setWeightInGrams(request.getWeightInGrams());
        trainee.setHeightInCentimeters(request.getHeightInCentimeters());
        return trainee;
    }

    @Transactional
    public void deleteTrainee(Long traineeId) {
        var trainee = traineeRepository.findById(traineeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        Trainee.ENTITY_NAME, "id", traineeId.toString()
                ));
        trainee.setDeleted(true);
        traineeRepository.save(trainee);
    }
}

