package com.fitflow.mapping;

import com.fitflow.model.dto.TraineeDto;
import com.fitflow.model.projection.TraineeResponse;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class TraineeToDtoConverter implements Converter<TraineeResponse, TraineeDto> {
    @Override
    public TraineeDto convert(MappingContext<TraineeResponse, TraineeDto> mappingContext) {
        TraineeDto traineeDto = TraineeDto.builder()
                .traineeId(mappingContext.getSource().getId())
                .firstName(mappingContext.getSource().getFirstName())
                .lastName(mappingContext.getSource().getLastName())
                .email(mappingContext.getSource().getEmail())
                .heightInCentimeters(mappingContext.getSource().getHeightInCentimeters())
                .weightInGrams(mappingContext.getSource().getWeightInGrams())
                .build();
        traineeDto.add(linkTo(methodOn(com.fitflow.controller.TraineeController.class).getTraineeById(mappingContext.getSource().getId())).withRel("self"));
        traineeDto.add(linkTo(methodOn(com.fitflow.controller.TraineeController.class).getTrainees()).withRel("trainees"));
        traineeDto.add(linkTo(methodOn(com.fitflow.controller.TraineeController.class).getTrainingPlans(mappingContext.getSource().getId())).withRel("trainingPlans"));
        traineeDto.add(linkTo(methodOn(com.fitflow.controller.TraineeController.class).getReports(mappingContext.getSource().getId())).withRel("reports"));
        traineeDto.add(linkTo(methodOn(com.fitflow.controller.TraineeController.class).getCurrentTrainingPlan(mappingContext.getSource().getId())).withRel("currentTrainingPlan"));
        traineeDto.add(linkTo(methodOn(com.fitflow.controller.TraineeController.class).getCurrentReport(mappingContext.getSource().getId())).withRel("currentReport"));
        return traineeDto;
    }
}
