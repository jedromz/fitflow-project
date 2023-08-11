package com.fitflow.mapping;

import com.fitflow.controller.TrainingPlanController;
import com.fitflow.model.projection.DefaultTrainingPlanProjection;
import com.fitflow.model.dto.TrainingPlanDto;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class TrainingPlanToDtoConverter implements Converter<DefaultTrainingPlanProjection, TrainingPlanDto> {
    @Override
    public TrainingPlanDto convert(MappingContext<DefaultTrainingPlanProjection, TrainingPlanDto> mappingContext) {
        TrainingPlanDto trainingPlanDto = TrainingPlanDto.builder()
                .trainingPlanId(mappingContext.getSource().getId())
                .name(mappingContext.getSource().getName())
                .description(mappingContext.getSource().getDescription())
                .startDate(mappingContext.getSource().getStartDate())
                .endDate(mappingContext.getSource().getEndDate())
                .build();

        trainingPlanDto.add(linkTo(methodOn(TrainingPlanController.class).getTrainingPlanById(mappingContext.getSource().getId())).withRel("self"));
        trainingPlanDto.add(linkTo(methodOn(TrainingPlanController.class).getAllTrainingPlans()).withRel("trainingPlans"));
        return trainingPlanDto;
    }
}
