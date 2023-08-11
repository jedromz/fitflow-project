package com.fitflow.repository;

import com.fitflow.model.projection.ReportResponse;
import com.fitflow.model.report.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<ReportResponse> findAllBy();

    @Query("select r from Report r inner join r.trainee.mentorships mentorships where mentorships.trainer.id = ?1")
    List<ReportResponse> findReportsByTrainer(Long trainerId);

    Optional<ReportResponse> findFirstByTrainee_IdOrderByDateDesc(Long id);

    Optional<ReportResponse> findReportById(Long id);
}