package com.fitflow.service;

import com.fitflow.model.dto.AddCommentRequest;
import com.fitflow.model.exceptions.EntityNotFoundException;
import com.fitflow.model.projection.CommentResponse;
import com.fitflow.model.projection.ReportResponse;
import com.fitflow.model.report.Comment;
import com.fitflow.model.report.Report;
import com.fitflow.repository.CommentRepository;
import com.fitflow.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final CommentRepository commentRepository;

    public List<ReportResponse> findAllReports() {
        return reportRepository.findAllBy();
    }

    public CommentResponse addCommentToReport(Long id, AddCommentRequest addCommentRequest) {
        var report = reportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Comment.ENTITY_NAME, "id", id.toString()));

        var comment = new Comment();
        comment.setDate(addCommentRequest.getDate());
        comment.setText(addCommentRequest.getText());
        comment.setReport(report);
        return commentRepository.save(comment).toResponse();
    }

    public List<CommentResponse> findAllComments(Long id) {
        return commentRepository.findAllByReport_Id(id);
    }

    public ReportResponse findReportById(Long id) {
        return reportRepository.findReportById(id)
                .orElseThrow(() -> new EntityNotFoundException(Report.ENTITY_NAME, "id", id.toString()));
    }
}
